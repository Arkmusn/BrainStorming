package cn.gduf.brainstorming.model.userpage.dao;

import java.sql.SQLException;
import java.util.List;

import cn.gduf.brainstorming.model.vo.Focus;
import cn.gduf.brainstorming.model.vo.User;

/**
 * 用户关注操作接口类
 * 
 * @author Arkmusn
 * 
 */
public interface FocusDAO {
	/**
	 * 添加关注记录
	 * 
	 * @param focus
	 *            - 需要添加的关注记录
	 * @return 添加是否成功
	 * @throws SQLException
	 * @throws Exception
	 */
	public boolean insertFocus(Focus focus) throws SQLException, Exception;

	/**
	 * 传入用户ID显示其关注列表
	 * 
	 * @param userID
	 *            - 用户ID
	 * @return 关注列表
	 * @throws SQLException
	 * @throws Exception
	 */
	public List<User> showFocusList(User user) throws SQLException, Exception;

	/**
	 * 传入用户ID显示其被关注列表
	 * 
	 * @param userID
	 *            - 用户ID
	 * @return 被关注列表
	 * @throws SQLException
	 * @throws Exception
	 */
	public List<User> showFocusedList(User user) throws SQLException, Exception;
}
