package cn.gduf.brainstorming.model.posttitle.dao;

/**
 * 显示帖子头部内容接口类
 */
import java.util.List;

import cn.gduf.brainstorming.model.vo.AtTpUs3;
import cn.gduf.brainstorming.model.vo.Major;
import cn.gduf.brainstorming.model.vo.TopicType;

public interface PostHeadDAO {
	/**
	 * 根据回答数量显示帖子
	 * 
	 * @param topicType
	 *            - 板块类型
	 * @return vo对象包含：Article，TopicType，User
	 * @throws Exception
	 */
	public List<AtTpUs3> findPopularPostAccordingAnswer(TopicType topicType)
			throws Exception;

	/**
	 * 根据回答数量显示帖子
	 * 
	 * @param topicType
	 *            - 板块类型
	 * @param major
	 *            - 所查专业
	 * @return vo对象包含：Article，TopicType，User
	 * @throws Exception
	 */
	public List<AtTpUs3> findPopularPostAccordingAnswerParameter(
			TopicType topicType, Major major) throws Exception;

	/**
	 * 根据发布时间显示帖子
	 * 
	 * @param topicType
	 *            - 板块类型
	 * @return vo对象包含：Article，TopicType，User
	 * @throws Exception
	 */
	public List<AtTpUs3> findPopularPostAccordingTime(TopicType topicType)
			throws Exception;

	/**
	 * 根据发布时间显示帖子
	 * 
	 * @param topicType
	 *            - 板块类型
	 * @param major
	 *            - 所查专业
	 * @return vo对象包含：Article，TopicType，User
	 * @throws Exception
	 */
	public List<AtTpUs3> findPopularPostAccordingTimeParameter(
			TopicType topicType, Major major) throws Exception;

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
