package cn.gduf.brainstorming.model.firstpage.dao.impl;
/**
 * 搜索栏搜索帖子
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.gduf.brainstorming.model.firstpage.dao.SearchPostDAO;
import cn.gduf.brainstorming.model.vo.Article;
import cn.gduf.brainstorming.model.vo.AtTpUs3;
import cn.gduf.brainstorming.model.vo.Major;
import cn.gduf.brainstorming.model.vo.School;
import cn.gduf.brainstorming.model.vo.TopicType;
import cn.gduf.brainstorming.model.vo.UsShMj3;
import cn.gduf.brainstorming.model.vo.User;

public class SearchPostImpl implements SearchPostDAO {
	private Connection conn = null;
	private PreparedStatement pStmt = null;

	public SearchPostImpl(Connection conn) {
		this.conn = conn;
	}

	@Override
	public List<AtTpUs3> articleSearchByTitle(String articleTitle) {
		AtTpUs3 atTpUs3 = null;
		List<AtTpUs3> all = new ArrayList<AtTpUs3>();
		Article article = null;
		TopicType topicType = null;
		User user = null;
		// 显示URL，类型，标题，作者，浏览人数，回答人数，发帖时间
		// unfinished
		String sql = "SELECT a.articleURL, a.typeID, a.articleTitle, u.userName, t.typeName, a.browseCounter, a.answerCounter"
				+ " FROM article a, t_user u, topicType t"
				+ " WHERE a.userID=u.userID and a.typeID=t.typeID and a.articleTitle LIKE ?"
				+ " ORDER BY browseCounter DESC";
		try {
			this.pStmt = this.conn.prepareStatement(sql);
			this.pStmt.setString(1, "%" + articleTitle + "%");
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
	public List<AtTpUs3> articleSearchByTopic(int topicID) {
		AtTpUs3 atTpUs3 = null;
		List<AtTpUs3> all = new ArrayList<AtTpUs3>();
		Article article = null;
		TopicType topicType = null;
		User user = null;
		// 显示URL，类型，标题，作者，浏览人数，回答人数，发帖时间
		// unfinished
		String sql = "SELECT a.articleURL, a.typeID, a.articleTitle, u.userName, t.typeName, a.browseCounter, a.answerCounter"
				+ " FROM article a, t_user u, topicType t"
				+ " WHERE a.typeID = ? AND a.typeID = t.typeID AND a.userID = u.userID"
				+ " ORDER BY browseCounter DESC";
		try {
			this.pStmt = this.conn.prepareStatement(sql);
			this.pStmt.setInt(1, topicID);
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
	public List<UsShMj3> userSearchByUserName(String userName) {
		UsShMj3 usShMj3 = null;
		List<UsShMj3> all = new ArrayList<UsShMj3>();
		User user = null;
		School school = null;
		Major major = null;
		String sql = "SELECT u.userName, s.schoolName, m.majorName, u.introducePath"
				+ " FROM t_user u, school s, major m"
				+ " WHERE u.userName LIKE ? AND u.schoolID = s.schoolID AND u.majorID = m.majorID"
				+ " ORDER BY u.userID DESC";
		try {
			this.pStmt = this.conn.prepareStatement(sql);
			this.pStmt.setString(1, "%" + userName + "%");
			ResultSet rs = this.pStmt.executeQuery();
			while (rs.next()) {
				usShMj3 = new UsShMj3();
				user = new User();
				school = new School();
				major = new Major();
				user.setUserName(rs.getString(1));
				school.setSchoolName(rs.getString(2));
				major.setMajorName(rs.getString(3));
				user.setIntroducePath(rs.getString(4));
				usShMj3.setUser(user);
				usShMj3.setSchool(school);
				usShMj3.setMajor(major);
				all.add(usShMj3);
			}
			rs.close();
			pStmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return all;
	}

	@Override
	public List<Major> majorSearchByMajorName(String majorName) {
		List<Major> all = new ArrayList<Major>();
		Major major = null;
		String sql = "SELECT m.majorName" + " FROM major m"
				+ " WHERE m.majorName LIKE ?" + " ORDER BY m.majorID DESC";
		try {
			this.pStmt = this.conn.prepareStatement(sql);
			this.pStmt.setString(1, "%" + majorName + "%");
			ResultSet rs = this.pStmt.executeQuery();
			while (rs.next()) {
				major = new Major();
				major.setMajorName(rs.getString(1));
				all.add(major);
			}
			rs.close();
			pStmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return all;
	}
}
