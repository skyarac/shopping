package com.shopping.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.shopping.dao.CategoryDao;
import com.shopping.dao.GoodsDao;
import com.shopping.entity.Account;
import com.shopping.entity.Category;
import com.shopping.util.DataBaseConnection;

public class CategoryDaoImpl implements CategoryDao {
/*
 * 添加商品信息
 * */
	public void save(Category category) {
		Connection conn=null;
		PreparedStatement pstmt=null;
		DataBaseConnection dbc=new DataBaseConnection();
		String sql="INSERT INTO category(cid,ctype,chot,aid) VALUES(null,?,?,?)";
		conn=dbc.getConnection();
		try {
			pstmt=conn.prepareStatement(sql);
	//		pstmt.setInt(1, category.getCid());
			pstmt.setString(1, category.getCtype());
		//	pstmt.setInt(2, category.getChot());
			pstmt.setBoolean(2,  category.getChot());
			pstmt.setString(3, category.getAccount().getAid());
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
 * 按商品类别编号删除商品类别
 * */
	public void delete(int cid) {
		Connection conn=null;
		PreparedStatement pstmt=null;
		DataBaseConnection dbc=new DataBaseConnection();
		String sql="DELETE FROM category WHERE cid=?";
		conn=dbc.getConnection();
		try {
			conn.setAutoCommit(false);
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, cid);
			pstmt.executeUpdate();
			GoodsDao goodsDao=new GoodsDaoImpl();
			goodsDao.deleteByCid(cid);
			conn.commit();
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
	 * 返回所有类别信息
	 * */
	public List<Category> getCategorys() {
		List<Category> categorys=new ArrayList<Category>();
		Category category=null;
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		DataBaseConnection dbc=new DataBaseConnection();
		conn=dbc.getConnection();
		String sql="SELECT * FROM category";
		try {
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()){
				category=new Category();
				Account account=new Account();
				account.setAid(rs.getString("aid"));
				category.setAccount(account);
				category.setChot(rs.getBoolean("chot"));
				category.setCid(rs.getInt("cid"));
				category.setCtype(rs.getString("ctype"));
				categorys.add(category);
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
		
		return categorys;
	
		
	}
	/*
	 * 根据商品类别名或字符查找并返回类别信息
	 * */
	public List<Category> getCategorys(String ctype) {
		List<Category> categorys=new ArrayList<Category>();
		Category category=null;
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		DataBaseConnection dbc=new DataBaseConnection();
		conn=dbc.getConnection();
		String sql="SELECT * FROM category WHERE ctype LIKE '%"+ctype+"%'";
		try {
			pstmt=conn.prepareStatement(sql);
		//	pstmt.setString(1, "'%"+ctype+"%'");
			rs=pstmt.executeQuery();
			while(rs.next()){
				category=new Category();
				Account account=new Account();
				account.setAid(rs.getString("aid"));
				category.setAccount(account);
				category.setChot(rs.getBoolean("chot"));
				category.setCid(rs.getInt("cid"));
				category.setCtype(rs.getString("ctype"));
				categorys.add(category);
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
		
		return categorys;
	
	}
	/*
	 * 查询热点类别
	 * */
	public List<Category> getCategorys(boolean isChot) {
		List<Category> categorys=new ArrayList<Category>();
		Category category=null;
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		DataBaseConnection dbc=new DataBaseConnection();
		conn=dbc.getConnection();
		String sql="SELECT * FROM category WHERE chot=?";
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setBoolean(1, isChot);
			rs=pstmt.executeQuery();
			while(rs.next()){
				category=new Category();
				Account account=new Account();
				account.setAid(rs.getString("aid"));
				category.setAccount(account);
				category.setChot(rs.getBoolean("chot"));
				category.setCid(rs.getInt("cid"));
				category.setCtype(rs.getString("ctype"));
				categorys.add(category);
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
		
		return categorys;
	}
	/*
	 * 根据类别编号cid和新的类别信息category修改类别信息
	 * */
	public void categoryModify(Category category){
		Connection conn=null;
		PreparedStatement pstmt=null;
		DataBaseConnection dbc=new DataBaseConnection();
		String sql="UPDATE category SET ctype=?,chot=?,aid=? WHERE cid=? ";
		conn=dbc.getConnection();
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1,category.getCtype());
			pstmt.setBoolean(2, category.getChot());
			pstmt.setString(3, category.getAccount().getAid());
			pstmt.setInt(4, category.getCid());
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
