package cn.gduf.brainstorming.controller.register;

import java.sql.SQLException;

import cn.gduf.brainstorming.model.factory.DAOFactory;
import cn.gduf.brainstorming.model.vo.User;

/**
 * 抽象类 注册校验功能类
 * 
 * @author Arkmusn
 * 
 */
public abstract class RegisterCheck {

	/**
	 * 校验用户名是否存在
	 * 
	 * @param user
	 *            - 待校验的User实体类
	 * @return 是否存在该用户
	 * @throws SQLException
	 */
	public static boolean isUserNameExisted(User user) {
		boolean flag = true;

		try {
			user = DAOFactory.getLoginDAOInstance().findByName(user);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		if (user.getUserName() == null || user.getUserName().isEmpty()) {
			flag = false;
		}
		return flag;
	}

	/**
	 * 校验邮箱是否存在
	 * 
	 * @param user
	 *            - 待校验的User实体类
	 * @return 是否存在该邮箱
	 * @throws SQLException
	 */
	public static boolean isUserEmailExisted(User user) {
		boolean flag = true;

		try {
			user = DAOFactory.getLoginDAOInstance().findByEmail(user);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		if (user.getUserName() == null || user.getUserName().isEmpty()) {
			flag = false;
		}
		return flag;
	}
}
