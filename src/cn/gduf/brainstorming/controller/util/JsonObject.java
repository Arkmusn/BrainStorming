package cn.gduf.brainstorming.controller.util;

import java.util.ArrayList;
import java.util.List;

/**
 * json����
 * 
 * @author Arkmusn
 * 
 */
public class JsonObject {
	List<String> list = null;

	/**
	 * ����һ��json����
	 */
	public JsonObject() {
		this.list = new ArrayList<String>();
	}

	/**
	 * Ϊjson��Ӽ�ֵ��
	 * 
	 * @param key
	 *            - ��
	 * @param value
	 *            - ֵ
	 */
	public void add(String key, String value) {
		String jsonOrder = "\"" + key + "\":" + value;
		this.list.add(jsonOrder);
	}

	@Override
	/**
	 * ��д�ķ���
	 * ����json���ַ�����ʽ
	 * return json���ַ�����ʽ
	 */
	public String toString() {
		StringBuilder str = new StringBuilder("{");
		for (int index = 0, length = this.list.size(); index < length; index++) {
			if (index == 0) {
				str.append(list.get(index));
			} else {
				str.append(", " + list.get(index));
			}
		}
		str.append("}");
		return str.toString();
	}
}
