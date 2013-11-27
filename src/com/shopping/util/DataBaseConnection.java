package com.shopping.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseConnection {
	/*
	 *         MySql数据库工具类
	 *         主要功能是连接数据库，关闭数据库
	 * */
	private final String DBDRIVER="com.mysql.jdbc.Driver";
	private final String DBURL="jdbc:mysql://localhost:3306/myshopping";
	private final String DBUSER="root";
	private final String DBPASSWORD="wangge";
	private Connection conn=null;
	//构造方法，加载驱动
	public DataBaseConnection(){
		try {
			Class.forName(DBDRIVER);
			this.conn=DriverManager.getConnection(DBURL,DBUSER,DBPASSWORD);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("加载驱动失败");
		}
	}
	
	//取得数据库连接
	public Connection getConnection(){
		return conn;
	}
	//关闭数据库连接
	public void close(){
		try {
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("数据库连接关闭失败");
		}
	}
	

}
