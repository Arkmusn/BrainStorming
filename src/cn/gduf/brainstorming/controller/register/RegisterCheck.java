package cn.gduf.brainstorming.controller.register;

import java.sql.SQLException;

import cn.gduf.brainstorming.model.factory.DAOFactory;
import cn.gduf.brainstorming.model.vo.User;

/**
 * ������ ע��У�鹦����
 * 
 * @author Arkmusn
 * 
 */
public abstract class RegisterCheck {

	/**
	 * У���û����Ƿ����
	 * 
	 * @param user
	 *            - ��У���Userʵ����
	 * @return �Ƿ���ڸ��û�
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
	 * У�������Ƿ����
	 * 
	 * @param user
	 *            - ��У���Userʵ����
	 * @return �Ƿ���ڸ�����
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
