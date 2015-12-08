package cn.gduf.brainstorming.controller.userinfo.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.gduf.brainstorming.controller.userinfo.UserInfo;
import cn.gduf.brainstorming.controller.util.JsonObject;
import cn.gduf.brainstorming.model.vo.User;

/**
 * 用户基本信息Servlet类
 * 
 * @author Arkmusn
 * 
 */
@SuppressWarnings("serial")
public class UserInfoServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String userName = request.getParameter("username");
		JsonObject json = new JsonObject();
		String strOut = null;
		User user = new User();
		user.setUserName(userName);

		UserInfo info = new UserInfo(user);
		
		if (info.getUser() != null && info.getSchool() != null
				&& info.getMajor() != null) {
			json.add("success", 1);
			json.add("username", info.getUser().getUserName());
			json.add("school", info.getSchool().getSchoolName());
			json.add("major", info.getMajor().getMajorName());
			json.add("arti_num", info.getArticleCount());
			json.add("JoinTime", info.getDays());
			// unfinished
			json.add("Usrimg", "");
			json.add("interest", info.getInterest());
			
		}

		PrintWriter out = response.getWriter();
		out.println(strOut);
	}

}
