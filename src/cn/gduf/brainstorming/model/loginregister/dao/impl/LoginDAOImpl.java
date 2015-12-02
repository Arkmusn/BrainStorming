package cn.gduf.brainstorming.model.loginregister.dao.impl;

/**
 * 登陆接口实现类
 * @author 集思
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import cn.gduf.brainstorming.model.loginregister.dao.LoginDAO;
import cn.gduf.brainstorming.model.vo.User;

public class LoginDAOImpl implements LoginDAO {

	private Connection conn = null;
	private PreparedStatement ps = null;
	private ResultSet rs = null;

	/**
	 * 取得数据库连接
	 * 
	 * @param conn
	 */
	public LoginDAOImpl(Connection conn) {
		this.conn = conn;
	}

	/**
	 * 登录验证，根据用户ID找登录信息
	 * 
	 * @param user
	 * @throws SQLException
	 */
	@Override
	public User findByUserID(User user) throws SQLException {
		User user2 = new User();

		String sql = "select userID,userName,userPassword,userEmail,picturePath,createTime "
				+ "from t_user where userID=?";

		ps = conn.prepareStatement(sql);

		ps.setString(1, user.getUserID());

		rs = ps.executeQuery();

		while (rs.next()) {
			user2.setUserID(rs.getString("userID"));
			user2.setUserName(rs.getString("userName"));
			user2.setUserPassword(rs.getString("userPassword"));
			user2.setUserEmail(rs.getString("userEmail"));
			user2.setPicturePath(rs.getString("picturePath"));
			user2.setCreateTime(rs.getDate("createTime"));
		}

		rs.close();
		ps.close();

		return user2;
	}

	/**
	 * 登录验证，根据用户名找登录信息
	 * 
	 * @param user
	 * @throws SQLException
	 */
	@Override
	public User findByName(User user) throws SQLException {
		User user2 = new User();

		String sql = "select userID,userName,userPassword,userEmail,picturePath,createTime from t_user where userName=?";

		ps = conn.prepareStatement(sql);

		ps.setString(1, user.getUserName());

		rs = ps.executeQuery();

		while (rs.next()) {
			user2.setUserID(rs.getString("userID"));
			user2.setUserName(rs.getString("userName"));
			user2.setUserPassword(rs.getString("userPassword"));
			user2.setUserEmail(rs.getString("userEmail"));
			user2.setPicturePath(rs.getString("picturePath"));
			user2.setCreateTime(rs.getDate("createTime"));
		}

		rs.close();
		ps.close();

		return user2;

	}

	/**
	 * 登录验证，根据用户邮箱找登录信息
	 * 
	 * @param user
	 * @throws SQLException
	 */
	@Override
	public User findByEmail(User user) throws SQLException {
		User user2 = new User();

		String sql = "select userID,userName,userPassword,userEmail,picturePath,createTime"
				+ " from t_user where userEmail=?";

		ps = conn.prepareStatement(sql);

		ps.setString(1, user.getUserEmail());

		rs = ps.executeQuery();

		while (rs.next()) {
			user2.setUserID(rs.getString("userID"));
			user2.setUserName(rs.getString("userName"));
			user2.setUserPassword(rs.getString("userPassword"));
			user2.setUserEmail(rs.getString("userEmail"));
			user2.setPicturePath(rs.getString("picturePath"));
			user2.setCreateTime(rs.getDate("createTime"));
		}

		rs.close();
		ps.close();

		return user2;

	}

}
