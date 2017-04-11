package cn.gduf.brainstorming.controller.core;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.gduf.brainstorming.model.factory.DAOFactory;
import cn.gduf.brainstorming.model.vo.AtTpUs3;
import cn.gduf.brainstorming.model.vo.Major;
import cn.gduf.brainstorming.model.vo.TopicType;

/**
 * ������չʾ������
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
	 * ������������չʾ��������
	 * 
	 * @param order
	 *            - ��������
	 */
	public Question(int order) {
		List<AtTpUs3> list = null;

		// ��������ʽ
		// 0 - ������
		// 1 - ����ʱ��

		// ������
		if (order == 0) {
			try {
				list = DAOFactory.getPostHeadDAOInstance()
						.findPopularPostAccordingAnswer(topicTypeOfQuestion);

				this.listArticle = new ArrayList<Map<String, String>>();

				// ������������
				for (int index = 0, length = list.size(); index < length; index++) {
					Date date = list.get(index).getArticle().getCreateTime();
					Calendar cal = Calendar.getInstance();
					cal.setTime(date);
					int month = cal.get(Calendar.MONTH);
					int day = cal.get(Calendar.DAY_OF_MONTH);

					Map<String, String> map = new HashMap<String, String>();
					map.put("userImg", list.get(index).getUser()
							.getPicturePath());
					map.put("title", list.get(index).getArticle()
							.getArticleTitle());
					map.put("titleUrl", "article.html");
					map.put("userName", list.get(index).getUser().getUserName());
					map.put("Atime", "" + month + "-" + day);
					map.put("preview", list.get(index).getArticle()
							.getPreview());
					map.put("answer", ""
							+ list.get(index).getArticle().getAnswerCounter());

					this.listArticle.add(map);
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		// ����ʱ��
		else if (order == 1) {
			try {
				list = DAOFactory.getPostHeadDAOInstance()
						.findPopularPostAccordingTime(topicTypeOfQuestion);

				this.listArticle = new ArrayList<Map<String, String>>();

				// ������������
				for (int index = 0, length = list.size(); index < length; index++) {
					Date date = list.get(index).getArticle().getCreateTime();
					Calendar cal = Calendar.getInstance();
					cal.setTime(date);
					int month = cal.get(Calendar.MONTH);
					int day = cal.get(Calendar.DAY_OF_MONTH);

					Map<String, String> map = new HashMap<String, String>();
					map.put("userImg", list.get(index).getUser()
							.getPicturePath());
					map.put("title", list.get(index).getArticle()
							.getArticleTitle());
					map.put("titleUrl", "article.html");
					map.put("userName", list.get(index).getUser().getUserName());
					map.put("Atime", "" + month + "-" + day);
					map.put("preview", list.get(index).getArticle()
							.getPreview());
					map.put("answer", ""
							+ list.get(index).getArticle().getAnswerCounter());

					this.listArticle.add(map);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	/**
	 * ����רҵ����������չʾ����
	 * 
	 * @param major
	 *            - רҵ
	 * @param order
	 *            - ��������
	 */
	public Question(int order, String major) {
		List<AtTpUs3> list = null;
		Major majorTemp = new Major();
		majorTemp.setMajorName(major);

		// ��������ʽ
		// 0 - ������
		// 1 - ����ʱ��

		// ������
		if (order == 0) {
			try {
				list = DAOFactory.getPostHeadDAOInstance()
						.findPopularPostAccordingAnswerParameter(
								topicTypeOfQuestion, majorTemp);

				this.listArticle = new ArrayList<Map<String, String>>();

				// ������������
				for (int index = 0, length = list.size(); index < length; index++) {
					Date date = list.get(index).getArticle().getCreateTime();
					Calendar cal = Calendar.getInstance();
					cal.setTime(date);
					int month = cal.get(Calendar.MONTH);
					int day = cal.get(Calendar.DAY_OF_MONTH);

					Map<String, String> map = new HashMap<String, String>();
					map.put("userImg", list.get(index).getUser()
							.getPicturePath());
					map.put("title", list.get(index).getArticle()
							.getArticleTitle());
					map.put("titleUrl", "article.html");
					map.put("userName", list.get(index).getUser().getUserName());
					map.put("Atime", "" + month + "-" + day);
					map.put("preview", list.get(index).getArticle()
							.getPreview());
					map.put("answer", ""
							+ list.get(index).getArticle().getAnswerCounter());

					this.listArticle.add(map);
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		// ����ʱ��
		else if (order == 1) {
			try {
				list = DAOFactory.getPostHeadDAOInstance()
						.findPopularPostAccordingTimeParameter(
								topicTypeOfQuestion, majorTemp);

				this.listArticle = new ArrayList<Map<String, String>>();

				// ������������
				for (int index = 0, length = list.size(); index < length; index++) {
					Date date = list.get(index).getArticle().getCreateTime();
					Calendar cal = Calendar.getInstance();
					cal.setTime(date);
					int month = cal.get(Calendar.MONTH);
					int day = cal.get(Calendar.DAY_OF_MONTH);

					Map<String, String> map = new HashMap<String, String>();
					map.put("userImg", list.get(index).getUser()
							.getPicturePath());
					map.put("title", list.get(index).getArticle()
							.getArticleTitle());
					map.put("titleUrl", "article.html");
					map.put("userName", list.get(index).getUser().getUserName());
					map.put("Atime", "" + month + "-" + day);
					map.put("preview", list.get(index).getArticle()
							.getPreview());
					map.put("answer", ""
							+ list.get(index).getArticle().getAnswerCounter());

					this.listArticle.add(map);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public List<Map<String, String>> getListArticle() {
		return listArticle;
	}

}
