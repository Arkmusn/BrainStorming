package cn.gduf.brainstorming.controller.register.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.gduf.brainstorming.controller.register.Register;
import cn.gduf.brainstorming.controller.register.RegisterCheck;
import cn.gduf.brainstorming.controller.util.JsonObject;
import cn.gduf.brainstorming.controller.util.PathManager;
import cn.gduf.brainstorming.model.vo.User;

/**
 * �û�ע��Servlet��
 * 
 * @author Arkmusn
 * 
 */
@SuppressWarnings("serial")
public class RegisterServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String type = request.getParameter("type");
		String strOut = null;
		JsonObject json = new JsonObject();
		// type - ��֤����
		// 0 - �û����ظ���У��
		// 1 - �����ظ���У��
		// 2 - ȷ��ע�ᴦ��

		// �û����ظ���У��
		if (type.equals("0")) {
			String userName = request.getParameter("username");
			User userTemp = new User();
			userTemp.setUserName(userName);
			// ����Ƿ���ڸ��û���
			boolean flag = RegisterCheck.isUserNameExisted(userTemp);
			if (flag == true) {
				json.add("registerFlag", "1");
				strOut = json.toString();
			} else {
				json.add("registerFlag", "0");
				strOut = json.toString();
			}
		}
		// �����ظ���У��
		else if (type.equals("1")) {
			String userEmail = request.getParameter("email");
			User userTemp = new User();
			userTemp.setUserEmail(userEmail);
			// ����Ƿ���ڸ�����
			boolean flag = RegisterCheck.isUserEmailExisted(userTemp);
			if (flag == true) {
				json.add("emailFlag", "1");
				strOut = json.toString();
			} else {
				json.add("emailFlag", "0");
				strOut = json.toString();
			}
		}
		// ȷ��ע�ᴦ��
		else if (type.equals("2")) {
			String userName = request.getParameter("username");
			String userEmail = request.getParameter("email");
			String userPassword = request.getParameter("password");
			User userTemp = new User();
			userTemp.setUserName(userName);
			userTemp.setUserEmail(userEmail);
			userTemp.setUserPassword(userPassword);

			Register register = new Register(userTemp);
			boolean flag = register.excute();
			if (flag == true) {
				json.add("success", "1");
				json.add("url", PathManager.getLoginSkipURL());
			} else {
				json.add("success", "0");
			}

		}
		System.out.println(strOut);
		PrintWriter out = response.getWriter();
		out.println(strOut);
	}

}
