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

public class PostHeadProxy implements PostHeadDAO {
	private DatabaseConnection dbc = null;
	private PostHeadDAO dao = null;

	public PostHeadProxy() {
		this.dbc = new DatabaseConnection();
		this.dao = new PostHeadImpl(this.dbc.getConnection());
	}

	@Override
	public List<AtTpUs3> findPopularPost() throws Exception {
		List<AtTpUs3> aTtpUs3 = null;
		try {
			aTtpUs3 = this.dao.findPopularPost();
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
