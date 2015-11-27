package cn.gduf.brainstorming.model.userpage.proxy;
/**
 * 个人信息代理类
 */
import cn.gduf.brainstorming.model.dbc.DatabaseConnection;
import cn.gduf.brainstorming.model.userpage.dao.UserBasicInfoDAO;
import cn.gduf.brainstorming.model.userpage.dao.impl.UserBasciInfoImpl;
import cn.gduf.brainstorming.model.vo.UsShMj3;
import cn.gduf.brainstorming.model.vo.User;

public class UserBasicInfoProxy implements UserBasicInfoDAO {
	private DatabaseConnection dbc = null;
	private UserBasicInfoDAO dao = null;

	public UserBasicInfoProxy() {
		this.dbc = new DatabaseConnection();
		this.dao = new UserBasciInfoImpl(this.dbc.getConnection());
	}

	@Override
	public UsShMj3 findInfoByUserID(String userID) throws Exception {
		UsShMj3 usShMj3 = null;
		try {
			usShMj3 = this.dao.findInfoByUserID(userID);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			this.dbc.close();
		}
		return usShMj3;
	}

	@Override
	public boolean modifyInfo(User user) throws Exception {
		boolean flag = false;
		try {
			flag = this.dao.modifyInfo(user);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			this.dbc.close();
		}
		return flag;
	}

}
