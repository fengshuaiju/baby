package com.feng.util.weichat;

import com.alibaba.fastjson.JSON;
import com.feng.model.wx.TuLingAsk;
import com.feng.model.wx.TuLingReply;
import com.github.kevinsawicki.http.HttpRequest;

/**
 * 图灵助手
 * @author Administrator
 *
 */
public class TuLingHelper {
	
	private static final String APIURL = "http://www.tuling123.com/openapi/api";
	private static final String KRY = "c72b7017ca7c48ed95505bdd0ecce9eb";
	
	public static TuLingReply getTlReply(String info){
		
		TuLingAsk ask = new TuLingAsk(KRY,info);
		
		String jsonString = JSON.toJSONString(ask);
		String reply = HttpRequest.post(APIURL)
				.header("Content-Type", "application/json")
				.acceptJson()
				.send(jsonString).body();
		TuLingReply tuLingReply = JSON.parseObject(reply, TuLingReply.class);
		
		return tuLingReply;
	}
	
}
