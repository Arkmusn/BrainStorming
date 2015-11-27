package cn.gduf.brainstorming.model.topic.dao;
/**
 * @author 集思
 * 话题接口类
 */
import java.sql.SQLException;
import java.util.List;

import cn.gduf.brainstorming.model.vo.Major;
import cn.gduf.brainstorming.model.vo.Theme;

public interface TopicDAO {
	public List<Major> showUserLoveTopic(Theme theme) throws SQLException;
	public boolean insertUserLoveTopic(Theme theme) throws SQLException;
	public Major showSingleTopic(Major major) throws SQLException;
	public List<Major> showAllTopic() throws SQLException;
}
