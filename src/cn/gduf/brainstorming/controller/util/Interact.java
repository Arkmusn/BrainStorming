package cn.gduf.brainstorming.controller.util;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

/**
 * ��̨���������
 * 
 * @author Arkmusn
 * 
 */
public abstract class Interact {

	/**
	 * ��JSON��ʽ
	 * 
	 * @param out
	 *            - �����
	 * @throws IOException
	 */
	public static void outAsJSON(HttpServletResponse response, JSONObject json)
			throws IOException {
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		out.print(json);
	}

	/**
	 * ��String��ʽ
	 * 
	 * @param out
	 *            - �����
	 * @throws IOException
	 */
	public static void outAsString(HttpServletResponse response, String strOut)
			throws IOException {
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		out.print(strOut);
	}

}
