package cn.gduf.brainstorming.model.firstpage.proxy;

import java.util.List;

import cn.gduf.brainstorming.model.dbc.DatabaseConnection;
import cn.gduf.brainstorming.model.firstpage.dao.SearchPostDAO;
import cn.gduf.brainstorming.model.firstpage.dao.impl.SearchPostImpl;
import cn.gduf.brainstorming.model.vo.AtTpUs3;
import cn.gduf.brainstorming.model.vo.Major;
import cn.gduf.brainstorming.model.vo.UsShMj3;

public class SearchPostProxy implements SearchPostDAO {
	private DatabaseConnection dbc = null;
	private SearchPostDAO dao = null;

	public SearchPostProxy() {
		this.dbc = new DatabaseConnection();
		this.dao = new SearchPostImpl(this.dbc.getConnection());
	}

	@Override
	public List<AtTpUs3> articleSearchByTitle(String articleTitle)
			throws Exception {
		List<AtTpUs3> aTtpUs3 = null;
		try {
			aTtpUs3 = this.dao.articleSearchByTitle(articleTitle);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			this.dbc.close();
		}
		return aTtpUs3;
	}

	@Override
	public List<AtTpUs3> articleSearchByTopic(int topicID) throws Exception {
		List<AtTpUs3> aTtpUs3 = null;
		try {
			aTtpUs3 = this.dao.articleSearchByTopic(topicID);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			this.dbc.close();
		}
		return aTtpUs3;
	}

	@Override
	public List<UsShMj3> userSearchByUserName(String userName) throws Exception {
		List<UsShMj3> usShMj3 = null;
		try {
			usShMj3 = this.dao.userSearchByUserName(userName);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			this.dbc.close();
		}
		return usShMj3;
	}

	@Override
	public List<Major> majorSearchByMajorName(String majorName)
			throws Exception {
		List<Major> major = null;
		try {
			major = this.dao.majorSearchByMajorName(majorName);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			this.dbc.close();
		}
		return major;
	}

}
