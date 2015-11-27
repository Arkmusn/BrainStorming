package cn.gduf.brainstorming.model.loginregister.dao;

/**
 * 注册接口类
 * @author 集思
 *
 */
import java.sql.SQLException;

import cn.gduf.brainstorming.model.vo.User;

public interface RegisterDAO {

	/**
	 * 添加用户信息
	 * 
	 * @param user
	 * @throws SQLException
	 */
	public boolean insertUserInfo(User user) throws SQLException;

	/**
	 * 查询当前最后的userID
	 * 
	 * @return 最后的userID
	 * @throws SQLException
	 */
	public String findLastUserID() throws SQLException;
}
