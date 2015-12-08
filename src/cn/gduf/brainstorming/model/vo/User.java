package cn.gduf.brainstorming.model.vo;

import java.util.Date;

/**
 * �û���ʵ����
 * 
 */
public class User {
	private String userID;
	private String userName;
	private String userPassword;
	private String userEmail;
	private String shoolID;
	private String majorID;
	private String introducePath;
	private String picturePath;
	private Date createTime;

	public User() {
	}

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getShoolID() {
		return shoolID;
	}

	public void setShoolID(String shoolID) {
		this.shoolID = shoolID;
	}

	public String getMajorID() {
		return majorID;
	}

	public void setMajorID(String majorID) {
		this.majorID = majorID;
	}

	public String getIntroducePath() {
		return introducePath;
	}

	public void setIntroducePath(String introducePath) {
		this.introducePath = introducePath;
	}

	public String getPicturePath() {
		return picturePath;
	}

	public void setPicturePath(String picturePath) {
		this.picturePath = picturePath;
	}

	public final Date getCreateTime() {
		return createTime;
	}

	public final void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

}
