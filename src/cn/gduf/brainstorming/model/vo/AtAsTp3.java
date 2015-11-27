package cn.gduf.brainstorming.model.vo;

/**
 * 回复帖子2实体类
 * 
 * @author Arkmusn
 * 
 */
public class AtAsTp3 {
	private Answer answer;
	private Article article;
	private TopicType topicType;

	public AtAsTp3() {
	}

	public Answer getAnswer() {
		return answer;
	}

	public void setAnswer(Answer answer) {
		this.answer = answer;
	}

	public Article getArticle() {
		return article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}

	public TopicType getTopicType() {
		return topicType;
	}

	public void setTopicType(TopicType topicType) {
		this.topicType = topicType;
	}

}
