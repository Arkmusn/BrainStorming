package cn.gduf.brainstorming.controller.core.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.gduf.brainstorming.controller.core.Question;
import cn.gduf.brainstorming.controller.util.Interact;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * 问题板块servlet类
 * 
 * @author Arkmusn
 * 
 */
@SuppressWarnings("serial")
public class QuestionServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		JSONObject json = null;
		JSONArray arrJson = null;
		
		String themeType = request.getParameter("MajorType");
		String orderType = request.getParameter("order");

		Question question = null;

		// 查找的专业是否有限制
		
		// 无限制
		if (themeType.equals("allMajor")) {
			question = new Question(Integer.parseInt(orderType));
			
			json = new JSONObject();
			json.accumulate("success", 1);
			arrJson = JSONArray.fromObject(question.getListArticle());
			json.put("article", arrJson);
		}
		// 有限制
		else {
			question = new Question(Integer.parseInt(orderType), themeType);
		}
		
		Interact.outAsJSON(response, json);
		System.out.println(json);
	}

}
