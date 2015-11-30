package cn.gduf.brainstorming.model.userpage.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.gduf.brainstorming.model.userpage.dao.FocusDAO;
import cn.gduf.brainstorming.model.vo.Focus;
import cn.gduf.brainstorming.model.vo.User;

/**
 * 用户关注操作接口实现类
 * 
 * @author Arkmusn
 * 
 */
public class FocusImpl implements FocusDAO {

	private Connection conn = null;
	private PreparedStatement pStmt = null;

	/**
	 * 取得数据库连接
	 * 
	 * @param conn
	 */
	public FocusImpl(Connection conn) {
		this.conn = conn;
	}

	@Override
	public boolean insertFocus(Focus focus) throws SQLException {
		boolean flag = false;
		String sql = "INSERT INTO focus (focusID, beFocusID) VALUES (?, ?)";
		this.pStmt = this.conn.prepareStatement(sql);
		this.pStmt.setString(1, focus.getFocusID());
		this.pStmt.setString(2, focus.getBeFocusID());
		int status = this.pStmt.executeUpdate();
		if (status == 1) {
			flag = true;
		}
		pStmt.close();
		return flag;
	}

	@Override
	public List<User> showFocusList(User user) throws SQLException {
		List<User> all = new ArrayList<User>();
		User userTemp = null;
		String sql = "SELECT u.userName"
				+ " FROM t_user u, focus f"
				+ " WHERE u.userID = f.beFocusID AND f.focusID = u.userID AND u.userName = ?";
		this.pStmt = this.conn.prepareStatement(sql);
		this.pStmt.setString(1, user.getUserName());
		ResultSet rs = this.pStmt.executeQuery();
		while (rs.next()) {
			userTemp = new User();
			userTemp.setUserName(rs.getString(1));
			all.add(userTemp);
		}
		this.pStmt.close();
		return all;
	}

	@Override
	public List<User> showFocusedList(User user) throws SQLException {
		List<User> all = new ArrayList<User>();
		User userTemp = null;
		String sql = "SELECT u.userName"
				+ " FROM t_user u, focus f"
				+ " WHERE u.userID = f.focusID AND f.beFocusID = u.userID AND u.userName = ?";
		this.pStmt = this.conn.prepareStatement(sql);
		this.pStmt.setString(1, user.getUserName());
		ResultSet rs = this.pStmt.executeQuery();
		while (rs.next()) {
			userTemp = new User();
			userTemp.setUserName(rs.getString(1));
			all.add(userTemp);
		}
		this.pStmt.close();
		return all;
	}

}
