package com.shopping.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.shopping.dao.UserDao;
import com.shopping.entity.User;
import com.shopping.util.JDBCUtil;

public class UserDaoImpl implements UserDao {
	private JDBCUtil jdbcUtil = null;
	public User save(User users) {
		User user = users;

		String sql = "INSERT INTO users(uid,ulogin,uname,upass,usex,uphone,upost,uemail,uaddress)"
				+ " VALUES(null,?,?,?,?,?,?,?,?)";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int uid = 0;
		jdbcUtil = new JDBCUtil();
		conn = jdbcUtil.getConnection();
		try {
			pstmt = conn.prepareStatement(sql,
					PreparedStatement.RETURN_GENERATED_KEYS);
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
			rs = pstmt.getGeneratedKeys();
			if (rs.next()) {
				uid = rs.getInt(1);
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
			jdbcUtil.closeConnection();
		}
		return user;

	}

	public User get(String username, String password) {
		User temp = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		jdbcUtil = new JDBCUtil();
		conn = jdbcUtil.getConnection();
		String sql = "SELECT * FROM users WHERE ulogin=? AND upass=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, username);
			pstmt.setString(2, password);
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
				jdbcUtil.closeConnection();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		return temp;
	}

	public void delete(int uid) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "DELETE FROM users WHERE uid=?";
		jdbcUtil = new JDBCUtil();
		conn = jdbcUtil.getConnection();
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
			jdbcUtil.closeConnection();
		}
	}

	public List<User> listAll() {
		List<User> users = new ArrayList<User>();
		User user = null;
		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		String sql = "SELECT * FROM users";
		jdbcUtil = new JDBCUtil();
		try {
			conn = jdbcUtil.getConnection();
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
		} finally {
			try {
				rs.close();
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			jdbcUtil.closeConnection();
		}
		return users;
	}

	public void update(User users) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "UPDATE users SET ulogin=?,uname=?,upass=?,usex=?,uphone=?,upost=?,uemail=?,uaddress=? WHERE uid=?";
		jdbcUtil = new JDBCUtil();
		conn = jdbcUtil.getConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, users.getUlogin());
			pstmt.setString(2, users.getUname());
			pstmt.setString(3, users.getUpass());
			pstmt.setString(4, users.getUsex());
			pstmt.setString(5, users.getUphone());
			pstmt.setString(6, users.getUpost());
			pstmt.setString(7, users.getUemail());
			pstmt.setString(8, users.getUaddress());
			pstmt.setInt(9, users.getUid());
			pstmt.executeUpdate();

		} catch (Exception e) {

			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
			} catch (Exception e) {

				e.printStackTrace();
			}
			jdbcUtil.closeConnection();
		}

	}

	@Override
	public User get(String username) {
		User temp = null;
		String userName = username;
		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		String sql = "SELECT * FROM users WHERE ulogin=?";
		jdbcUtil = new JDBCUtil();
		conn = jdbcUtil.getConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userName);
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
			} catch (SQLException e) {

				e.printStackTrace();
			}
			jdbcUtil.closeConnection();
		}

		return temp;
	}

	@Override
	public User get(int id) {
		User temp = null;
		int uid = id;
		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		String sql = "SELECT * FROM users WHERE uid=?";
		jdbcUtil = new JDBCUtil();
		conn = jdbcUtil.getConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, uid);
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
			} catch (SQLException e) {

				e.printStackTrace();
			}
			jdbcUtil.closeConnection();
		}

		return temp;
	}

}
