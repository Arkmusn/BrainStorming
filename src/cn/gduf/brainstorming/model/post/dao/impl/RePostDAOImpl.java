package cn.gduf.brainstorming.model.post.dao.impl;

/**
 * @author 集思
 * 回帖接口实现类
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.gduf.brainstorming.model.post.dao.RePostDAO;
import cn.gduf.brainstorming.model.vo.Answer;

public class RePostDAOImpl implements RePostDAO {

	private Connection conn = null;
	private PreparedStatement ps = null;
	private ResultSet rs = null;

	public RePostDAOImpl(Connection conn) {
		this.conn = conn;
	}

	/**
	 * 添加回帖
	 * 
	 * @param answer
	 * @throws SQLException
	 */
	@Override
	public boolean createRePost(Answer answer) throws SQLException {

		/*
		 * 发表回帖（回帖ID，归属帖子ID，作者ID，回帖内容）
		 */

		boolean flag = false;

		String sql = "insert into answer(answerID,articleID,userID,answerPath)"
				+ "values(?,?,?,?)";

		ps = conn.prepareStatement(sql);

		ps.setString(1, answer.getAnswerID());
		ps.setString(2, answer.getArticleID());
		ps.setString(3, answer.getUserID());
		ps.setString(4, answer.getAnswerPath());

		int count = ps.executeUpdate();

		if (count == 1) {
			flag = true;
		}

		ps.close();

		return flag;
	}

	/**
	 * 查看回帖（用户回帖）
	 * 
	 * @param answer
	 * @throws SQLException
	 */
	@Override
	public List<Answer> showRePostByUserID(Answer answer) throws SQLException {

		/*
		 * 显示出归属帖子，回答的作者，回答的内容和时间，已经对这个回答赞的个数，草稿标记为0
		 */
		List<Answer> list = new ArrayList<Answer>();

		Answer answer2 = null;

		String sql = "select articleID,userID,answerPath,createTime,agreeCounter from answer where draftFlag=0 and userID=?";

		ps = conn.prepareStatement(sql);

		ps.setString(1, answer.getUserID());

		rs = ps.executeQuery();

		while (rs.next()) {
			answer2 = new Answer();
			answer2.setArticleID(rs.getString("articleID"));
			answer2.setUserID(rs.getString("userID"));
			answer2.setAnswerPath(rs.getString("answerPath"));
			answer2.setCreateTime(rs.getString("createTime"));
			answer2.setAgreeCounter(rs.getInt("agreeCounter"));
			list.add(answer2);
		}

		rs.close();
		ps.close();

		return list;

	}

	/**
	 * 查看回帖（帖子回帖）
	 * 
	 * @param answer
	 * @throws SQLException
	 */
	@Override
	public List<Answer> showRePostByArticleID(Answer answer)
			throws SQLException {

		/*
		 * 显示出归属帖子，回答的作者，回答的内容和时间，已经对这个回答赞的个数，草稿标记为0
		 */
		List<Answer> list = new ArrayList<Answer>();

		Answer answer2 = null;

		String sql = "select articleID,userID,answerPath,createTime,agreeCounter from answer where draftFlag=0 and ArticleID=?";

		ps = conn.prepareStatement(sql);

		ps.setString(1, answer.getArticleID());

		rs = ps.executeQuery();

		while (rs.next()) {
			answer2 = new Answer();
			answer2.setArticleID(rs.getString("articleID"));
			answer2.setUserID(rs.getString("userID"));
			answer2.setAnswerPath(rs.getString("answerPath"));
			answer2.setCreateTime(rs.getString("createTime"));
			answer2.setAgreeCounter(rs.getInt("agreeCounter"));
			list.add(answer2);
		}

		rs.close();
		ps.close();

		return list;
	}

	@Override
	public String findLastAnswerID(Answer answer) throws SQLException {
		String answerID = null;
		String sql = "SELECT a.answerID FROM answer a ORDER BY a.answerID DESC LIMIT 1";
		// sqlserver版
		// String sql =
		// "SELECT TOP 1 a.answer FROM answer a ORDER BY a.answer DESC";

		ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();

		while (rs.next()) {
			answerID = rs.getString(1);
		}

		return answerID;
	}
}
