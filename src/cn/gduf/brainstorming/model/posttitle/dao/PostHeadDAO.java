package cn.gduf.brainstorming.model.posttitle.dao;
/**
 * 显示帖子头部内容接口类
 */
import java.sql.SQLException;
import java.util.List;

import cn.gduf.brainstorming.model.vo.AtTpUs3;

public interface PostHeadDAO {
	/**
	 * 显示热门帖子
	 * 
	 * @return vo对象包含：Article，TopicType，User
	 * @throws SQLException 
	 * @throws Exception 
	 */
	public List<AtTpUs3> findPopularPost() throws SQLException, Exception;

	/**
	 * 根据用户ID查找帖子
	 * 
	 * @return vo对象包含：Article，TopicType，User
	 * @throws Exception 
	 */
	public List<AtTpUs3> findPostByUserID(String userID) throws Exception;

	/**
	 * 根据类型ID查找帖子
	 * 
	 * @return vo对象包含：Article，TopicType，User
	 * @throws Exception 
	 */
	public List<AtTpUs3> findPostByTypeID(int typeID) throws Exception;

	/**
	 * 查找用户收藏的帖子
	 * 
	 * @return vo对象包含：Article，TopicType，User
	 * @throws Exception 
	 */
	public List<AtTpUs3> findPostByFavorUserID(String userID) throws Exception;
}
