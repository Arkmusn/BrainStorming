package cn.gduf.brainstorming.controller.util;

/**
 * ������ ������·��������
 * 
 * @author Arkmusn
 * 
 */
public abstract class PathManager {
	// ��½��תҳ��·��
	private static String loginSkipURL = "skip.html";
	private static String articleBaseURL = "p/";

	public PathManager() {
	}

	/**
	 * ���ص�½��תҳ��·��
	 * 
	 * @return ��½��תҳ��·��
	 */
	public static String getLoginSkipURL() {
		return loginSkipURL;
	}

}
