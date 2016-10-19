package com.feng.model.wx;

/**
 * 图灵机器人请求Model
 * @author Administrator
 *
 */
public class TuLingAsk {
	
	private String key;
	private String info;
	
	public TuLingAsk(){}
	
	public TuLingAsk(String key, String info) {
		this.key = key;
		this.info = info;
	}

	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
}
