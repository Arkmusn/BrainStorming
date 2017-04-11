package cn.gduf.brainstorming.controller.userinfo;

import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import cn.gduf.brainstorming.model.factory.DAOFactory;
import cn.gduf.brainstorming.model.vo.Major;
import cn.gduf.brainstorming.model.vo.School;
import cn.gduf.brainstorming.model.vo.UsShMj3;
import cn.gduf.brainstorming.model.vo.User;

/**
 * 用户信息类
 * 
 * @author Arkmusn
 * 
 */
public class UserInfo {

	private User user = null;
	private School school = null;
	private Major major = null;
	private int articleCount = 0;
	private int days = 0;
	private String interest = null;

	/**
	 * 通过User对象构建用户信息类
	 * 
	 * @param user
	 *            - User对象
	 */
	public UserInfo(User user) {
		this.user = user;
		this.getAllInfo();
		this.getTotalDays();
	}

	/**
	 * 写入该用户的所有基本信息
	 */
	private void getAllInfo() {
		User userTemp = null;
		School schoolTemp = null;
		Major majorTemp = null;
		try {
			this.user = DAOFactory.getLoginDAOInstance().findByName(this.user);

			UsShMj3 usShMj3 = DAOFactory.getUserBasicInfoDAOInstance()
					.findInfoByUserID(this.user.getUserID());

			this.articleCount = DAOFactory.getUserBasicInfoDAOInstance()
					.getCountOfArticles(this.user);

			List<Major> majorList = DAOFactory.getTopicDAOInstance()
					.showUserLoveTopic(this.user);
			this.getInterest(majorList);

			userTemp = usShMj3.getUser();
			schoolTemp = usShMj3.getSchool();
			majorTemp = usShMj3.getMajor();

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		this.user = userTemp;
		this.school = schoolTemp;
		this.major = majorTemp;
	}

	/**
	 * 获取当前用户注册总天数
	 */
	private void getTotalDays() {
		Date date = this.user.getCreateTime();
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		// 当前年份
		for (int start = cal.get(Calendar.YEAR), end = Calendar.getInstance()
				.get(Calendar.YEAR); start <= end; start++) {
			// 非当前年
			if (start != end) {
				// 当年日期累加
				this.days += cal.getMaximum(Calendar.DAY_OF_YEAR);
				cal.set(Calendar.YEAR, start++);
			}
			// 当前年
			else {
				this.days += cal.get(Calendar.DAY_OF_YEAR);
				int todayDayOfYear = Calendar.getInstance().get(
						Calendar.DAY_OF_YEAR);
				this.days = todayDayOfYear - this.days;
			}
		}
	}

	/**
	 * 获得用户感兴趣话题
	 * 
	 * @param majorList
	 *            - 用户所有感兴趣话题列表
	 */
	private void getInterest(List<Major> majorList) {
		// 用户感兴趣列表大于2
		// 限制显示
		if (majorList.size() > 2) {
			this.interest = this.interest + majorList.get(0).getMajorName();
			this.interest = this.interest + ","
					+ majorList.get(1).getMajorName();
		}
		// 用户感兴趣列表小于2
		else {
			if (majorList.size() != 0) {
				this.interest = majorList.get(0).getMajorName();
			}
			else {
				this.interest = "无";
			}
		}

	}

	public int getArticleCount() {
		return articleCount;
	}

	public int getDays() {
		return days;
	}

	public String getInterest() {
		return interest;
	}

	public User getUser() {
		return user;
	}

	public School getSchool() {
		return school;
	}

	public Major getMajor() {
		return major;
	}

}
