package cn.gduf.brainstorming.controller.util;

/**
 * 抽象类 服务器路径管理类
 * 
 * @author Arkmusn
 * 
 */
public abstract class PathManager {
	// 登陆跳转页面路径
	private static String loginSkipURL = "skip.html";
	private static String articleBaseURL = "p/";

	public PathManager() {
	}

	/**
	 * 返回登陆跳转页面路径
	 * 
	 * @return 登陆跳转页面路径
	 */
	public static String getLoginSkipURL() {
		return loginSkipURL;
	}

}
