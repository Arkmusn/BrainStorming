package cn.gduf.brainstorming.controller.login.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.gduf.brainstorming.controller.login.LoginCheck;
import cn.gduf.brainstorming.controller.util.JsonObject;
import cn.gduf.brainstorming.model.vo.User;

@SuppressWarnings("serial")
public class LoginServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String strOut = null;
		JsonObject json = new JsonObject();

		String type = request.getParameter("type");

		// type - 验证类型
		// 0 - 接受用户名返回密码
		// 1 - 常规登录验证
		// 2 - 校验用户名是否存在
		// 接受用户名返回密码
		if (type.equals("0")) {
			User userTemp = new User();

			String userName = request.getParameter("username");
			userTemp.setUserName(userName);

			// 获取密码
			String userPassword = LoginCheck.getUserPassword(userTemp);
			json.add("success", 1);
			json.add("password", userPassword);
			strOut = json.toString();
		}
		// 常规登录验证
		else if (type.equals("1")) {
			User userTemp = new User();

			String userName = request.getParameter("username");
			String userPassword = request.getParameter("password");
			userTemp.setUserName(userName);
			userTemp.setUserPassword(userPassword);

			boolean flag = LoginCheck.isIdentifiedUser(userTemp);

			if (flag == true) {
				json.add("success", 1);
			} else {
				json.add("success", 0);
			}
			strOut = json.toString();
		}
		// 校验用户名是否存在
		else if (type.equals("2")) {
			User userTemp = new User();

			String userName = request.getParameter("username");
			userTemp.setUserName(userName);

			boolean flag = LoginCheck.isUserExisted(userTemp);

			if (flag == true) {
				json.add("registerFlag", 1);
			} else {
				json.add("registerFlag", 0);
			}
			strOut = json.toString();
		}

		System.out.println(strOut);
		PrintWriter out = response.getWriter();
		out.println(strOut);

	}
}
