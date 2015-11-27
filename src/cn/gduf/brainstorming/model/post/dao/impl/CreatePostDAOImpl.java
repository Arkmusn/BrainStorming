package cn.gduf.brainstorming.model.post.dao.impl;

/**
 * @author 集思
 * 发帖接口实现类
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import cn.gduf.brainstorming.model.post.dao.CreatePostDAO;
import cn.gduf.brainstorming.model.vo.Article;

public class CreatePostDAOImpl implements CreatePostDAO {

	private Connection conn = null;
	private PreparedStatement ps = null;

	/**
	 * 建立数据库连接
	 * 
	 * @param conn
	 */
	public CreatePostDAOImpl(Connection conn) {
		this.conn = conn;
	}

	/**
	 * 添加新帖子
	 * 
	 * @param article
	 * @throws SQLException
	 */
	@Override
	public boolean createPost(Article article) throws SQLException {
		/*
		 * 添加帖子记录 封装帖子ID，帖子URL，帖子标题，发帖人ID，帖子类型ID，正文，草稿标记为0
		 */
		boolean flag = false;

		String sql = "insert into article(articleID,articleURL,articleTitle,userID,typeID,textPath) "
				+ "values(?,?,?,?,?,?)";

		ps = conn.prepareStatement(sql);

		ps.setString(1, article.getArticleID());
		ps.setString(2, article.getArticleURL());
		ps.setString(3, article.getArticleTitle());
		ps.setString(4, article.getUserID());
		ps.setInt(5, article.getTypeID());
		ps.setString(6, article.getTextPath());

		int count = ps.executeUpdate();

		if (count == 1) {
			flag = true;
		}

		ps.close();

		return flag;
	}

	@Override
	public String findLastArticleID(Article article) throws SQLException {
		String articleID = null;
		String sql = "SELECT a.articleID FROM article a ORDER BY a.articleID DESC LIMIT 1";
		// sqlserver版
		// String sql =
		// "SELECT TOP 1 a.articleID FROM article a ORDER BY a.articleID DESC";

		ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();

		while (rs.next()) {
			articleID = rs.getString(1);
		}
		
		return articleID;
	}

}
