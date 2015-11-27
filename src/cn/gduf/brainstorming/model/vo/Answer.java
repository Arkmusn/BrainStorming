package cn.gduf.brainstorming.model.vo;
/**
 * 回帖表实体类
 */
public class Answer {
	private String answerID;
	private String articleID;
	private String userID;
	private String answerPath;
	private String createTime;
	private int draftFlag;
	private int agreeCounter;
	
	public Answer(){}

	public String getAnswerID() {
		return answerID;
	}

	public void setAnswerID(String answerID) {
		this.answerID = answerID;
	}

	public String getArticleID() {
		return articleID;
	}

	public void setArticleID(String articleID) {
		this.articleID = articleID;
	}

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public String getAnswerPath() {
		return answerPath;
	}

	public void setAnswerPath(String answerPath) {
		this.answerPath = answerPath;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public int getDraftFlag() {
		return draftFlag;
	}

	public void setDraftFlag(int draftFlag) {
		this.draftFlag = draftFlag;
	}

	public int getAgreeCounter() {
		return agreeCounter;
	}

	public void setAgreeCounter(int agreeCounter) {
		this.agreeCounter = agreeCounter;
	}
	
	
}
