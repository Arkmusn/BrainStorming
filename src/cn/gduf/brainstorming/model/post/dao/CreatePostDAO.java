package cn.gduf.brainstorming.model.post.dao;

import java.sql.SQLException;

import cn.gduf.brainstorming.model.vo.Article;

/**
 * @author ��˼ �����ӿ���
 */
public interface CreatePostDAO {

	/**
	 * ���������
	 * 
	 * @param article
	 * @throws SQLException
	 */
	public boolean createPost(Article article) throws SQLException;

	/**
	 * ��ѯ���һλArticleID
	 * 
	 * @param article
	 *            - Articleʵ����
	 * @return ���һλArticleID
	 * @throws SQLException
	 */
	public String findLastArticleID(Article article) throws SQLException;
}
