package cn.gduf.brainstorming.model.userpage.proxy;
/**
 * ≤›∏Â¥˙¿Ì¿‡
 */
import java.util.List;

import cn.gduf.brainstorming.model.dbc.DatabaseConnection;
import cn.gduf.brainstorming.model.userpage.dao.DraftDAO;
import cn.gduf.brainstorming.model.userpage.dao.impl.DraftImpl;
import cn.gduf.brainstorming.model.vo.Answer;
import cn.gduf.brainstorming.model.vo.Article;
import cn.gduf.brainstorming.model.vo.AtAsTp3;
import cn.gduf.brainstorming.model.vo.AtTp2;

public class DraftProxy implements DraftDAO {
	private DatabaseConnection dbc = null;
	private DraftDAO dao = null;

	public DraftProxy() {
		this.dbc = new DatabaseConnection();
		this.dao = new DraftImpl(this.dbc.getConnection());
	}

	@Override
	public boolean createDraft(Article article) throws Exception {
		boolean flag = false;
		try {
			flag = this.dao.createDraft(article);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			this.dbc.close();
		}
		return flag;
	}

	@Override
	public boolean createDraft(Answer answer) throws Exception {
		boolean flag = false;
		try {
			flag = this.dao.createDraft(answer);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			this.dbc.close();
		}
		return flag;
	}

	@Override
	public List<AtTp2> showArticleDraft(String userID) throws Exception {
		List<AtTp2> atTp2 = null;
		try {
			atTp2 = this.dao.showArticleDraft(userID);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			this.dbc.close();
		}
		return atTp2;
	}

	@Override
	public List<AtAsTp3> showAnswerDraft(String userID) throws Exception {
		List<AtAsTp3> atAsTp3 = null;
		try {
			atAsTp3 = this.dao.showAnswerDraft(userID);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			this.dbc.close();
		}
		return atAsTp3;
	}

}
