package cn.gduf.brainstorming.controller.register;

import java.sql.SQLException;

import cn.gduf.brainstorming.model.factory.DAOFactory;
import cn.gduf.brainstorming.model.vo.User;

/**
 * ע��ȷ���ύ���ݿ������
 * 
 * @author Arkmusn
 * 
 */
public class Register {
	private User user;
	private String userID;

	/**
	 * ͨ��Userʵ����󹹽�һ������
	 * 
	 * @param user
	 *            - Userʵ�����
	 */
	public Register(User user) {
		this.user = user;
		String lastUserID = null;
		// �������һ��UserID
		try {
			lastUserID = DAOFactory.getRegisterDAOInstance().findLastUserID();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		// ����UserID�з�0λ
		int indexOfNotZero = 0;
		for (int index = 0, length = lastUserID.length(); index < length; index++) {
			if (lastUserID.charAt(index) != '0') {
				indexOfNotZero = index;
				break;
			}
		}
		// �����ڷ�0λ
		String frontUserID;
		String behindUserID;
		if (indexOfNotZero != 0) {
			frontUserID = lastUserID.substring(0, indexOfNotZero);
			behindUserID = lastUserID.substring(indexOfNotZero);
			// ��ȡ�������ֳ���
			int lengthRaw = behindUserID.length();
			Long valueOfUserID = Long.parseLong(behindUserID);
			valueOfUserID = valueOfUserID + 1;
			behindUserID = valueOfUserID.toString();
			// ��ȡ+1�����ķ������ֳ���
			int lengthPro = behindUserID.length();
			// ��ǰ�󳤶���ͬ
			// ֱ��ƴ�ӳ����ַ���
			if (lengthRaw == lengthPro) {
				this.userID = frontUserID + behindUserID;
			}
			// ��ǰ�󳤶Ȳ�ͬ
			// ǰ����ȥ���һλ��ƴ��
			else {
				this.userID = frontUserID
						.substring(0, frontUserID.length() - 1) + behindUserID;
			}

			this.user.setUserID(this.userID);
		}
	}

	/**
	 * �ύ�û�ע����Ϣ�����ݿⲢ�����ύ״̬
	 * 
	 * @return �ύ״̬
	 */
	public boolean excute() {
		boolean flag = false;

		try {
			flag = DAOFactory.getRegisterDAOInstance().insertUserInfo(user);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return flag;
	}

	/**
	 * ���ش�����UserID
	 * 
	 * @return ������UserID
	 */
	public String getUserID() {
		return userID;
	}
}
