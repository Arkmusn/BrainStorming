package cn.gduf.brainstorming.model.userpage.dao.impl;
/**
 * 个人信息接口实现类
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import cn.gduf.brainstorming.model.userpage.dao.UserBasicInfoDAO;
import cn.gduf.brainstorming.model.vo.Major;
import cn.gduf.brainstorming.model.vo.School;
import cn.gduf.brainstorming.model.vo.UsShMj3;
import cn.gduf.brainstorming.model.vo.User;

public class UserBasciInfoImpl implements UserBasicInfoDAO {
	private Connection conn = null;
	private PreparedStatement pStmt = null;

	public UserBasciInfoImpl(Connection conn) {
		this.conn = conn;
	}

	@Override
	public UsShMj3 findInfoByUserID(String userID) {
		UsShMj3 usShMj3 = null;
		User user = null;
		School school = null;
		Major major = null;
		String sql = "SELECT u.userName, u.picturePath, u.userEmail, u.introducePath, s.schoolName, m.majorName"
				+ " FROM t_user u, school s, major m"
				+ " WHERE u.userID = ? AND u.schoolID = s.schoolID AND u.majorID = m.majorID";
		try {
			this.pStmt = this.conn.prepareStatement(sql);
			this.pStmt.setString(1, userID);
			ResultSet rs = this.pStmt.executeQuery();
			while (rs.next()) {
				usShMj3 = new UsShMj3();
				user = new User();
				school = new School();
				major = new Major();
				user.setUserName(rs.getString(1));
				user.setPicturePath(rs.getString(2));
				user.setUserEmail(rs.getString(3));
				user.setIntroducePath(rs.getString(4));
				school.setSchoolName(rs.getString(5));
				major.setMajorName(rs.getString(6));
				usShMj3.setUser(user);
				usShMj3.setSchool(school);
				usShMj3.setMajor(major);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return usShMj3;
	}

	@Override
	public boolean modifyInfo(User user) {
		boolean flag = false;
		String sql = "UPDATE t_user"
				+ " SET userName = ? , userEmail = ? , schoolID = ? , majorID = ?"
				+ " WHERE userID = ?";
		try {
			this.pStmt = this.conn.prepareStatement(sql);
			this.pStmt.setString(1, user.getUserName());
			this.pStmt.setString(2, user.getUserEmail());
			this.pStmt.setString(3, user.getShoolID());
			this.pStmt.setString(4, user.getMajorID());
			this.pStmt.setString(5, user.getUserID());
			int status = this.pStmt.executeUpdate();
			if (status == 1) {
				flag = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}

	
}
