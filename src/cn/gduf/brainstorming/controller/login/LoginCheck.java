/**
 * 
 */
package cn.gduf.brainstorming.controller.login;

import java.sql.SQLException;

import cn.gduf.brainstorming.model.factory.DAOFactory;
import cn.gduf.brainstorming.model.vo.User;

/**
 * 抽象类 登录校验功能类
 * 
 * @author Arkmusn
 * 
 */
public abstract class LoginCheck {

	/**
	 * 校验用户名密码是否正确
	 * 
	 * @param user
	 *            - User实体类
	 * @return 是否成功登录
	 */
	public static boolean isIdentifiedUser(User user) {
		boolean flag = false;
		// 传入的用户名密码
		String userNameRaw = user.getUserName();
		String userPasswordRaw = user.getUserPassword();

		// 查询库中是否存在传入的用户的信息
		try {
			user = DAOFactory.getLoginDAOInstance().findByName(user);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		// 传入的用户名密码与库中的用户名密码进行匹配
		if (userNameRaw.equals(user.getUserName())
				&& userPasswordRaw.equals(user.getUserPassword())) {
			flag = true;
		}

		return flag;
	}

}
