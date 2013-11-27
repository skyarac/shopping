package com.shopping.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.shopping.dao.GoodsDao;
import com.shopping.entity.Category;
import com.shopping.entity.Goods;
import com.shopping.util.DataBaseConnection;

public class GoodsDaoImpl implements GoodsDao {

	public void save(Goods goods) {
		Connection conn=null;
		PreparedStatement pstmt=null;
		DataBaseConnection dbc=new DataBaseConnection();
		String sql="INSERT INTO goods(gid,gname,gprice,gpic,gremark,gxremark,giscommend,gisopen,cid)VALUES(null,?,?,?,?,?,?,?,?)";
        conn=dbc.getConnection();
        try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, goods.getGname());
			pstmt.setDouble(2, goods.getGprice());
			pstmt.setString(3, goods.getGpic());
			pstmt.setString(4, goods.getGremark());
			pstmt.setString(5, goods.getGxremark());
			pstmt.setBoolean(6,goods.isGiscommend());
			pstmt.setBoolean(7,goods.isGisopen());
			pstmt.setInt(8, goods.getCategory().getCid());
			pstmt.executeUpdate();
		} catch (Exception e) {
			
			e.printStackTrace();
		}finally{
			try {
				pstmt.close();
			} catch (Exception e) {
				
				e.printStackTrace();
			}
			dbc.close();
		}
        
	}
/*
 * 按照商品编号gid删除商品信息
 * */
	public void deleteByGid(int gid) {
		Connection conn=null;
		PreparedStatement pstmt=null;
		String sql="DELETE FROM goods WHERE gid=?";
		DataBaseConnection dbc=new DataBaseConnection();
		conn=dbc.getConnection();
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1,gid);
			pstmt.executeUpdate();
		} catch (Exception e) {
			
			e.printStackTrace();
		}finally{
			try {
				pstmt.close();
			} catch (Exception e) {
				
				e.printStackTrace();
			}
			dbc.close();
		}
		
		
	}
	/*
	 * 更改商品信息
	 * */
	
	public void goodsModify(Goods goods) {
		Connection conn=null;
		PreparedStatement pstmt=null;
		DataBaseConnection dbc=new DataBaseConnection();
		String sql="UPDATE goods SET cid=?,gname=?,gprice=?,gpic=?,gremark=?,gxremark=?,giscommend=?,gisopen=? WHERE gid=?";
        conn=dbc.getConnection();
       
        try {
        	pstmt=conn.prepareStatement(sql);
        	pstmt.setInt(1, goods.getCategory().getCid());
			pstmt.setString(2, goods.getGname());
			pstmt.setDouble(3, goods.getGprice());
			pstmt.setString(4, goods.getGpic());
			pstmt.setString(5, goods.getGremark());
			pstmt.setString(6, goods.getGxremark());
			pstmt.setBoolean(7,goods.isGiscommend());
			pstmt.setBoolean(8,goods.isGisopen());
			pstmt.setInt(9, goods.getGid());
			pstmt.executeUpdate();
		} catch (Exception e) {
			
			e.printStackTrace();
		}finally{
			try {
				pstmt.close();
				dbc.close();
			} catch (Exception e) {
				
				e.printStackTrace();
			}
			
		}
        
		
	}
	/*
	 * 根据商品类别编号查询推荐，有效，热点商品
	 * */
	public List<Goods> queryGiscommendGoods(int cid) {
		List<Goods> goods=new ArrayList<Goods>();
		Goods temp=null;
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		DataBaseConnection dbc=new DataBaseConnection();
		conn=dbc.getConnection();
		String sql="SELECT * FROM goods g INNER JOIN category c ON g.cid=c.cid WHERE giscommend=1 AND gisopen=1 AND g.cid=? ORDER BY gdate DESC ";
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1,cid);
			rs=pstmt.executeQuery();
			while(rs.next()){
				temp=new Goods();
				Category category=new Category();
				category.setCid(rs.getInt("cid"));
				category.setCtype(rs.getString("ctype"));
				category.setChot(rs.getBoolean("chot"));
				temp.setCategory(category);
				temp.setGdate(rs.getDate("gdate"));
				temp.setGid(rs.getInt("gid"));
				temp.setGiscommend(rs.getBoolean("giscommend"));
				temp.setGisopen(rs.getBoolean("gisopen"));
				temp.setGname(rs.getString("gname"));
				temp.setGpic(rs.getString("gpic"));
				temp.setGprice(rs.getDouble("gprice"));
				temp.setGremark(rs.getString("gremark"));
				temp.setGxremark(rs.getString("gxremark"));
				goods.add(temp);
			}
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}finally{
			try {
				rs.close();
				pstmt.close();
			} catch (Exception e) {
				
				e.printStackTrace();
			}
			
			dbc.close();
		}
		
		return goods;
	}
	/*
	 * 根据商品类别编号查询商品信息
	 * */
	public List<Goods> queryGoodsByCid(int cid) {
		List<Goods> goods=new ArrayList<Goods>();
		Goods temp=null;
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		DataBaseConnection dbc=new DataBaseConnection();
		String sql="SELECT * FROM goods WHERE cid=?";
		conn=dbc.getConnection();
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, cid);
			rs=pstmt.executeQuery();
			Category category=new Category();
			category.setCid(cid);
			while(rs.next()){
				temp=new Goods();
				temp.setCategory(category);
				temp.setGdate(rs.getDate("gdate"));
				temp.setGid(rs.getInt("gid"));
				temp.setGiscommend(rs.getBoolean("giscommend"));
				temp.setGisopen(rs.getBoolean("gisopen"));
				temp.setGname(rs.getString("gname"));
				temp.setGpic(rs.getString("gpic"));
				temp.setGprice(rs.getDouble("gprice"));
				temp.setGremark(rs.getString("gremark"));
				temp.setGxremark(rs.getString("gxremark"));
				goods.add(temp);
			}
		} catch (Exception e) {
			
			e.printStackTrace();
		}finally{
			try {
				rs.close();
				pstmt.close();
			} catch (Exception e) {
				
				e.printStackTrace();
			}
			
			dbc.close();
		}
		
		return goods;
	}
	public void deleteByCid(int cid) {
		Connection conn=null;
		PreparedStatement pstmt=null;
		String sql="DELETE FROM goods WHERE cid=?";
		DataBaseConnection dbc=new DataBaseConnection();
		conn=dbc.getConnection();
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1,cid);
			pstmt.executeUpdate();
		} catch (Exception e) {
			
			e.printStackTrace();
		}finally{
			try {
				pstmt.close();
			} catch (Exception e) {
				
				e.printStackTrace();
			}
			dbc.close();
		}
		
		
		
	}

}
