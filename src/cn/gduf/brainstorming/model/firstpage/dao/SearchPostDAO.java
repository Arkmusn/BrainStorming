package cn.gduf.brainstorming.model.firstpage.dao;
/**
 * 搜索栏搜索帖子接口类
 */
import java.util.List;

import cn.gduf.brainstorming.model.vo.AtTpUs3;
import cn.gduf.brainstorming.model.vo.Major;
import cn.gduf.brainstorming.model.vo.UsShMj3;

public interface SearchPostDAO {
	/**
	 * 根据标题搜索帖子
	 * 
	 * @param articleTitle
	 *            - 标题
	 * @return vo对象包含：Article，TopicType，User
	 * @throws Exception 
	 */
	public List<AtTpUs3> articleSearchByTitle(String articleTitle) throws Exception;

	/**
	 * 根据板块搜索帖子
	 * 
	 * @param topicID
	 *            - 板块ID
	 * 
	 * @return vo对象包含：Article，TopicType，User
	 * @throws Exception 
	 */
	public List<AtTpUs3> articleSearchByTopic(int topicID) throws Exception;

	/**
	 * 根据用户名搜索用户
	 * 
	 * @param userName
	 *            - 用户名
	 * @return 用户学校专业3实体类
	 * @throws Exception 
	 */
	public List<UsShMj3> userSearchByUserName(String userName) throws Exception;

	/**
	 * 根据专业名搜索专业
	 * 
	 * @param majorName
	 *            - 专业名
	 * @return 专业实体
	 * @throws Exception 
	 */
	public List<Major> majorSearchByMajorName(String majorName) throws Exception;

}
