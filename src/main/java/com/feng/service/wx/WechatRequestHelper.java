package com.feng.service.wx;

import com.feng.model.wx.WechatUserInfo;

public interface WechatRequestHelper {

	/**
	 * 获取微信用户信息
	 * @param openId
	 * @return
	 */
	WechatUserInfo getWechatUserInfo(String openId);

	/**
	 * 主动向用户推送消息
	 * @param openId
	 * @param text
	 */
	void initiativeTextReply(String openId, String text);
}