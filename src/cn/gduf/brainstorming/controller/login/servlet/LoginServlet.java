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
		
		User userTemp = new User();
		
		String userName = request.getParameter("username");
		String userPassword = request.getParameter("password");
		userTemp.setUserName(userName);
		userTemp.setUserPassword(userPassword);
		
		boolean flag = LoginCheck.isIdentifiedUser(userTemp);
		
		
		PrintWriter out = response.getWriter();
		out.println(strOut);

	}

}
