package cn.gduf.brainstorming.model.post.proxy;

/**
 * @author 集思
 * 回帖代理类
 */
import java.sql.SQLException;
import java.util.List;

import cn.gduf.brainstorming.model.dbc.DatabaseConnection;
import cn.gduf.brainstorming.model.post.dao.RePostDAO;
import cn.gduf.brainstorming.model.post.dao.impl.RePostDAOImpl;
import cn.gduf.brainstorming.model.vo.Answer;

public class RePostProxy implements RePostDAO {

	private DatabaseConnection dbc = null; // 数据库连接对象
	private RePostDAO dao = null;

	/**
	 * 构造方法，打开数据库和实现接口
	 */
	public RePostProxy() {
		this.dbc = new DatabaseConnection(); // 取得数据库连接对象
		this.dao = new RePostDAOImpl(this.dbc.getConnection());
	}

	/**
	 * 查看回帖（用户回帖）
	 * 
	 * @param answer
	 * @throws SQLException
	 */
	@Override
	public List<Answer> showRePostByUserID(Answer answer) throws SQLException {
		List<Answer> list = null;
		try {
			list = dao.showRePostByUserID(answer);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				dbc.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

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
		List<Answer> list = null;
		try {
			list = dao.showRePostByArticleID(answer);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				dbc.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return list;

	}

	@Override
	public boolean createRePost(Answer answer) throws SQLException {

		boolean flag = false;

		try {
			flag = dao.createRePost(answer);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				dbc.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return flag;
	}

	@Override
	public String findLastAnswerID(Answer answer) throws SQLException {
		String answerID = null;

		try {
			answerID = dao.findLastAnswerID(answer);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				dbc.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return answerID;
	}

}
