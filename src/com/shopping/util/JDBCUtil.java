package com.shopping.util;


import java.sql.Connection;
import java.sql.DriverManager;


public class JDBCUtil {
	
	private static  final String DBDRIVER="com.mysql.jdbc.Driver";
	private static final String DBURL="jdbc:mysql://localhost:3306/myshopping";
	private static final String DBUSER="root";
	private static final String DBPASSWORD="wangge";
	
	private static Connection conn = null;
	static {
		try {
			Class.forName(DBDRIVER);
			conn=DriverManager.getConnection(DBURL,DBUSER,DBPASSWORD);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static Connection getConnection() {
		return conn;
	}
	
	public static void closeConnection() {
		try {
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
