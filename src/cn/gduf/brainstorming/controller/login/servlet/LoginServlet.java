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

		// type - ��֤����
		// 0 - �����û�����������
		// 1 - �����¼��֤
		// 2 - У���û����Ƿ����
		// �����û�����������
		if (type.equals("0")) {
			User userTemp = new User();

			String userName = request.getParameter("username");
			userTemp.setUserName(userName);

			// ��ȡ����
			String userPassword = LoginCheck.getUserPassword(userTemp);
			json.add("success", 1);
			json.add("password", userPassword);
			strOut = json.toString();
		}
		// �����¼��֤
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
		// У���û����Ƿ����
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
