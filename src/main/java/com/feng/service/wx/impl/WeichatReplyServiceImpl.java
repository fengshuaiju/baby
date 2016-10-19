package com.feng.service.wx.impl;

import java.io.OutputStream;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.feng.base.BaseService;
import com.feng.model.wx.EventMessage;
import com.feng.model.wx.EventMessageType;
import com.feng.model.wx.TuLingReply;
import com.feng.service.wx.WechatRequestHelper;
import com.feng.service.wx.WeichatReplyService;
import com.feng.util.weichat.TuLingHelper;

@Service
public class WeichatReplyServiceImpl extends BaseService implements WeichatReplyService {
	
	@Autowired
	private WechatRequestHelper wechatRequestHelper;

	@Override
	public void textReply(EventMessage eventMessage, HttpServletResponse response) {

		// 返回给服务器的信息
		String replayMessage = "";

		String content = eventMessage.getContent();
		TuLingReply tlReply = TuLingHelper.getTlReply(content);

		//目前只支持文本回复一种
		if (TuLingReply.RETURN_CODE.equals(tlReply.getCode())) {
			replayMessage = tlReply.getText();
		} else {
			replayMessage = "静静说，她想一个人静静！！！";
		}

		replyTextMessage(eventMessage,response,replayMessage);
		
	}

	@Override
	public void defaultReply(EventMessage eventMessage,HttpServletResponse response) {

		// 返回给服务器的信息
		String replayMessage = "小静不想理你，并向你扔了一只狗！！！/::D";
		
		replyTextMessage(eventMessage,response,replayMessage);
	}

	@Override
	public void eventReply(EventMessage eventMessage, HttpServletResponse response) {
		String event = eventMessage.getEvent();
		
		switch (event) {
		case EventMessageType.SUBSCRIBE:
			
			//判断用户是否存在，如果不存在创建用户，如果存在谢谢再次关注
			String fromUserName = eventMessage.getFromUserName();
			System.out.println(fromUserName);
			
			String subscribeReply = "谢谢你关注我，么么哒！！！/::*";
			replyTextMessage(eventMessage,response,subscribeReply);
			
			break;
			
		case EventMessageType.UNSUBSCRIBE:
			
			String unsubscribeReply = "记得我，再来啊！！！";
			System.out.println(unsubscribeReply);
			replyTextMessage(eventMessage,response,unsubscribeReply);
			System.out.println(unsubscribeReply+"sssssss");
			break;

		default:
			break;
		}
	}
	
	@Override
	public void initiativeTextReply(String openId, String text) {
		wechatRequestHelper.initiativeTextReply(openId, text);
	}
	
	/**
	 * 被动回复文本消息
	 * @param eventMessage 
	 * @param response 
	 * @param replayMessage 要发送的信息
	 */
	private void replyTextMessage(EventMessage eventMessage, HttpServletResponse response,String replayMessage){
		
		String toUser = eventMessage.getFromUserName();
		String fromUser = eventMessage.getToUserName();
		
		String returnValue = "<xml><ToUserName><![CDATA[" + toUser + "]]></ToUserName><FromUserName><![CDATA["
				+ fromUser + "]]></FromUserName><CreateTime>" + System.currentTimeMillis()
				+ "</CreateTime><MsgType><![CDATA[text]]></MsgType><Content><![CDATA[" + replayMessage + "]]></Content></xml>";
		try {
			OutputStream outputStream = response.getOutputStream();
			outputStream.write(returnValue.getBytes());
			outputStream.close();
		} catch (Exception e) {
			loger.debug(e.getMessage());
		}
	}
	
}