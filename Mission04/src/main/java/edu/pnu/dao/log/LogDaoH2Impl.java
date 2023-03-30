package edu.pnu.dao.log;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import edu.pnu.dao.DaoH2;

public class LogDaoH2Impl extends DaoH2 implements LogDao  {
	
	// Connection con;
	
	public LogDaoH2Impl() {
		super();
	}
	
	@Override
	public void addLog(String method, Object query, Object bool) {
		PreparedStatement st = null;
		try {
			st = getConnection().prepareStatement("insert into log (method, query, bool) values (?, ?, ?)");
			st.setString(1, method);
			st.setObject(2, query);
			st.setObject(3, bool);
			
			st.executeUpdate();
		}
		catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
