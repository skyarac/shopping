package com.shopping.dao;

import java.sql.Connection;
import java.sql.SQLException;

import com.shopping.entity.Sorder;


public interface SorderDao {
	/*
	 * ���涩������(��ϸ)  //���ݶ�����Ķ�����fid
	 * */
	public void saveSorder(Sorder sorder,int fid,Connection connection) throws SQLException;

}
