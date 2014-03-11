package com.shopping.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.shopping.dao.GoodsDao;
import com.shopping.entity.Category;
import com.shopping.entity.Goods;
import com.shopping.util.JDBCUtil;

public class GoodsDaoImpl implements GoodsDao {
	private JDBCUtil jdbcUtil = null;
	
	public void save(Goods goods) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO goods(gid,gname,gprice,gpic,gremark,gxremark,giscommend,gisopen,cid)VALUES(null,?,?,?,?,?,?,?,?)";
		jdbcUtil = new JDBCUtil();
		conn = jdbcUtil.getConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, goods.getGname());
			pstmt.setDouble(2, goods.getGprice());
			pstmt.setString(3, goods.getGpic());
			pstmt.setString(4, goods.getGremark());
			pstmt.setString(5, goods.getGxremark());
			pstmt.setBoolean(6, goods.isGiscommend());
			pstmt.setBoolean(7, goods.isGisopen());
			pstmt.setInt(8, goods.getCategory().getCid());
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

	public void deleteByGid(int gid) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "DELETE FROM goods WHERE gid=?";
		jdbcUtil = new JDBCUtil();
		conn = jdbcUtil.getConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, gid);
			pstmt.executeUpdate();
		} catch (Exception e) {

			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (Exception e) {

				e.printStackTrace();
			}
		}

	}

	public void update(Goods goods) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "UPDATE goods SET cid=?,gname=?,gprice=?,gpic=?,gremark=?,gxremark=?,giscommend=?,gisopen=? WHERE gid=?";
		jdbcUtil = new JDBCUtil();
		conn = jdbcUtil.getConnection();

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, goods.getCategory().getCid());
			pstmt.setString(2, goods.getGname());
			pstmt.setDouble(3, goods.getGprice());
			pstmt.setString(4, goods.getGpic());
			pstmt.setString(5, goods.getGremark());
			pstmt.setString(6, goods.getGxremark());
			pstmt.setBoolean(7, goods.isGiscommend());
			pstmt.setBoolean(8, goods.isGisopen());
			pstmt.setInt(9, goods.getGid());
			pstmt.executeUpdate();
		} catch (Exception e) {

			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();;
			} catch (Exception e) {

				e.printStackTrace();
			}

		}

	}

	public List<Goods> getGiscommendGoods(int cid) {
		List<Goods> goods = new ArrayList<Goods>();
		Goods temp = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		jdbcUtil = new JDBCUtil();
		conn = jdbcUtil.getConnection();
		String sql = "SELECT * FROM goods g INNER JOIN category c ON g.cid=c.cid WHERE giscommend=1 AND gisopen=1 AND g.cid=? ORDER BY gdate DESC ";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, cid);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				temp = new Goods();
				Category category = new Category();
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
		} finally {
			try {
				rs.close();
				pstmt.close();
			} catch (Exception e) {

				e.printStackTrace();
			}

			jdbcUtil.closeConnection();
		}

		return goods;
	}

	public List<Goods> getGoodsByCid(int cid) {
		List<Goods> goods = new ArrayList<Goods>();
		Goods temp = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM goods WHERE cid=?";
		jdbcUtil = new JDBCUtil();
		conn = jdbcUtil.getConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, cid);
			rs = pstmt.executeQuery();
			Category category = new Category();
			category.setCid(cid);
			while (rs.next()) {
				temp = new Goods();
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
		} finally {
			try {
				rs.close();
				pstmt.close();
			} catch (Exception e) {

				e.printStackTrace();
			}

			jdbcUtil.closeConnection();
		}

		return goods;
	}

	public void deleteByCid(int cid) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "DELETE FROM goods WHERE cid=?";
		jdbcUtil = new JDBCUtil();
		conn = jdbcUtil.getConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, cid);
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
	public List<Goods> listAll() {
		List<Goods> goods = new ArrayList<Goods>();
		Goods temp = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		jdbcUtil = new JDBCUtil();
		conn = jdbcUtil.getConnection();
		String sql = "SELECT * FROM goods ";
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				temp = new Goods();
				Category category = new Category();
				category.setCid(rs.getInt("cid"));
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
		} finally {
			try {
				rs.close();
				pstmt.close();
			} catch (Exception e) {

				e.printStackTrace();
			}

			jdbcUtil.closeConnection();
		}

		return goods;
	}

	@Override
	public Goods getGoodsByGid(int gid) {
		List<Goods> goods = new ArrayList<Goods>();
		Goods temp = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		jdbcUtil = new JDBCUtil();
		conn = jdbcUtil.getConnection();
		String sql = "SELECT * FROM goods where gid = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, gid);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				temp = new Goods();
				Category category = new Category();
				category.setCid(rs.getInt("cid"));
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
		} finally {
			try {
				rs.close();
				pstmt.close();
			} catch (Exception e) {

				e.printStackTrace();
			}

			jdbcUtil.closeConnection();
		}

		return goods.get(0);
	}

}
