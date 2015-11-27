package cn.gduf.brainstorming.model.vo;
/**
 * 帖子话题用户3实体类
 */
public class AtTpUs3 {
	private Article article;
	private TopicType topic;
	private User user;
	
	public AtTpUs3(){}

	public Article getArticle() {
		return article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}

	public TopicType getTopic() {
		return topic;
	}

	public void setTopic(TopicType topic) {
		this.topic = topic;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
}
