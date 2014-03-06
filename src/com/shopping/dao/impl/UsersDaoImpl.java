package com.shopping.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.shopping.dao.UsersDao;
import com.shopping.entity.User;
import com.shopping.util.DataBaseConnection;

public class UsersDaoImpl implements UsersDao {
	/*
	 * 添加用户
	 */
	public User save(User users) {  //由void改为Users
		User user = users;
		DataBaseConnection dbc = new DataBaseConnection();
		String sql = "INSERT INTO users(uid,ulogin,uname,upass,usex,uphone,upost,uemail,uaddress)"
				+ " VALUES(null,?,?,?,?,?,?,?,?)";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs=null;
		int uid=0;
		conn = dbc.getConnection();
		try {
			pstmt = conn.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);
			// pstmt.setInt(1, user.getUid());
			pstmt.setString(1, user.getUlogin());
			pstmt.setString(2, user.getUname());
			pstmt.setString(3, user.getUpass());
			pstmt.setString(4, user.getUsex());
			pstmt.setString(5, user.getUphone());
			pstmt.setString(6, user.getUpost());
			pstmt.setString(7, user.getUemail());
			pstmt.setString(8, user.getUaddress());
			pstmt.executeUpdate();
		    rs=pstmt.getGeneratedKeys();
		    if(rs.next()){
		    	uid=rs.getInt(1);
		    }
		    user.setUid(uid);
		    
		} catch (Exception e) {

			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
			} catch (Exception e) {

				e.printStackTrace();
			}
			dbc.close();
		}
		return user;

	}

	/*
	 * 
	 * 根据姓名判断用户是否存在
	 */
	public boolean checkUserExistsWithName(String username) {
		String userName = username;
		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		String sql = "SELECT * FROM users WHERE ulogin=?";
		DataBaseConnection dbc = new DataBaseConnection();
		conn = dbc.getConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userName);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				return true;
			}
		} catch (Exception e) {

			e.printStackTrace();
		} finally {

			try {
				rs.close();
				pstmt.close();
			} catch (SQLException e) {

				e.printStackTrace();
			}
			dbc.close();
		}

		return false;
	}

	/*
	 * 根据传入的用户查询若存在即返回用户信息
	 */
	public User queryUsers(User users) {
		User temp = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		DataBaseConnection dbc = new DataBaseConnection();
		conn = dbc.getConnection();
		String sql = "SELECT * FROM users WHERE ulogin=? AND upass=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, users.getUlogin());
			pstmt.setString(2, users.getUpass());
			rs = pstmt.executeQuery();
			while (rs.next()) {
				temp = new User();
				temp.setUaddress(rs.getString("uaddress"));
				temp.setUemail(rs.getString("uemail"));
				temp.setUid(rs.getInt("uid"));
				temp.setUlogin(rs.getString("ulogin"));
				temp.setUname(rs.getString("uname"));
				temp.setUpass(rs.getString("upass"));
				temp.setUphone(rs.getString("uphone"));
				temp.setUpost(rs.getString("upost"));
				temp.setUsex(rs.getString("usex"));
			}
		} catch (Exception e) {

			e.printStackTrace();
		} finally {

			try {
				rs.close();
				pstmt.close();
				dbc.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		return temp;
	}

	/*
	 * 根据uid删除用户
	 */
	public void delete(int uid) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "DELETE FROM users WHERE uid=?";
		DataBaseConnection dbc = new DataBaseConnection();
		conn = dbc.getConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, uid);
			pstmt.executeUpdate();
		} catch (Exception e) {

			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
			} catch (Exception e) {

				e.printStackTrace();
			}
			dbc.close();
		}
	}

	/*
	 * 返回所有用户
	 */
	public List<User> getUsers() {
		List<User> users = new ArrayList<User>();
		User user = null;
		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		String sql = "SELECT * FROM users";
		DataBaseConnection dbc=new DataBaseConnection();
		try {
			conn=dbc.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				user = new User();
				user.setUaddress(rs.getString("uaddress"));
				user.setUemail(rs.getString("uemail"));
				user.setUid(rs.getInt("uid"));
				user.setUlogin(rs.getString("ulogin"));
				user.setUname(rs.getString("uname"));
				user.setUpass(rs.getString("upass"));
				user.setUphone(rs.getString("uphone"));
				user.setUpost(rs.getString("upost"));
				user.setUsex(rs.getString("usex"));
				users.add(user);
			}
		} catch (Exception e1) {
			e1.printStackTrace();
		}finally{
			try {
				rs.close();
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			dbc.close();
		}
		return users;
	}
/*
 * 更改用户信息，前台用户编号uid
 * */
	public void usersModify(User users) {
		Connection conn=null;
		PreparedStatement pstmt=null;
		DataBaseConnection dbc=new DataBaseConnection();
		String sql=
				"UPDATE users SET ulogin=?,uname=?,upass=?,usex=?,uphone=?,upost=?,uemail=?,uaddress=? WHERE uid=?";
				 
		conn=dbc.getConnection();
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, users.getUlogin());
			pstmt.setString(2,users.getUname());
			pstmt.setString(3, users.getUpass());
			pstmt.setString(4, users.getUsex());
			pstmt.setString(5,users.getUphone());
			pstmt.setString(6, users.getUpost());
			pstmt.setString(7,users.getUemail());
			pstmt.setString(8,users.getUaddress());
			pstmt.setInt(9, users.getUid());
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
