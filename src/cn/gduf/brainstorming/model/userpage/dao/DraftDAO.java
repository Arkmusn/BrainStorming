package cn.gduf.brainstorming.model.userpage.dao;
/**
 * 草稿接口类
 */
import java.util.List;

import cn.gduf.brainstorming.model.vo.Answer;
import cn.gduf.brainstorming.model.vo.Article;
import cn.gduf.brainstorming.model.vo.AtAsTp3;
import cn.gduf.brainstorming.model.vo.AtTp2;

public interface DraftDAO {

	/**
	 * 根据帖子实体创建草稿
	 * 
	 * @param article
	 *            - Article实体
	 * @return 创建状态
	 * @throws Exception
	 */
	public boolean createDraft(Article article) throws Exception;

	/**
	 * 根据回答实体创建草稿
	 * 
	 * @param answer
	 *            - Answer实体
	 * @return 创建状态
	 * @throws Exception
	 */
	public boolean createDraft(Answer answer) throws Exception;

	/**
	 * 根据用户ID显示草稿帖子
	 * 
	 * @param userID
	 *            - 用户ID
	 * @return 帖子板块2类
	 * @throws Exception
	 */
	public List<AtTp2> showArticleDraft(String userID) throws Exception;

	/**
	 * 根据用户ID显示草稿回答
	 * 
	 * @param userID
	 *            - 用户ID
	 * @return 帖子回答板块3类
	 * @throws Exception
	 */
	public List<AtAsTp3> showAnswerDraft(String userID) throws Exception;
}
