package com.shopping.dao;

import java.sql.Connection;
import java.sql.SQLException;

import com.shopping.entity.Sorder;


public interface SorderDao {
	
	public void saveSorder(Sorder sorder,int fid,Connection connection) throws SQLException;

}
