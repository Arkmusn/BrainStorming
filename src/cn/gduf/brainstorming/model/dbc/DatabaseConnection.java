package cn.gduf.brainstorming.model.dbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author ��˼ �������ݿ����رղ���
 */
public class DatabaseConnection {

	private Connection conn = null;

	public DatabaseConnection() {
		try {
			// ������������
			Class.forName(Constants.DRIVER).newInstance();
			// �������ݿ�
			conn = DriverManager.getConnection(Constants.URL,
					Constants.USERNAME, Constants.PASSWORD);
		} catch (ClassNotFoundException e) {
			System.out.println("δ�ҵ�������");
		} catch (SQLException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
	}

	public Connection getConnection() {
		return conn;

	}

	/**
	 * �ر����ݿ������
	 * 
	 * @throws Exception
	 */
	public void close() throws Exception {
		if (this.conn != null) {
			try {
				this.conn.close();
			} catch (Exception e) {
				throw e;
			}
		}
	}
}
