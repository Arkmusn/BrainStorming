package cn.gduf.brainstorming.model.posttitle.dao;

/**
 * ��ʾ����ͷ�����ݽӿ���
 */
import java.util.List;

import cn.gduf.brainstorming.model.vo.AtTpUs3;
import cn.gduf.brainstorming.model.vo.Major;
import cn.gduf.brainstorming.model.vo.TopicType;

public interface PostHeadDAO {
	/**
	 * ���ݻش�������ʾ����
	 * 
	 * @param topicType
	 *            - �������
	 * @return vo���������Article��TopicType��User
	 * @throws Exception
	 */
	public List<AtTpUs3> findPopularPostAccordingAnswer(TopicType topicType)
			throws Exception;

	/**
	 * ���ݻش�������ʾ����
	 * 
	 * @param topicType
	 *            - �������
	 * @param major
	 *            - ����רҵ
	 * @return vo���������Article��TopicType��User
	 * @throws Exception
	 */
	public List<AtTpUs3> findPopularPostAccordingAnswerParameter(
			TopicType topicType, Major major) throws Exception;

	/**
	 * ���ݷ���ʱ����ʾ����
	 * 
	 * @param topicType
	 *            - �������
	 * @return vo���������Article��TopicType��User
	 * @throws Exception
	 */
	public List<AtTpUs3> findPopularPostAccordingTime(TopicType topicType)
			throws Exception;

	/**
	 * ���ݷ���ʱ����ʾ����
	 * 
	 * @param topicType
	 *            - �������
	 * @param major
	 *            - ����רҵ
	 * @return vo���������Article��TopicType��User
	 * @throws Exception
	 */
	public List<AtTpUs3> findPopularPostAccordingTimeParameter(
			TopicType topicType, Major major) throws Exception;

	/**
	 * �����û�ID��������
	 * 
	 * @return vo���������Article��TopicType��User
	 * @throws Exception
	 */
	public List<AtTpUs3> findPostByUserID(String userID) throws Exception;

	/**
	 * ��������ID��������
	 * 
	 * @return vo���������Article��TopicType��User
	 * @throws Exception
	 */
	public List<AtTpUs3> findPostByTypeID(int typeID) throws Exception;

	/**
	 * �����û��ղص�����
	 * 
	 * @return vo���������Article��TopicType��User
	 * @throws Exception
	 */
	public List<AtTpUs3> findPostByFavorUserID(String userID) throws Exception;
}
