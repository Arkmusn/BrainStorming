package cn.gduf.brainstorming.model.posttitle.proxy;

/**
 * 显示帖子头部内容代理类
 */
import java.sql.SQLException;
import java.util.List;

import cn.gduf.brainstorming.model.dbc.DatabaseConnection;
import cn.gduf.brainstorming.model.posttitle.dao.PostHeadDAO;
import cn.gduf.brainstorming.model.posttitle.dao.impl.PostHeadImpl;
import cn.gduf.brainstorming.model.vo.AtTpUs3;
import cn.gduf.brainstorming.model.vo.Major;
import cn.gduf.brainstorming.model.vo.TopicType;

public class PostHeadProxy implements PostHeadDAO {
	private DatabaseConnection dbc = null;
	private PostHeadDAO dao = null;

	public PostHeadProxy() {
		this.dbc = new DatabaseConnection();
		this.dao = new PostHeadImpl(this.dbc.getConnection());
	}

	@Override
	public List<AtTpUs3> findPopularPostAccordingAnswer(TopicType topicType)
			throws Exception {
		List<AtTpUs3> aTtpUs3 = null;
		try {
			aTtpUs3 = this.dao.findPopularPostAccordingAnswer(topicType);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.dbc.close();
		}
		return aTtpUs3;
	}

	@Override
	public List<AtTpUs3> findPopularPostAccordingAnswerParameter(
			TopicType topicType, Major major) throws Exception {
		List<AtTpUs3> aTtpUs3 = null;
		try {
			aTtpUs3 = this.dao.findPopularPostAccordingAnswerParameter(
					topicType, major);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.dbc.close();
		}
		return aTtpUs3;
	}

	@Override
	public List<AtTpUs3> findPopularPostAccordingTime(TopicType topicType)
			throws Exception {
		List<AtTpUs3> aTtpUs3 = null;
		try {
			aTtpUs3 = this.dao.findPopularPostAccordingTime(topicType);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.dbc.close();
		}
		return aTtpUs3;
	}

	@Override
	public List<AtTpUs3> findPopularPostAccordingTimeParameter(
			TopicType topicType, Major major) throws Exception {
		List<AtTpUs3> aTtpUs3 = null;
		try {
			aTtpUs3 = this.dao.findPopularPostAccordingTimeParameter(topicType,
					major);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.dbc.close();
		}
		return aTtpUs3;
	}

	@Override
	public List<AtTpUs3> findPostByUserID(String userID) throws Exception {
		List<AtTpUs3> aTtpUs3 = null;
		try {
			aTtpUs3 = this.dao.findPostByUserID(userID);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.dbc.close();
		}
		return aTtpUs3;
	}

	@Override
	public List<AtTpUs3> findPostByTypeID(int typeID) throws Exception {
		List<AtTpUs3> aTtpUs3 = null;
		try {
			aTtpUs3 = this.dao.findPostByTypeID(typeID);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.dbc.close();
		}
		return aTtpUs3;
	}

	@Override
	public List<AtTpUs3> findPostByFavorUserID(String userID) throws Exception {
		List<AtTpUs3> aTtpUs3 = null;
		try {
			aTtpUs3 = this.dao.findPostByFavorUserID(userID);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.dbc.close();
		}
		return aTtpUs3;
	}

}
