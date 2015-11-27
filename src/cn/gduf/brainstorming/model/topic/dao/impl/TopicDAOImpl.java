package cn.gduf.brainstorming.model.topic.dao.impl;
/**
 * @author 集思
 * 话题接口实现类
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.gduf.brainstorming.model.topic.dao.TopicDAO;
import cn.gduf.brainstorming.model.vo.Major;
import cn.gduf.brainstorming.model.vo.Theme;

public class TopicDAOImpl implements TopicDAO {

	private Connection conn=null;
	private PreparedStatement ps=null;
	private ResultSet rs=null;
	
	/**
	 * 取得数据库连接
	 * @param conn
	 */
	public TopicDAOImpl(Connection conn){
		this.conn=conn;
	}
	
	/**
	 * 显示用户感兴趣的话题
	 * @param theme
	 * @throws SQLException 
	 */
	@Override
	public List<Major> showUserLoveTopic(Theme theme) throws SQLException {
		List<Major> list=new ArrayList<Major>();
		
		String sql="select majorName from theme,major where theme.majorID=major.majorID and userID=?";
		
		ps=conn.prepareStatement(sql);
		
		ps.setString(1, theme.getUserID());
		
		rs=ps.executeQuery();
		
		while(rs.next()){
			Major major=new Major();
			major.setMajorName(rs.getString("majorName"));
			list.add(major);
		}
		
		rs.close();
		ps.close();
		
		return list;
	}

	/**
	 * 添加用户感兴趣的话题
	 * @param theme
	 * @throws SQLException 
	 */
	@Override
	public boolean insertUserLoveTopic(Theme theme) throws SQLException {
		boolean flag=false;
		
		String sql="insert into theme(userID,majorID) values(?,?)";
		
		ps=conn.prepareStatement(sql);
		
		ps.setString(1, theme.getUserID());
		ps.setString(2, theme.getMajorID());
		
		int count=ps.executeUpdate();
		
		if(count==1){
			flag=true;
		}
		
		ps.close();
		
		return flag;
	}

	/**
	 * 显示单个话题
	 * @param major
	 * @throws SQLException 
	 */
	@Override
	public Major showSingleTopic(Major major) throws SQLException {
		Major major2=new Major();
		
		String sql="select majorName from major where majorID=?";
		
		ps=conn.prepareStatement(sql);
		
		ps.setString(1, major.getMajorID());
		
		rs=ps.executeQuery();
		
		while(rs.next()){
			major2.setMajorName(rs.getString("majorName"));
		}
		
		rs.close();
		ps.close();
		
		
		return major2;
	}

	/**
	 * 显示板块涉及的话题
	 * @throws SQLException 
	 */
	@Override
	public List<Major> showAllTopic() throws SQLException {
		List<Major> list=new ArrayList<Major>();
		
		String sql="select majorName from major";
		
		ps=conn.prepareStatement(sql);
		
		rs=ps.executeQuery();
		
		while(rs.next()){
			Major major =new Major();
			major.setMajorName(rs.getString("majorName"));
			list.add(major);
			
		}
		
		return list;
	}

}
