package cn.gduf.brainstorming.model.vo;
/**
 * 用户关注专业表实体类
 */
public class Theme {
	private String userID;
	private String majorID;
	
	public Theme(){}

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public String getMajorID() {
		return majorID;
	}

	public void setMajorID(String majorID) {
		this.majorID = majorID;
	}
	
	
}
