package com.shopping.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.shopping.dao.CategoryDao;
import com.shopping.dao.GoodsDao;
import com.shopping.entity.Account;
import com.shopping.entity.Category;
import com.shopping.util.JDBCUtil;

public class CategoryDaoImpl implements CategoryDao {

	public void save(Category category) {
		Connection conn=null;
		PreparedStatement pstmt=null;
		String sql="INSERT INTO category(cid,ctype,chot,aid) VALUES(null,?,?,?)";
		conn=JDBCUtil.getConnection();
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, category.getCtype());
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
			JDBCUtil.closeConnection();
		}
		

	}

	public void delete(int cid) {
		Connection conn=null;
		PreparedStatement pstmt=null;
		String sql="DELETE FROM category WHERE cid=?";
		conn=JDBCUtil.getConnection();
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
			JDBCUtil.closeConnection();
		}
		
		
	}
	
	public List<Category> listAll() {
		List<Category> categorys=new ArrayList<Category>();
		Category category=null;
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		conn=JDBCUtil.getConnection();
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
			JDBCUtil.closeConnection();
		}
		
		return categorys;
	
		
	}
	
	public List<Category> listByCtype(String ctype) {
		List<Category> categorys=new ArrayList<Category>();
		Category category=null;
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		conn=JDBCUtil.getConnection();
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
			JDBCUtil.closeConnection();
		}
		
		return categorys;
	
	}
	
	public List<Category> listByChot(boolean isChot) {
		List<Category> categorys=new ArrayList<Category>();
		Category category=null;
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		conn=JDBCUtil.getConnection();
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
			JDBCUtil.closeConnection();
		}
		
		return categorys;
	}
	
	public void update(Category category){
		Connection conn=null;
		PreparedStatement pstmt=null;
		String sql="UPDATE category SET ctype=?,chot=?,aid=? WHERE cid=? ";
		conn=JDBCUtil.getConnection();
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
			JDBCUtil.closeConnection();
		}
	}

	@Override
	public Category get(int cid) {
		Category category=null;
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		conn=JDBCUtil.getConnection();
		String sql="SELECT * FROM category where cid = ?";
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, cid);
			rs=pstmt.executeQuery();
			while(rs.next()){
				category=new Category();
				Account account=new Account();
				account.setAid(rs.getString("aid"));
				category.setAccount(account);
				category.setChot(rs.getBoolean("chot"));
				category.setCid(rs.getInt("cid"));
				category.setCtype(rs.getString("ctype"));
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
			JDBCUtil.closeConnection();
		}
		
		return category;
	}
}
