package com.feng.util.exception;

public enum ExceptionCode {
	
	//COMMON
	UNKNOWN("000000","you want is not get"),
	UPLOAD_FAIL("000001","upload fail is fail"),
	
	//USER
	user_USERNAME_PASSWORD_WRONG("001001","username or password is wrong"),
	user_USERID_IS_NULL("001002","user id is null"),
	
	//weixin
	wx_EVENT_MESSAGE_IS_NULL("002001","event message is null"),
	wx_MESSAGE_NOT_FROM_WEIXIN("002002","message not from weixin"),
	wx_TOKEN_ERROR("002003", "get wechat access_token error");
	
	ExceptionCode(String errCode , String errMessage){
		this.errCode = errCode;
		this.errMessage = errMessage;
	}
	
	private String errCode;
	private String errMessage;
	public String getErrCode() {
		return errCode;
	}
	public void setErrCode(String errCode) {
		this.errCode = errCode;
	}
	public String getErrMessage() {
		return errMessage;
	}
	public void setErrMessage(String errMessage) {
		this.errMessage = errMessage;
	}
}
