package com.feng.service.wx;

import javax.servlet.http.HttpServletResponse;

import com.feng.model.wx.EventMessage;

public interface WeichatReplyService {

	/**
	 * 被动回复消息-文本类回复
	 * @param eventMessage
	 * @param response 
	 */
	void textReply(EventMessage eventMessage, HttpServletResponse response);

	/**
	 * 被动回复消息-默认回复，不支持的消息格式
	 * @param eventMessage 
	 * @param response
	 */
	void defaultReply(EventMessage eventMessage, HttpServletResponse response);

	/**
	 * 事件类型回复
	 * @param eventMessage
	 * @param response
	 */
	void eventReply(EventMessage eventMessage, HttpServletResponse response);

	/**
	 * 主动向用户推送消息
	 * @param openId
	 * @param text
	 */
	void initiativeTextReply(String openId,String text);
}
