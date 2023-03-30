package edu.pnu.dao.log;

public interface LogDao {

	void addLog(String method, Object query, Object bool);

}