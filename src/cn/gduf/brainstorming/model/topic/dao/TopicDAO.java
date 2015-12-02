package cn.gduf.brainstorming.model.topic.dao;
/**
 * @author ��˼
 * ����ӿ���
 */
import java.sql.SQLException;
import java.util.List;

import cn.gduf.brainstorming.model.vo.Major;
import cn.gduf.brainstorming.model.vo.Theme;
import cn.gduf.brainstorming.model.vo.User;

public interface TopicDAO {
	public List<Major> showUserLoveTopic(User user) throws SQLException;
	public boolean insertUserLoveTopic(Theme theme) throws SQLException;
	public Major showSingleTopic(Major major) throws SQLException;
	public List<Major> showAllTopic() throws SQLException;
}
