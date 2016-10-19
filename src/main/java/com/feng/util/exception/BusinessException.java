package com.feng.util.exception;

public class BusinessException extends RuntimeException{

	private static final long serialVersionUID = -6972322936634761970L;
	
	private String errMessage;
	private String errCode;
	private String info;
	
	public BusinessException(){
	}

	public BusinessException(ExceptionCode exceptionCode,String info){
		this.errMessage = exceptionCode.getErrMessage();
		this.errCode = exceptionCode.getErrCode();
		this.info = info;
	}
	
	public BusinessException(ExceptionCode exceptionCode){
		this.errMessage = exceptionCode.getErrMessage();
		this.errCode = exceptionCode.getErrCode();
	}
	
	public BusinessException(String errMessage, String errCode) {
		this.errMessage = errMessage;
		this.errCode = errCode;
	}

	public String getErrMessage() {
		return errMessage;
	}

	public void setErrMessage(String errMessage) {
		this.errMessage = errMessage;
	}

	public String getErrCode() {
		return errCode;
	}

	public void setErrCode(String errCode) {
		this.errCode = errCode;
	}

	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}

}
