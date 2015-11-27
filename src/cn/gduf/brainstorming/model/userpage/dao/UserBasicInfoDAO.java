package cn.gduf.brainstorming.model.userpage.dao;
/**
 * 个人信息接口类
 */
import cn.gduf.brainstorming.model.vo.UsShMj3;
import cn.gduf.brainstorming.model.vo.User;

public interface UserBasicInfoDAO {

	/**
	 * 根据用户ID显示返回用户学校专业实体类
	 * 
	 * @param userID
	 *            - 用户ID
	 * @return 用户学校专业实体类
	 * @throws Exception 
	 */
	public UsShMj3 findInfoByUserID(String userID) throws Exception;

	/**
	 * 根据User实体修改User用户基本信息
	 * 
	 * @param User
	 *            - 用户实体类
	 * @return 返回状态
	 * @throws Exception
	 */
	public boolean modifyInfo(User user) throws Exception;
}
