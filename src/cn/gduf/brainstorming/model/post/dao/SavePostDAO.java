package cn.gduf.brainstorming.model.post.dao;

import java.sql.SQLException;

import cn.gduf.brainstorming.model.vo.Favorite;

/**
 * @author 集思
 * 收藏帖子接口类
 */
public interface SavePostDAO {
	public boolean createSavePost(Favorite favorite) throws SQLException;
}
