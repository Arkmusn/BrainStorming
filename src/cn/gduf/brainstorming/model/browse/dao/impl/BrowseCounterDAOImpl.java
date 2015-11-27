package cn.gduf.brainstorming.model.browse.dao.impl;
/**
 * @author 集思
 * 帖子浏览次数接口实现类
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import cn.gduf.brainstorming.model.browse.dao.BrowseCounterDAO;
import cn.gduf.brainstorming.model.vo.Article;

public class BrowseCounterDAOImpl implements BrowseCounterDAO {
	
	private Connection conn=null;
	private PreparedStatement ps=null;
	private ResultSet rs=null;
	
	/**
	 * 取得数据库连接
	 * @param conn
	 */
	public BrowseCounterDAOImpl(Connection conn){
		this.conn=conn;
	}

	/**
	 * 查找帖子浏览次数
	 * @param article
	 * @throws SQLException 
	 */
	@Override
	public Article findByArticleID(Article article) throws SQLException {
		Article article2 =new Article();
		
		String sql="select browseCounter from article where articleID=?";
		
		ps=conn.prepareStatement(sql);
		
		ps.setString(1, article.getArticleID());
		
		rs=ps.executeQuery();
		
		while(rs.next()){
			article2.setBrowseCounter(rs.getInt("browseCounter"));
		}
		
		rs.close();
		ps.close();
		
		return article2;
	}

	/**
	 * 修改帖子浏览次数
	 * @param article
	 * @throws SQLException 
	 */
	@Override
	public boolean modifyByArticleID(Article article) throws SQLException {
		boolean flag=false;
		
		String sql="update article set browseCounter=? where articleID=?";
		
		ps=conn.prepareStatement(sql);
		
		ps.setInt(1, article.getBrowseCounter());
		ps.setString(2, article.getArticleID());
		
		int count = ps.executeUpdate();
		
		if(count==1){
			flag=true;
		}
		
		ps.close();
		
		return flag;
	}

}
