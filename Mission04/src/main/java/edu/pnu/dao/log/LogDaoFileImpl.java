package edu.pnu.dao.log;

import java.io.File;
import java.io.FileWriter;


public class LogDaoFileImpl implements LogDao {
	public void addLog(String method, Object query, Object bool) {
		try {
			File file = new File("C:\\Users\\SW\\Desktop\\log.txt");
			FileWriter fw = new FileWriter(file, true);
			String s = "\n" + method + "," + query + "," + bool;
			fw.append(s);
			fw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
