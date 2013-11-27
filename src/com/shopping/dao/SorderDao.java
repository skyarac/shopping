package com.shopping.dao;

import java.sql.Connection;
import java.sql.SQLException;

import com.shopping.entity.Sorder;


public interface SorderDao {
	/*
	 * 保存订单子项(明细)  //传递订单项的订单号fid
	 * */
	public void saveSorder(Sorder sorder,int fid,Connection connection) throws SQLException;

}
