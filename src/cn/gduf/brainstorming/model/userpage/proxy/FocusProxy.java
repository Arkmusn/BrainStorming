package cn.gduf.brainstorming.model.userpage.proxy;

import java.util.List;

import cn.gduf.brainstorming.model.dbc.DatabaseConnection;
import cn.gduf.brainstorming.model.userpage.dao.FocusDAO;
import cn.gduf.brainstorming.model.userpage.dao.impl.FocusImpl;
import cn.gduf.brainstorming.model.vo.Focus;
import cn.gduf.brainstorming.model.vo.User;

public class FocusProxy implements FocusDAO {

	DatabaseConnection dbc = null;
	FocusDAO dao = null;

	public FocusProxy() {
		this.dbc = new DatabaseConnection();
		this.dao = new FocusImpl(this.dbc.getConnection());
	}

	@Override
	public boolean insertFocus(Focus focus) throws Exception {
		boolean flag = false;
		try {
			flag = this.dao.insertFocus(focus);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			this.dbc.close();
		}
		return flag;
	}

	@Override
	public List<User> showFocusList(User user) throws Exception {
		List<User> userTemp = null;
		try {
			userTemp = this.dao.showFocusedList(user);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			this.dbc.close();
		}
		return userTemp;
	}

	@Override
	public List<User> showFocusedList(User user) throws Exception {
		List<User> userTemp = null;
		try {
			userTemp = this.dao.showFocusedList(user);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			this.dbc.close();
		}
		return userTemp;
	}

}
