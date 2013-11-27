package com.shopping.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseConnection {
	/*
	 *         MySql���ݿ⹤����
	 *         ��Ҫ�������������ݿ⣬�ر����ݿ�
	 * */
	private final String DBDRIVER="com.mysql.jdbc.Driver";
	private final String DBURL="jdbc:mysql://localhost:3306/myshopping";
	private final String DBUSER="root";
	private final String DBPASSWORD="wangge";
	private Connection conn=null;
	//���췽������������
	public DataBaseConnection(){
		try {
			Class.forName(DBDRIVER);
			this.conn=DriverManager.getConnection(DBURL,DBUSER,DBPASSWORD);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("��������ʧ��");
		}
	}
	
	//ȡ�����ݿ�����
	public Connection getConnection(){
		return conn;
	}
	//�ر����ݿ�����
	public void close(){
		try {
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("���ݿ����ӹر�ʧ��");
		}
	}
	

}
