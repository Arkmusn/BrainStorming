package cn.gduf.brainstorming.controller.util;

import java.util.ArrayList;
import java.util.List;

/**
 * json对象
 * 
 * @author Arkmusn
 * 
 */
public class JsonObject {
	List<String> list = null;

	/**
	 * 构建一个json对象
	 */
	public JsonObject() {
		this.list = new ArrayList<String>();
	}

	/**
	 * 为json添加键值对
	 * 
	 * @param key
	 *            - 键
	 * @param value
	 *            - 值
	 */
	public void add(String key, String value) {
		String jsonOrder = "\"" + key + "\":" + value;
		this.list.add(jsonOrder);
	}

	@Override
	/**
	 * 重写的方法
	 * 返回json的字符串形式
	 * return json的字符串形式
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
