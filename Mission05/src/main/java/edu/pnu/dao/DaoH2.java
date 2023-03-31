package edu.pnu.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class DaoH2 {
	private Connection con = null;
	
	public DaoH2() {
		try {
			Class.forName("org.h2.driver");
			
			con = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/springboot", "sa", "");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public Connection getConnection() {
		return con;
	}
	
}
