package cn.gduf.brainstorming.model.loginregister.proxy;

/**
 * 登陆代理类
 * @author 集思
 */
import java.sql.SQLException;

import cn.gduf.brainstorming.model.dbc.DatabaseConnection;
import cn.gduf.brainstorming.model.loginregister.dao.LoginDAO;
import cn.gduf.brainstorming.model.loginregister.dao.impl.LoginDAOImpl;
import cn.gduf.brainstorming.model.vo.User;

public class LoginProxy implements LoginDAO {

	private DatabaseConnection dbc = null;
	private LoginDAO dao = null;

	/**
	 * 打开数据库连接
	 */
	public LoginProxy() {
		dbc = new DatabaseConnection();
		dao = new LoginDAOImpl(dbc.getConnection());
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
		try {
			user2=dao.findByUserID(user);
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
		try {
			user2=dao.findByName(user);
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

		try {
			user2=dao.findByEmail(user);
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
		return user2;
	}

}
