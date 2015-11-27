package cn.gduf.brainstorming.model.vo;
/**
 * 帖子表实体类
 */
public class Article {
	private String articleID;
	private String articleURL;
	private String userID;
	private int typeID;
	private int browseCounter;
	private int answerCounter;
	private String createTime;
	private String  textPath;
	private String fileID;
	private int draftFlag;
	private int agreeCounter;
	private String articleTitle;
	
	public Article(){}

	public String getArticleID() {
		return articleID;
	}

	public void setArticleID(String articleID) {
		this.articleID = articleID;
	}

	public String getArticleURL() {
		return articleURL;
	}

	public void setArticleURL(String articleURL) {
		this.articleURL = articleURL;
	}

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public int getTypeID() {
		return typeID;
	}

	public void setTypeID(int typeID) {
		this.typeID = typeID;
	}

	public int getBrowseCounter() {
		return browseCounter;
	}

	public void setBrowseCounter(int browseCounter) {
		this.browseCounter = browseCounter;
	}

	public int getAnswerCounter() {
		return answerCounter;
	}

	public void setAnswerCounter(int answerCounter) {
		this.answerCounter = answerCounter;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getTextPath() {
		return textPath;
	}

	public void setTextPath(String textPath) {
		this.textPath = textPath;
	}

	public String getFileID() {
		return fileID;
	}

	public void setFileID(String fileID) {
		this.fileID = fileID;
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

	public String getArticleTitle() {
		return articleTitle;
	}

	public void setArticleTitle(String articleTitle) {
		this.articleTitle = articleTitle;
	}
	
	
}
