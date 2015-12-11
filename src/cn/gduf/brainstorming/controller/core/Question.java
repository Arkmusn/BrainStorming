package cn.gduf.brainstorming.controller.core;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.gduf.brainstorming.model.factory.DAOFactory;
import cn.gduf.brainstorming.model.vo.AtTpUs3;
import cn.gduf.brainstorming.model.vo.TopicType;

/**
 * 问题板块展示帖子类
 * 
 * @author Arkmusn
 * 
 */
public class Question {

	private List<Map<String, String>> listArticle = null;

	private static TopicType topicTypeOfQuestion = null;

	private final static int TYPE_OF_QUESTION = 2;

	static {
		topicTypeOfQuestion = new TopicType();
		topicTypeOfQuestion.setTypeID(TYPE_OF_QUESTION);
	}

	/**
	 * 根据排序类型展示所有帖子
	 * 
	 * @param order
	 *            - 排序类型
	 */
	public Question(int order) {
		List<AtTpUs3> list = null;

		// 帖子排序方式
		// 0 - 评论数
		// 1 - 发布时间

		// 评论数
		if (order == 0) {
			try {
				list = DAOFactory.getPostHeadDAOInstance()
						.findPopularPostAccordingAnswer(topicTypeOfQuestion);

				this.listArticle = new ArrayList<Map<String, String>>();

				// 遍历加入帖子
				for (int index = 0, length = list.size(); index < length; index++) {
					Date date = list.get(index).getArticle().getCreateTime();

					Map<String, String> map = new HashMap<String, String>();
					map.put("userImg", list.get(index).getUser()
							.getPicturePath());
					map.put("title", list.get(index).getArticle()
							.getArticleTitle());
					map.put("titleUrl", "article.html?aid="
							+ list.get(index).getArticle().getArticleURL());
					map.put("userName", list.get(index).getUser().getUserName());
					map.put("Atime", list.get(index).getArticle()
							.getCreateTime().toString());
					map.put("preview", "*");
					map.put("answer", "0");

					this.listArticle.add(map);
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		// 发布时间
		else if (order == 1) {
			try {
				list = DAOFactory.getPostHeadDAOInstance()
						.findPopularPostAccordingAnswer(topicTypeOfQuestion);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	/**
	 * 根据专业和排序类型展示帖子
	 * 
	 * @param major
	 *            - 专业
	 * @param order
	 *            - 排序类型
	 */
	public Question(int order, String major) {
		List<AtTpUs3> list = null;
	}

	public List<Map<String, String>> getListArticle() {
		return listArticle;
	}

}
