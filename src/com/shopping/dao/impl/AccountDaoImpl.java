package com.shopping.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.shopping.dao.AccountDao;
import com.shopping.entity.Account;
import com.shopping.entity.User;
import com.shopping.util.DataBaseConnection;

public class AccountDaoImpl implements AccountDao {

	public void save(Account account) {
		Connection conn=null;
		PreparedStatement pstmt=null;
		DataBaseConnection dbc=new DataBaseConnection();
		String sql="INSERT INTO account(aid,alogin,aname,apass) VALUES(?,?,?,?)";
		conn=dbc.getConnection();
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1,account.getAid());
			pstmt.setString(2, account.getAlogin());
			pstmt.setString(3, account.getAname());
			pstmt.setString(4, account.getApass());
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
 * 按照客服aid删除客服
 * */
	public void delete(String aid) {
		Connection conn=null;
		PreparedStatement pstmt=null;
		DataBaseConnection dbc=new DataBaseConnection();
		String sql="DELETE FROM account WHERE aid=?";
		conn=dbc.getConnection();
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, aid);
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
	 * 返回所有客服信息
	 * */
	public List<Account> getAccounts() {
		List<Account> accounts=new ArrayList<Account>();
		Account account=null;
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		DataBaseConnection dbc=new DataBaseConnection();
		String sql="SELECT * FROM account";
		conn=dbc.getConnection();
		try {
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()){
				account=new Account();
				account.setAid(rs.getString("aid"));
				account.setAlogin(rs.getString("alogin"));
				account.setAname(rs.getString("aname"));
				account.setApass(rs.getString("apass"));
				accounts.add(account);
			}
		
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				rs.close();
				pstmt.close();
				dbc.close();
			} catch (Exception e) {
				
				e.printStackTrace();
			}
			
		}
		
		return accounts;
	}
	/*
	 * 根据传入的客服信息修改客服信息
	 * */
	public void accountModify(Account account) {
		Connection conn=null;
		PreparedStatement pstmt=null;
		DataBaseConnection dbc=new DataBaseConnection();
		String sql="UPDATE account SET alogin=?,aname=?,apass=? WHERE aid=?";
		conn=dbc.getConnection();
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, account.getAlogin());
			pstmt.setString(2, account.getAname());
			pstmt.setString(3, account.getApass());
			pstmt.setString(4, account.getAid());
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
	public Account queryAccount(Account account) {
		Account temp = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		DataBaseConnection dbc = new DataBaseConnection();
		conn = dbc.getConnection();
		String sql = "SELECT * FROM account WHERE alogin=? AND apass=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, account.getAlogin());
			pstmt.setString(2, account.getApass());
			rs = pstmt.executeQuery();
			while (rs.next()) {
				temp = new Account();
				temp.setAid(rs.getString("aid"));
				temp.setAlogin(rs.getString("alogin"));
				temp.setAname(rs.getString("aname"));
				temp.setApass(rs.getString("apass"));
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
}
