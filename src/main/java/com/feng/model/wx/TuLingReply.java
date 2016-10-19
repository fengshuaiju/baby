package com.feng.model.wx;

/**
 * 图灵机器人回复Model
 * @author Administrator
 *
 */
public class TuLingReply {

	private String code;
	private String text;
	
	public static final String RETURN_CODE = "100000";
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
}
