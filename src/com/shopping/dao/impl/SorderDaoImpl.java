package com.shopping.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.shopping.dao.SorderDao;
import com.shopping.entity.Sorder;

public class SorderDaoImpl implements SorderDao {

	public void saveSorder(Sorder sorder,int fid, Connection connection) throws SQLException {
		Connection conn=connection;
		PreparedStatement pstmt=null;
		String sql="INSERT INTO sorder(sid,sname,sprice,snumber,fid,gid) VALUES(null,?,?,?,?,?)";
		pstmt=conn.prepareStatement(sql);
		pstmt.setString(1, sorder.getSname());
		pstmt.setDouble(2, sorder.getSprice());
		pstmt.setInt(3, sorder.getSnumber());
		pstmt.setInt(4,fid);
		pstmt.setInt(5, sorder.getGoods().getGid());
		pstmt.executeUpdate();

	}

}
