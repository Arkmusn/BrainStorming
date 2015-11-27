package cn.gduf.brainstorming.model.post.dao;

import java.sql.SQLException;

import cn.gduf.brainstorming.model.vo.Article;

/**
 * @author 集思 发帖接口类
 */
public interface CreatePostDAO {

	/**
	 * 添加新帖子
	 * 
	 * @param article
	 * @throws SQLException
	 */
	public boolean createPost(Article article) throws SQLException;

	/**
	 * 查询最后一位ArticleID
	 * 
	 * @param article
	 *            - Article实体类
	 * @return 最后一位ArticleID
	 * @throws SQLException
	 */
	public String findLastArticleID(Article article) throws SQLException;
}
