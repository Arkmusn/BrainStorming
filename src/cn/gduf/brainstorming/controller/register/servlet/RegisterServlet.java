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
 * 用户注册Servlet类
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
		// type - 验证类型
		// 0 - 用户名重复性校验
		// 1 - 邮箱重复性校验
		// 2 - 确认注册处理

		// 用户名重复性校验
		if (type.equals("0")) {
			String userName = request.getParameter("username");
			User userTemp = new User();
			userTemp.setUserName(userName);
			// 检查是否存在该用户名
			boolean flag = RegisterCheck.isUserNameExisted(userTemp);
			if (flag == true) {
				json.add("registerFlag", "1");
				strOut = json.toString();
			} else {
				json.add("registerFlag", "0");
				strOut = json.toString();
			}
		}
		// 邮箱重复性校验
		else if (type.equals("1")) {
			String userEmail = request.getParameter("email");
			User userTemp = new User();
			userTemp.setUserEmail(userEmail);
			// 检查是否存在该邮箱
			boolean flag = RegisterCheck.isUserEmailExisted(userTemp);
			if (flag == true) {
				json.add("emailFlag", "1");
				strOut = json.toString();
			} else {
				json.add("emailFlag", "0");
				strOut = json.toString();
			}
		}
		// 确认注册处理
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
