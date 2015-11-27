package cn.gduf.brainstorming.controller.register;

import java.sql.SQLException;

import cn.gduf.brainstorming.model.factory.DAOFactory;
import cn.gduf.brainstorming.model.vo.User;

/**
 * 注册确认提交数据库操作类
 * 
 * @author Arkmusn
 * 
 */
public class Register {
	private User user;
	private String userID;

	/**
	 * 通过User实体对象构建一个对象
	 * 
	 * @param user
	 *            - User实体对象
	 */
	public Register(User user) {
		this.user = user;
		String lastUserID = null;
		// 查找最后一个UserID
		try {
			lastUserID = DAOFactory.getRegisterDAOInstance().findLastUserID();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		// 查找UserID中非0位
		int indexOfNotZero = 0;
		for (int index = 0, length = lastUserID.length(); index < length; index++) {
			if (lastUserID.charAt(index) != '0') {
				indexOfNotZero = index;
				break;
			}
		}
		// 若存在非0位
		String frontUserID;
		String behindUserID;
		if (indexOfNotZero != 0) {
			frontUserID = lastUserID.substring(0, indexOfNotZero);
			behindUserID = lastUserID.substring(indexOfNotZero);
			// 获取非零数字长度
			int lengthRaw = behindUserID.length();
			Long valueOfUserID = Long.parseLong(behindUserID);
			valueOfUserID = valueOfUserID + 1;
			behindUserID = valueOfUserID.toString();
			// 获取+1处理后的非零数字长度
			int lengthPro = behindUserID.length();
			// 若前后长度相同
			// 直接拼接成新字符串
			if (lengthRaw == lengthPro) {
				this.userID = frontUserID + behindUserID;
			}
			// 若前后长度不同
			// 前段舍去最后一位后拼接
			else {
				this.userID = frontUserID
						.substring(0, frontUserID.length() - 1) + behindUserID;
			}

			this.user.setUserID(this.userID);
		}
	}

	/**
	 * 提交用户注册信息至数据库并返回提交状态
	 * 
	 * @return 提交状态
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
	 * 返回处理后的UserID
	 * 
	 * @return 处理后的UserID
	 */
	public String getUserID() {
		return userID;
	}
}
