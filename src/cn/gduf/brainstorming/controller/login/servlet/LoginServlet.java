package cn.gduf.brainstorming.controller.login.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;
import cn.gduf.brainstorming.controller.login.LoginCheck;
import cn.gduf.brainstorming.controller.util.Interact;
import cn.gduf.brainstorming.model.vo.User;

@SuppressWarnings("serial")
public class LoginServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		JSONObject json = null;

		String type = request.getParameter("type");

		// type - 验证类型
		// 0 - 接受用户名返回密码
		// 1 - 常规登录验证
		// 2 - 校验用户名是否存在

		// 接受用户名返回密码
		if (type.equals("0")) {
			json = new JSONObject();
			User userTemp = new User();

			String userName = request.getParameter("username");
			userTemp.setUserName(userName);

			// 获取密码
			String userPassword = LoginCheck.getUserPassword(userTemp);
			json.accumulate("success", 1);
			json.accumulate("password", userPassword);
		}
		// 常规登录验证
		else if (type.equals("1")) {
			json = new JSONObject();
			User userTemp = new User();

			String userName = request.getParameter("username");
			String userPassword = request.getParameter("password");
			userTemp.setUserName(userName);
			userTemp.setUserPassword(userPassword);

			boolean flag = LoginCheck.isIdentifiedUser(userTemp);

			if (flag == true) {
				json.accumulate("success", 1);
			} else {
				json.accumulate("success", 0);
			}
		}
		// 校验用户名是否存在
		else if (type.equals("2")) {
			json = new JSONObject();
			User userTemp = new User();

			String userName = request.getParameter("username");
			userTemp.setUserName(userName);

			boolean flag = LoginCheck.isUserExisted(userTemp);

			if (flag == true) {
				json.accumulate("registerFlag", 1);
			} else {
				json.accumulate("registerFlag", 0);
			}
		}

		Interact.outAsJSON(response, json);
	}
}