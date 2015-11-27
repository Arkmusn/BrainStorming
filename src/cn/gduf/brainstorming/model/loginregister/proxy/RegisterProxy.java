package cn.gduf.brainstorming.model.loginregister.proxy;

/**
 * 注册代理类
 * @author 集思
 */
import java.sql.SQLException;

import cn.gduf.brainstorming.model.dbc.DatabaseConnection;
import cn.gduf.brainstorming.model.loginregister.dao.RegisterDAO;
import cn.gduf.brainstorming.model.loginregister.dao.impl.RegisterDAOImpl;
import cn.gduf.brainstorming.model.vo.User;

public class RegisterProxy implements RegisterDAO {

	private DatabaseConnection dbc = null;
	private RegisterDAO dao = null;

	/**
	 * 打开数据库连接
	 */
	public RegisterProxy() {
		dbc = new DatabaseConnection();
		dao = new RegisterDAOImpl(dbc.getConnection());
	}

	/**
	 * 添加用户信息
	 * 
	 * @param user
	 * @throws SQLException
	 */
	@Override
	public boolean insertUserInfo(User user) throws SQLException {
		boolean flag = false;

		try {
			flag = dao.insertUserInfo(user);
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
	public String findLastUserID() throws SQLException {
		String userID = null;

		try {
			userID = dao.findLastUserID();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				dbc.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return userID;
	}

}
