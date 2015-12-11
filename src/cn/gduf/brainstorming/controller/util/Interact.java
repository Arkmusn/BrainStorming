package cn.gduf.brainstorming.controller.util;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

/**
 * 后台输出处理类
 * 
 * @author Arkmusn
 * 
 */
public abstract class Interact {

	/**
	 * 以JSON形式
	 * 
	 * @param out
	 *            - 输出流
	 * @throws IOException
	 */
	public static void outAsJSON(HttpServletResponse response, JSONObject json)
			throws IOException {
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		out.print(json);
	}

	/**
	 * 以String形式
	 * 
	 * @param out
	 *            - 输出流
	 * @throws IOException
	 */
	public static void outAsString(HttpServletResponse response, String strOut)
			throws IOException {
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		out.print(strOut);
	}

}
