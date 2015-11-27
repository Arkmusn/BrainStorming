package cn.gduf.brainstorming.model.post.dao.impl;

/**
 * @author 集思
 * 帖子详细内容接口实现类
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import cn.gduf.brainstorming.model.post.dao.PostTextDAO;
import cn.gduf.brainstorming.model.vo.Article;
import cn.gduf.brainstorming.model.vo.AtUsShMjAnTpFl7;
import cn.gduf.brainstorming.model.vo.Major;
import cn.gduf.brainstorming.model.vo.School;
import cn.gduf.brainstorming.model.vo.TopicType;
import cn.gduf.brainstorming.model.vo.User;

public class PostTextDAOImpl implements PostTextDAO {

	private Connection conn = null;
	private PreparedStatement ps = null;
	private ResultSet rs = null;

	/**
	 * 建立数据库连接
	 * 
	 * @param conn
	 */
	public PostTextDAOImpl(Connection conn) {
		this.conn = conn;
	}

	/**
	 * 查找帖子详细内容
	 * 
	 * @param article
	 * @throws SQLException
	 */
	@Override
	public AtUsShMjAnTpFl7 findPostByURL(Article article) throws SQLException {

		/*
		 * 查找帖子详细内容: 标题，作者，正文，学校，专业，附件，回答，分类
		 * 返回字段：(articleTitle,userName,textPath,schoolName,majorName,typeName)
		 * 涉及的表：article（articleTitle,userID,textPath,fileID,typeID）
		 * t_user(userID,userName,schoolID,majorID) school(schoolID,schoolName)
		 * major(majorID,majorName) topicType(typeID,typeName)
		 */

		// 实例化实体类
		AtUsShMjAnTpFl7 vo7 = new AtUsShMjAnTpFl7();

		Article article2 = new Article();
		User user = new User();
		School school = new School();
		Major major = new Major();
		TopicType topic = new TopicType();

		String sql = "select articleTitle,userName,textPath,schoolName,majorName,typeName from article a,t_user u,school s,major m,topicType t where a.userID=u.userID and u.schoolID=s.schoolID and u.majorID=m.majorID and a.typeID=t.typeID and a.articleURL=?";

		ps = conn.prepareStatement(sql);
		ps.setString(1, article.getArticleURL());
		rs = ps.executeQuery();

		// 遍历结果集
		while (rs.next()) {
			article2.setArticleTitle(rs.getString("articleTitle"));
			user.setUserName(rs.getString("userName"));
			article2.setTextPath(rs.getString("textPath"));
			school.setSchoolName(rs.getString("schoolName"));
			major.setMajorName(rs.getString("majorName"));
			topic.setTypeName(rs.getString("typeName"));

			vo7.setArticle(article2);
			vo7.setUser(user);
			vo7.setSchool(school);
			vo7.setMajor(major);
			vo7.setTopic(topic);
		}
		rs.close();
		ps.close();

		return vo7;
	}

}
