package cn.gduf.brainstorming.model.post.proxy;

/**
 * @author 集思
 * 显示帖子详细内容代理类
 */
import java.sql.SQLException;

import cn.gduf.brainstorming.model.dbc.DatabaseConnection;
import cn.gduf.brainstorming.model.post.dao.PostTextDAO;
import cn.gduf.brainstorming.model.post.dao.impl.PostTextDAOImpl;
import cn.gduf.brainstorming.model.vo.Article;
import cn.gduf.brainstorming.model.vo.AtUsShMjAnTpFl7;

public class PostTextProxy implements PostTextDAO {

	private DatabaseConnection dbc = null; // 数据库连接对象
	private PostTextDAO dao = null; // 显示帖子详细内容接口类

	/**
	 * 构造方法，打开数据库和实现接口
	 */
	public PostTextProxy() {
		this.dbc = new DatabaseConnection(); // 取得数据库连接对象
		this.dao = new PostTextDAOImpl(this.dbc.getConnection()); // 实例化帖子详细内容接口实现类
	}

	@Override
	public AtUsShMjAnTpFl7 findPostByURL(Article article) throws SQLException {
		// 实体类
		AtUsShMjAnTpFl7 vo7 = null;

		try {

			vo7 = dao.findPostByURL(article);

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
		return vo7;
	}

}
