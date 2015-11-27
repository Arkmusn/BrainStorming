package cn.gduf.brainstorming.model.vo;
/**
 * 附件表实体类
 */
public class Addfile {
	private String fileID;
	private String filePath;
	private String articleID;
	private String saveTime;
	
	public Addfile(){}

	public String getFileID() {
		return fileID;
	}

	public void setFileID(String fileID) {
		this.fileID = fileID;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public String getArticleID() {
		return articleID;
	}

	public void setArticleID(String articleID) {
		this.articleID = articleID;
	}

	public String getSaveTime() {
		return saveTime;
	}

	public void setSaveTime(String saveTime) {
		this.saveTime = saveTime;
	}
	
	
}
