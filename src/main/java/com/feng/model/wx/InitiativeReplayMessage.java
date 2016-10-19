package com.feng.model.wx;

/**
 * 主动向用户推送消息model
 * @author Administrator
 *
 */
public class InitiativeReplayMessage {
	
	public InitiativeReplayMessage() {}
	
	public InitiativeReplayMessage(String msgtype, String text, String touser) {
		this.msgtype = msgtype;
		MessageText messageText = new MessageText();
		messageText.setContent(text);
		this.text = messageText;
		this.touser = touser;
	}

	private String msgtype = "text";
	private MessageText text;
	private String touser;
	public String getMsgtype() {
		return msgtype;
	}
	public void setMsgtype(String msgtype) {
		this.msgtype = msgtype;
	}
	public String getTouser() {
		return touser;
	}
	public void setTouser(String touser) {
		this.touser = touser;
	}
	public MessageText getText() {
		return text == null ? new MessageText() : text;
	}
	public void setText(MessageText text) {
		this.text = text;
	}


	public class MessageText{
		private String content;
		public String getContent() {
			return content;
		}
		public void setContent(String content) {
			this.content = content;
		}
	}
}
