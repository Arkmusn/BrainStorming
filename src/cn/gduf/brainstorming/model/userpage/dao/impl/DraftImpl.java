package cn.gduf.brainstorming.model.userpage.dao.impl;
/**
 * 草稿接口实现类
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.gduf.brainstorming.model.userpage.dao.DraftDAO;
import cn.gduf.brainstorming.model.vo.Answer;
import cn.gduf.brainstorming.model.vo.Article;
import cn.gduf.brainstorming.model.vo.AtAsTp3;
import cn.gduf.brainstorming.model.vo.AtTp2;
import cn.gduf.brainstorming.model.vo.TopicType;

public class DraftImpl implements DraftDAO {
	private Connection conn = null;
	private PreparedStatement pStmt = null;

	public DraftImpl(Connection conn) {
		this.conn = conn;
	}
	
	
	@Override
	public boolean createDraft(Article article) {
		boolean flag = false;
		String sql = "UPDATE article" + " SET draftFlag = 1"
				+ " WHERE articleID = ?";
		try {
			this.pStmt = this.conn.prepareStatement(sql);
			this.pStmt.setString(1, article.getArticleID());
			int status = this.pStmt.executeUpdate();
			if (status == 1) {
				flag = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public boolean createDraft(Answer answer) throws Exception {
		boolean flag = false;
		String sql = "UPDATE answer" + " SET draftFlag = 1"
				+ " WHERE answerID = ?";
		try {
			this.pStmt = this.conn.prepareStatement(sql);
			this.pStmt.setString(1, answer.getAnswerID());
			int status = this.pStmt.executeUpdate();
			if (status == 1) {
				flag = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public List<AtTp2> showArticleDraft(String userID) {
		List<AtTp2> all = new ArrayList<AtTp2>();
		AtTp2 atTp2 = null;
		Article article = null;
		TopicType topicType = null;
		String sql = "SELECT a.articleTitle, a.articleURL, a.textPath, t.typeName, a.createTime"
				+ " FROM article a, topicType t"
				+ " WHERE a.userID = ? AND a.draftFlag = 1 and a.typeID=t.typeID"
				+ " ORDER BY a.articleID DESC";
		try {
			this.pStmt = this.conn.prepareStatement(sql);
			this.pStmt.setString(1, userID);
			ResultSet rs = this.pStmt.executeQuery();
			while (rs.next()) {
				atTp2 = new AtTp2();
				article = new Article();
				topicType = new TopicType();
				article.setArticleTitle(rs.getString(1));
				article.setArticleURL(rs.getString(2));
				article.setTextPath(rs.getString(3));
				topicType.setTypeName(rs.getString(4));
				article.setCreateTime(rs.getString(5));
				atTp2.setArticle(article);
				atTp2.setTopic(topicType);
				all.add(atTp2);
			}
			rs.close();
			pStmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return all;
	}

	@Override
	public List<AtAsTp3> showAnswerDraft(String userID) {
		List<AtAsTp3> all = new ArrayList<AtAsTp3>();
		AtAsTp3 atAsTp3 = null;
		Article article = null;
		Answer answer = null;
		TopicType topicType = null;
		String sql = "SELECT at.articleTitle, at.articleURL, ans.answerPath, t.typeName, ans.createTime"
				+ " FROM article at, answer ans, topicType t"
				+ " WHERE ans.userID = ? AND ans.draftFlag = 1 and at.typeID=t.typeID and ans.articleID=at.articleID"
				+ " ORDER BY ans.answerID DESC";
		try {
			this.pStmt = this.conn.prepareStatement(sql);
			this.pStmt.setString(1, userID);
			ResultSet rs = this.pStmt.executeQuery();
			while (rs.next()) {
				atAsTp3 = new AtAsTp3();
				article = new Article();
				answer = new Answer();
				topicType = new TopicType();
				article.setArticleTitle(rs.getString(1));
				article.setArticleURL(rs.getString(2));
				answer.setAnswerPath(rs.getString(3));
				topicType.setTypeName(rs.getString(4));
				answer.setCreateTime(rs.getString(5));
				atAsTp3.setArticle(article);
				atAsTp3.setAnswer(answer);
				atAsTp3.setTopicType(topicType);
				all.add(atAsTp3);
			}
			rs.close();
			pStmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return all;
	}

}
