package cn.gduf.brainstorming.model.post.dao;

import java.sql.SQLException;

import cn.gduf.brainstorming.model.vo.Article;
import cn.gduf.brainstorming.model.vo.AtUsShMjAnTpFl7;

/**
 * @author 集思
 * 显示帖子详细内容接口类
 */
public interface PostTextDAO {
	public AtUsShMjAnTpFl7 findPostByURL(Article article) throws SQLException;
}
