package cn.gduf.brainstorming.controller.userinfo.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;
import cn.gduf.brainstorming.controller.userinfo.UserInfo;
import cn.gduf.brainstorming.controller.util.Interact;
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
		JSONObject json = new JSONObject();
		User user = new User();
		user.setUserName(userName);

		UserInfo info = new UserInfo(user);

		if (info.getUser() != null && info.getSchool() != null
				&& info.getMajor() != null) {
			json.accumulate("success", 1);
			json.accumulate("username", info.getUser().getUserName());
			if (!(info.getSchool().getSchoolName() == null)) {
				json.accumulate("school", info.getSchool().getSchoolName());
			} else {
				json.accumulate("school", "*");
			}
			if (!(info.getMajor().getMajorName() == null)) {
				json.accumulate("major", info.getMajor().getMajorName());
			} else {
				json.accumulate("major", "*");
			}
			json.accumulate("arti_num", info.getArticleCount());
			json.accumulate("JoinTime", info.getDays());
			// unfinished
			json.accumulate("Usrimg", info.getUser().getPicturePath());
			json.accumulate("interest", info.getInterest());

		}

		Interact.outAsJSON(response, json);
		System.out.println(json);
	}

}
