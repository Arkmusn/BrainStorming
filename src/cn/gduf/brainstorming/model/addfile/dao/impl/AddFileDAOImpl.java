package cn.gduf.brainstorming.model.addfile.dao.impl;
/**
 * 附件接口实现类
 * @author 集思
 * 
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.gduf.brainstorming.model.addfile.dao.AddFileDAO;
import cn.gduf.brainstorming.model.vo.Addfile;

public class AddFileDAOImpl implements AddFileDAO {

	private Connection conn=null;
	private PreparedStatement ps=null;
	private ResultSet rs=null;
	
	/**
	 * 取得数据库连接
	 * @param conn
	 */
	public AddFileDAOImpl(Connection conn){
		this.conn=conn;
	}
	
	/**
	 * 添加附件
	 * @param addfile
	 * @throws SQLException 
	 */
	@Override
	public boolean createAddfile(Addfile addfile) throws SQLException {
		boolean flag=false;
		
		String sql="insert into addfile(fileID,filePath,articleID) values(?,?,?)";
		
		ps=conn.prepareStatement(sql);
		
		ps.setString(1, addfile.getFileID());
		ps.setString(2, addfile.getFilePath());
		ps.setString(3, addfile.getArticleID());
		
		int count=ps.executeUpdate();
		
		if(count==1){
			flag=true;
		}
		
		ps.close();
		
		return flag;
	}

	/**
	 * 显示附件(查出来自同一帖子的附件，条件articleID，显示出附件名称，附件上传时间)
	 * @param addfile
	 * @throws SQLException 
	 */
	@Override
	public List<Addfile> showAddfile(Addfile addfile) throws SQLException {
		List<Addfile> list=new ArrayList<Addfile>();
		
		String sql="select fileID,filePath,saveTime from addfile where articleID=?";
		
		ps=conn.prepareStatement(sql);
		
		ps.setString(1, addfile.getArticleID());
		
		rs=ps.executeQuery();
		
		while(rs.next()){
			Addfile file=new Addfile();
			file.setFileID(rs.getString("fileID"));
			file.setFilePath(rs.getString("filePath"));
			file.setSaveTime(rs.getString("saveTime"));
			list.add(file);
		}
		rs.close();
		ps.close();
		
		
		return list;
	}

}
