/**
 * 
 */
package cn.gduf.brainstorming.controller.login;

import java.sql.SQLException;

import cn.gduf.brainstorming.model.factory.DAOFactory;
import cn.gduf.brainstorming.model.vo.User;

/**
 * ������ ��¼У�鹦����
 * 
 * @author Arkmusn
 * 
 */
public abstract class LoginCheck {

	/**
	 * У���û��������Ƿ���ȷ
	 * 
	 * @param user
	 *            - Userʵ����
	 * @return �Ƿ�ɹ���¼
	 */
	public static boolean isIdentifiedUser(User user) {
		boolean flag = false;
		// ������û�������
		String userNameRaw = user.getUserName();
		String userPasswordRaw = user.getUserPassword();

		// ��ѯ�����Ƿ���ڴ�����û�����Ϣ
		try {
			user = DAOFactory.getLoginDAOInstance().findByName(user);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		// ������û�����������е��û����������ƥ��
		if (userNameRaw.equals(user.getUserName())
				&& userPasswordRaw.equals(user.getUserPassword())) {
			flag = true;
		}

		return flag;
	}

}
