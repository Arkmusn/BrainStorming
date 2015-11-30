package cn.gduf.brainstorming.model.userpage.dao;

import java.sql.SQLException;
import java.util.List;

import cn.gduf.brainstorming.model.vo.Focus;
import cn.gduf.brainstorming.model.vo.User;

/**
 * �û���ע�����ӿ���
 * 
 * @author Arkmusn
 * 
 */
public interface FocusDAO {
	/**
	 * ��ӹ�ע��¼
	 * 
	 * @param focus
	 *            - ��Ҫ��ӵĹ�ע��¼
	 * @return ����Ƿ�ɹ�
	 * @throws SQLException
	 * @throws Exception
	 */
	public boolean insertFocus(Focus focus) throws SQLException, Exception;

	/**
	 * �����û�ID��ʾ���ע�б�
	 * 
	 * @param userID
	 *            - �û�ID
	 * @return ��ע�б�
	 * @throws SQLException
	 * @throws Exception
	 */
	public List<User> showFocusList(User user) throws SQLException, Exception;

	/**
	 * �����û�ID��ʾ�䱻��ע�б�
	 * 
	 * @param userID
	 *            - �û�ID
	 * @return ����ע�б�
	 * @throws SQLException
	 * @throws Exception
	 */
	public List<User> showFocusedList(User user) throws SQLException, Exception;
}
