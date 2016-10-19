package com.feng.model.wx;

/**
 * 微信错误消息model
 * @author Administrator
 *
 */
public class WechatError {
	
	private Integer errcode;
	private String errmsg;
	
	public Integer getErrcode() {
		return errcode;
	}
	public void setErrcode(Integer errcode) {
		this.errcode = errcode;
	}
	public String getErrmsg() {
		return errmsg;
	}
	public void setErrmsg(String errmsg) {
		this.errmsg = errmsg;
	}
	
}