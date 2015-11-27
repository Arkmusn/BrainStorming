package cn.gduf.brainstorming.model.post.proxy;

/**
 * @author 集思
 * 收藏帖子代理类
 */
import java.sql.SQLException;

import cn.gduf.brainstorming.model.dbc.DatabaseConnection;
import cn.gduf.brainstorming.model.post.dao.SavePostDAO;
import cn.gduf.brainstorming.model.post.dao.impl.SavePostDAOImpl;
import cn.gduf.brainstorming.model.vo.Favorite;

public class SavePostProxy implements SavePostDAO {

	private DatabaseConnection dbc = null;
	private SavePostDAO dao = null;

	public SavePostProxy() {
		dbc = new DatabaseConnection();
		dao = new SavePostDAOImpl(dbc.getConnection());
	}

	@Override
	public boolean createSavePost(Favorite favorite) throws SQLException {
		boolean flag = false;

		try {
			flag = dao.createSavePost(favorite);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				dbc.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return flag;
	}

}
