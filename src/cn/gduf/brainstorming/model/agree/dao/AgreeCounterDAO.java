package cn.gduf.brainstorming.model.agree.dao;
/**
 * @author 集思
 * 赞的个数接口类
 */
import java.sql.SQLException;

import cn.gduf.brainstorming.model.vo.Answer;
import cn.gduf.brainstorming.model.vo.Article;


public interface AgreeCounterDAO {
	public Article findByArticleID(Article article) throws SQLException;
	public boolean modifyByArticleID(Article article) throws SQLException;
	public Answer findByAnswerID(Answer answer) throws SQLException;
	public boolean modifyByAnswerID(Answer answer) throws SQLException;
}
