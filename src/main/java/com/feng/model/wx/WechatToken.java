package com.feng.model.wx;

import org.joda.time.DateTime;

/**
 * 微信公众号token
 * @author Administrator
 *
 */
public class WechatToken {

	private String access_token;//token
	private Integer expires_in;//有效时间，毫秒
	private Long obtainTimeMillis;//或得此token时的时间——时间戳
	private Long expiresTimeMillis;//此token过期时的时间——时间戳
	
	public String getAccess_token() {
		return access_token;
	}
	public void setAccess_token(String access_token) {
		this.access_token = access_token;
	}
	public Integer getExpires_in() {
		return expires_in;
	}
	public void setExpires_in(Integer expires_in) {
		this.expires_in = expires_in;
	}
	public Long getObtainTimeMillis() {
		return obtainTimeMillis;
	}
	public void setObtainTimeMillis(Long obtainTimeMillis) {
		this.obtainTimeMillis = obtainTimeMillis;
	}
	public Long getExpiresTimeMillis() {
		return expiresTimeMillis;
	}
	public void setExpiresTimeMillis(Long expiresTimeMillis) {
		this.expiresTimeMillis = expiresTimeMillis;
	}
	/**
	 * token是否过期
	 * @return
	 */
	public boolean isExpires() {
		return DateTime.now().getMillis() >= this.expiresTimeMillis ;
	}
	
}