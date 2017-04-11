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

		// type - ��֤����
		// 0 - �����û�����������
		// 1 - �����¼��֤
		// 2 - У���û����Ƿ����

		// �����û�����������
		if (type.equals("0")) {
			json = new JSONObject();
			User userTemp = new User();

			String userName = request.getParameter("username");
			userTemp.setUserName(userName);

			// ��ȡ����
			String userPassword = LoginCheck.getUserPassword(userTemp);
			json.accumulate("success", 1);
			json.accumulate("password", userPassword);
		}
		// �����¼��֤
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
		// У���û����Ƿ����
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