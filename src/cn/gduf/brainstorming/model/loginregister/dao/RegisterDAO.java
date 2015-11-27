package cn.gduf.brainstorming.model.loginregister.dao;

/**
 * ע��ӿ���
 * @author ��˼
 *
 */
import java.sql.SQLException;

import cn.gduf.brainstorming.model.vo.User;

public interface RegisterDAO {

	/**
	 * ����û���Ϣ
	 * 
	 * @param user
	 * @throws SQLException
	 */
	public boolean insertUserInfo(User user) throws SQLException;

	/**
	 * ��ѯ��ǰ����userID
	 * 
	 * @return ����userID
	 * @throws SQLException
	 */
	public String findLastUserID() throws SQLException;
}
