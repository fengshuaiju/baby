package com.feng.service.wx.impl;

import java.util.HashMap;
import java.util.Map;

import org.joda.time.DateTime;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.feng.base.BaseComponent;
import com.feng.model.wx.InitiativeReplayMessage;
import com.feng.model.wx.WechatError;
import com.feng.model.wx.WechatToken;
import com.feng.model.wx.WechatUserInfo;
import com.feng.service.wx.WechatRequestHelper;
import com.feng.util.exception.ExceptionCode;
import com.feng.util.exception.ValidateUtils;
import com.github.kevinsawicki.http.HttpRequest;

/**
 * 系统与微信服务器交互助手
 * @author Administrator
 *
 */
@Service
public class WechatRequestHelperImpl extends BaseComponent implements WechatRequestHelper{
	
	//用来存储token信息
	private static WechatToken token = null;
	
	//AppId sercet
	private String appID = "wxd5862fe4b5068c5d";
	private String appsecret = "ff985e2b30b9d7b37ed9bd9556a368bc";
	
	// 获取公众号Tokenhttp请求方式: GET
	// https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET
	private static final String getAccessTokenBaseUrl = "https://api.weixin.qq.com/cgi-bin/token";

	//获取用户基本信息	http请求方式: GET
	//https://api.weixin.qq.com/cgi-bin/user/info?access_token=ACCESS_TOKEN&openid=OPENID&lang=zh_CN
	private static final String getUserInfoBaseUrl = "https://api.weixin.qq.com/cgi-bin/user/info";

	//客服消息推送接口，主动向用户发送消息
	//https://api.weixin.qq.com/cgi-bin/message/custom/send?access_token=ACCESS_TOKEN
	private static final String customerServiceUrl = "https://api.weixin.qq.com/cgi-bin/message/custom/send";
	
	//获取公众号Token
	private String getAccessToken(){
		String accessToken = "";
		
		//如果token未获取或者是失效，那么就获取token
		if(token==null || token.isExpires()){
			token = new WechatToken();
			Map<String, String> params = new HashMap<>();
			params.put("grant_type", "client_credential");
			params.put("appid", appID);
			params.put("secret", appsecret);
			String returnRequest = HttpRequest.get(getAccessTokenBaseUrl, params, false).body();
			
			WechatError parseObject = JSONObject.parseObject(returnRequest, WechatError.class);
			
			if(parseObject.getErrcode()!=null){
				ValidateUtils.isTrue(false, ExceptionCode.wx_MESSAGE_NOT_FROM_WEIXIN, returnRequest);
			}
			
			token = JSON.parseObject(returnRequest, WechatToken.class);
			token.setObtainTimeMillis(DateTime.now().getMillis());
			token.setExpiresTimeMillis(DateTime.now().plusMinutes(90).getMillis());
		}
		
		accessToken = token.getAccess_token();
		
		return accessToken;
	}
	
	
	//获取微信用户信息
	@Override
	public WechatUserInfo getWechatUserInfo(String openId){
		//osHNcwZkECtWUBNaYJTd7mKn_3Eg
		String accessToken = this.getAccessToken();
		
		WechatUserInfo info = new WechatUserInfo();
		
		Map<String, String> params = new HashMap<>();
		params.put("lang", "zh_CN");
		params.put("access_token", accessToken);
		params.put("openid", openId);
		
		String returnRequest = HttpRequest.get(getUserInfoBaseUrl, params, false).body();
		
		info = JSON.parseObject(returnRequest, WechatUserInfo.class);
		
		System.out.println(JSON.toJSONString(info));
		loger.debug(JSON.toJSONString(info));
		
		return info;
	}
	
	@Override
	public void initiativeTextReply(String openId, String text) {
		InitiativeReplayMessage message = new InitiativeReplayMessage("text", text, openId);
		String accessToken = this.getAccessToken();
		
		String messageJson = JSON.toJSONString(message);
		
		Map<String,String> parameter = new HashMap<>();
		parameter.put("access_token", accessToken);
		String returnInfo = HttpRequest.post(customerServiceUrl,parameter,false)
				.header("Content-Type", "application/json")
				.acceptJson().send(messageJson).body();
		
		WechatError parseObject = JSONObject.parseObject(returnInfo, WechatError.class);
		
		ValidateUtils.isTrue(parseObject.getErrcode() == 0, returnInfo);
	}
}