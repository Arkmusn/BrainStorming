package cn.gduf.brainstorming.model.posttitle.dao.impl;
/**
 * 显示帖子头部内容接口实现类
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.gduf.brainstorming.model.posttitle.dao.PostHeadDAO;
import cn.gduf.brainstorming.model.vo.Article;
import cn.gduf.brainstorming.model.vo.AtTpUs3;
import cn.gduf.brainstorming.model.vo.TopicType;
import cn.gduf.brainstorming.model.vo.User;

public class PostHeadImpl implements PostHeadDAO {
	private Connection conn = null;
	private PreparedStatement pStmt = null;

	public PostHeadImpl(Connection conn) {
		this.conn = conn;
	}

	@Override
	public List<AtTpUs3> findPopularPost() {
		AtTpUs3 atTpUs3 = null;
		List<AtTpUs3> all = new ArrayList<AtTpUs3>();
		Article article = null;
		TopicType topicType = null;
		User user = null;
		// 显示URL，类型，标题，作者，浏览人数，回答人数，发帖时间
		// unfinished
		String sql = "SELECT a.articleURL, a.typeID, a.articleTitle, u.userName, t.typeName, a.browseCounter, a.answerCounter"
				+ " FROM article a, t_user u, topicType t"
				+ " WHERE a.userID = u.userID AND a.typeID = t.typeID"
				+ " ORDER BY browseCounter DESC";
		try {
			this.pStmt = this.conn.prepareStatement(sql);
			ResultSet rs = this.pStmt.executeQuery();
			while (rs.next()) {
				atTpUs3 = new AtTpUs3();
				article = new Article();
				topicType = new TopicType();
				user = new User();
				article.setArticleURL(rs.getString(1));
				article.setTypeID(rs.getInt(2));
				article.setArticleTitle(rs.getString(3));
				user.setUserName(rs.getString(4));
				topicType.setTypeName(rs.getString(5));
				article.setBrowseCounter(rs.getInt(6));
				article.setAnswerCounter(rs.getInt(7));
				atTpUs3.setArticle(article);
				atTpUs3.setUser(user);
				atTpUs3.setTopic(topicType);
				all.add(atTpUs3);
			}
			rs.close();
			pStmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return all;
	}

	@Override
	public List<AtTpUs3> findPostByUserID(String userID) {
		AtTpUs3 atTpUs3 = null;
		List<AtTpUs3> all = new ArrayList<AtTpUs3>();
		Article article = null;
		TopicType topicType = null;
		User user = null;
		// 显示URL，类型，标题，作者，浏览人数，回答人数，发帖时间
		// unfinished
		String sql = "SELECT a.articleURL, a.typeID, a.articleTitle, u.userName, t.typeName, a.browseCounter, a.answerCounter"
				+ " FROM article a, t_user u, topicType t"
				+ " WHERE u.userID = ? AND a.userID = u.userID AND a.typeID = t.typeID"
				+ " ORDER BY browseCounter DESC";
		try {
			this.pStmt = this.conn.prepareStatement(sql);
			this.pStmt.setString(1, userID);
			ResultSet rs = this.pStmt.executeQuery();
			while (rs.next()) {
				atTpUs3 = new AtTpUs3();
				article = new Article();
				topicType = new TopicType();
				user = new User();
				article.setArticleURL(rs.getString(1));
				article.setTypeID(rs.getInt(2));
				article.setArticleTitle(rs.getString(3));
				user.setUserName(rs.getString(4));
				topicType.setTypeName(rs.getString(5));
				article.setBrowseCounter(rs.getInt(6));
				article.setAnswerCounter(rs.getInt(7));
				atTpUs3.setArticle(article);
				atTpUs3.setUser(user);
				atTpUs3.setTopic(topicType);
				all.add(atTpUs3);
			}
			rs.close();
			pStmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return all;
	}

	@Override
	public List<AtTpUs3> findPostByTypeID(int typeID) {
		AtTpUs3 atTpUs3 = null;
		List<AtTpUs3> all = new ArrayList<AtTpUs3>();
		Article article = null;
		TopicType topicType = null;
		User user = null;
		// 显示URL，类型，标题，作者，浏览人数，回答人数，发帖时间
		// unfinished
		String sql = "SELECT a.articleURL, a.typeID, a.articleTitle, u.userName, t.typeName, a.browseCounter, a.answerCounter"
				+ " FROM article a, t_user u, topicType t"
				+ " WHERE t.typeID = ? AND a.userID = u.userID AND a.typeID = t.typeID"
				+ " ORDER BY browseCounter DESC";
		try {
			this.pStmt = this.conn.prepareStatement(sql);
			this.pStmt.setInt(1, typeID);
			ResultSet rs = this.pStmt.executeQuery();
			while (rs.next()) {
				atTpUs3 = new AtTpUs3();
				article = new Article();
				topicType = new TopicType();
				user = new User();
				article.setArticleURL(rs.getString(1));
				article.setTypeID(rs.getInt(2));
				article.setArticleTitle(rs.getString(3));
				user.setUserName(rs.getString(4));
				topicType.setTypeName(rs.getString(5));
				article.setBrowseCounter(rs.getInt(6));
				article.setAnswerCounter(rs.getInt(7));
				atTpUs3.setArticle(article);
				atTpUs3.setUser(user);
				atTpUs3.setTopic(topicType);
				all.add(atTpUs3);
			}
			rs.close();
			pStmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return all;
	}

	@Override
	public List<AtTpUs3> findPostByFavorUserID(String userID) {
		AtTpUs3 atTpUs3 = null;
		List<AtTpUs3> all = new ArrayList<AtTpUs3>();
		Article article = null;
		TopicType topicType = null;
		User user = null;
		// 显示URL，类型，标题，作者，浏览人数，回答人数，发帖时间
		// unfinished
		String sql = "SELECT a.articleURL, a.typeID, a.articleTitle, u.userName, t.typeName, a.browseCounter, a.answerCounter"
				+ " FROM article a, t_user u, topicType t"
				+ " WHERE u.userID = ? AND a.userID = u.userID AND a.typeID = t.typeID"
				+ " ORDER BY browseCounter DESC";
		try {
			this.pStmt = this.conn.prepareStatement(sql);
			this.pStmt.setString(1, userID);
			ResultSet rs = this.pStmt.executeQuery();
			while (rs.next()) {
				atTpUs3 = new AtTpUs3();
				article = new Article();
				topicType = new TopicType();
				user = new User();
				article.setArticleURL(rs.getString(1));
				article.setTypeID(rs.getInt(2));
				article.setArticleTitle(rs.getString(3));
				user.setUserName(rs.getString(4));
				topicType.setTypeName(rs.getString(5));
				article.setBrowseCounter(rs.getInt(6));
				article.setAnswerCounter(rs.getInt(7));
				atTpUs3.setArticle(article);
				atTpUs3.setUser(user);
				atTpUs3.setTopic(topicType);
				all.add(atTpUs3);
			}
			rs.close();
			pStmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return all;
	}

}
