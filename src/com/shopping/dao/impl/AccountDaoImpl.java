package com.shopping.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.shopping.dao.AccountDao;
import com.shopping.entity.Account;
import com.shopping.util.JDBCUtil;

public class AccountDaoImpl implements AccountDao {

	public void save(Account account) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO account(aid,alogin,aname,apass) VALUES(?,?,?,?)";
		conn = JDBCUtil.getConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, account.getAid());
			pstmt.setString(2, account.getAlogin());
			pstmt.setString(3, account.getAname());
			pstmt.setString(4, account.getApass());
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				JDBCUtil.closeConnection();
			} catch (Exception e) {
				e.printStackTrace();
			}

		}

	}

	public void delete(String aid) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "DELETE FROM account WHERE aid=?";
		conn = JDBCUtil.getConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, aid);
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			JDBCUtil.closeConnection();
		}
	}

	public List<Account> listAll() {
		List<Account> accounts = new ArrayList<Account>();
		Account account = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM account";
		conn = JDBCUtil.getConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				account = new Account();
				account.setAid(rs.getString("aid"));
				account.setAlogin(rs.getString("alogin"));
				account.setAname(rs.getString("aname"));
				account.setApass(rs.getString("apass"));
				accounts.add(account);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				pstmt.close();
				JDBCUtil.closeConnection();
			} catch (Exception e) {

				e.printStackTrace();
			}

		}

		return accounts;
	}

	public void update(Account account) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "UPDATE account SET alogin=?,aname=?,apass=? WHERE aid=?";
		conn = JDBCUtil.getConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, account.getAlogin());
			pstmt.setString(2, account.getAname());
			pstmt.setString(3, account.getApass());
			pstmt.setString(4, account.getAid());
			pstmt.executeUpdate();
		} catch (Exception e) {

			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			JDBCUtil.closeConnection();
		}

	}

	public Account get(String name,String password) {
		Account temp = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		conn = JDBCUtil.getConnection();
		String sql = "SELECT * FROM account WHERE alogin=? AND apass=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2, password);
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
				if(null != rs)
					rs.close();
				if(null != pstmt)
					pstmt.close();
				JDBCUtil.closeConnection();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		return temp;
	}

	@Override
	public Account get(int aid) {
		Account temp = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		conn = JDBCUtil.getConnection();
		String sql = "SELECT * FROM account WHERE aid=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, aid);
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
				JDBCUtil.closeConnection();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		return temp;
	}
}
