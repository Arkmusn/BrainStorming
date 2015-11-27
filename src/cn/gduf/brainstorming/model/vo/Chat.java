package cn.gduf.brainstorming.model.vo;
/**
 * 私信表实体类
 */
public class Chat {
	private String chatID;
	private String sendID;
	private String receiveID;
	private String textPath;
	private String chatTime;
	
	public Chat(){}

	public String getChatID() {
		return chatID;
	}

	public void setChatID(String chatID) {
		this.chatID = chatID;
	}

	public String getSendID() {
		return sendID;
	}

	public void setSendID(String sendID) {
		this.sendID = sendID;
	}

	public String getReceiveID() {
		return receiveID;
	}

	public void setReceiveID(String receiveID) {
		this.receiveID = receiveID;
	}

	public String getTextPath() {
		return textPath;
	}

	public void setTextPath(String textPath) {
		this.textPath = textPath;
	}

	public String getChatTime() {
		return chatTime;
	}

	public void setChatTime(String chatTime) {
		this.chatTime = chatTime;
	}
	
	
}
