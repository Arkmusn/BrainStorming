package cn.gduf.brainstorming.controller.register.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;
import cn.gduf.brainstorming.controller.register.Register;
import cn.gduf.brainstorming.controller.register.RegisterCheck;
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
		JSONObject json = null;
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
			json = new JSONObject();
			if (flag == true) {
				json.accumulate("registerFlag", 1);
			} else {
				json.accumulate("registerFlag", 0);
			}
		}
		// 邮箱重复性校验
		else if (type.equals("1")) {
			String userEmail = request.getParameter("email");
			User userTemp = new User();
			userTemp.setUserEmail(userEmail);
			// 检查是否存在该邮箱
			boolean flag = RegisterCheck.isUserEmailExisted(userTemp);
			json = new JSONObject();
			if (flag == true) {
				json.accumulate("emailFlag", 1);
			} else {
				json.accumulate("emailFlag", 0);
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
			json = new JSONObject();
			if (flag == true) {
				json.accumulate("success", 1);
				json.accumulate("url", PathManager.getLoginSkipURL()
						+ "?username=" + userName);
			} else {
				json.accumulate("success", "0");
			}
		}
		PrintWriter out = response.getWriter();
		out.println(json);
	}
}
