package com.feng.controller.wx;

import java.util.Arrays;
import java.util.HashMap;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.feng.base.BaseController;
import com.feng.model.wx.EventMessage;
import com.feng.service.wx.WeichatReplyService;
import com.feng.util.exception.ExceptionCode;
import com.feng.util.exception.ValidateUtils;
import com.feng.util.weichat.WechatSecretUtils;

@RestController
@RequestMapping("/api/wechat")
public class WechatController extends BaseController{
	
	@Autowired
	private WeichatReplyService weichatReplyService;
	
	private String wxToken = "fengshuaiju";

	/**
	 * get方法用于测试微信服务器是否能正常回调
	 * @param values
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/event", method=RequestMethod.GET)
	public String verfiyEventMessage(@RequestParam HashMap<String, String> values) throws Exception {
        if (isFromWeixin(values)) {
            return values.get("echostr");
        }
        return null;
    }
	/**
	 * 验证消息是否来自微信
	 * @param values
	 * @return
	 */
	private boolean isFromWeixin(HashMap<String, String> values) {
        String signature = values.get("signature");
        String createdSign = new String();

        String[] vals = {values.get("timestamp"), values.get("nonce"), wxToken};
        Arrays.sort(vals);
        for (String s : vals) {
            createdSign = createdSign.concat(s);
        }

        if (WechatSecretUtils.getSha1(createdSign).equals(signature)) {
            return Boolean.TRUE;
        }

        return Boolean.FALSE;
    }
	
	@RequestMapping(value = "/event", method=RequestMethod.POST)
	public void eventMessage(@RequestParam HashMap<String, String> values,
			@RequestBody EventMessage eventMessage, HttpServletResponse response) throws Exception {
		
		ValidateUtils.notNull(eventMessage, ExceptionCode.wx_EVENT_MESSAGE_IS_NULL);
		
		ValidateUtils.isTrue(isFromWeixin(values), ExceptionCode.wx_MESSAGE_NOT_FROM_WEIXIN);
		
		loger.debug(JSON.toJSONString(eventMessage));
		
		String msgType = eventMessage.getMsgType();
		
		switch (msgType) {
		case "text":
			weichatReplyService.textReply(eventMessage,response);
			break;

		case "event"://事件
			weichatReplyService.eventReply(eventMessage,response);
			break;
			
		default:
			weichatReplyService.defaultReply(eventMessage,response);
			break;
		}
	}
		
}