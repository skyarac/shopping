package com.shopping.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.shopping.dao.ForderDao;
import com.shopping.dao.SorderDao;
import com.shopping.entity.Account;
import com.shopping.entity.Forder;
import com.shopping.entity.Sorder;
import com.shopping.entity.Status;
import com.shopping.entity.User;
import com.shopping.util.JDBCUtil;

public class ForderDaoImpl implements ForderDao {
	private JDBCUtil jdbcUtil = null;
	private SorderDao sorderDao=new SorderDaoImpl();

	public Forder save(Forder forder) {
		int fid=0;
	    Connection conn=null;
	    PreparedStatement pstmt=null;
	    ResultSet rs=null;
	    jdbcUtil = new JDBCUtil();
	    conn=jdbcUtil.getConnection();
	    String sql="INSERT INTO forder(fid,fdate,ftotal,fname,fphone,fremark,femail,fpost,faddress,aid,uid,sid)VALUES(null,null,?,?,?,?,?,?,?,?,?,?)";
	    try {
	    	conn.setAutoCommit(false);
			pstmt=conn.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);
			 pstmt.setDouble(1, forder.getFtotal());
			 pstmt.setString(2, forder.getFname());
			 pstmt.setString(3,forder.getFphone());
			 pstmt.setString(4,forder.getFremark());
			 pstmt.setString(5,forder.getFemail());
			 pstmt.setString(6,forder.getFpost());
			 pstmt.setString(7,forder.getFaddress());
			 pstmt.setString(8, forder.getAccount().getAid());
			 pstmt.setInt(9,forder.getUsers().getUid());
			 pstmt.setInt(10,forder.getStatus().getSid());
			 pstmt.executeUpdate();
			 rs=pstmt.getGeneratedKeys();
			 if(rs.next()){
				 fid=rs.getInt(1);
			 }
			 for(Sorder sorder:forder.getSorders()){
				 sorderDao.saveSorder(sorder, fid, conn);
			 }
			 forder.setFid(fid);
			 conn.commit();
		} catch (Exception e) {
			
			e.printStackTrace();
		}finally{
			
			try {
				rs.close();
				pstmt.close();
			} catch (Exception e) {
				
				e.printStackTrace();
			}
			jdbcUtil.closeConnection();
		}
	   
	    
		return forder;
	}

	public void updateForderStatus(int fid, int sid) {
		Connection conn=null;
		PreparedStatement pstmt=null;
		String sql="UPDATE forder SET sid=? WHERE fid=?";
		jdbcUtil = new JDBCUtil();
		conn=jdbcUtil.getConnection();
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1,sid);
			pstmt.setInt(2,fid);
			pstmt.executeUpdate();
		} catch (Exception e) {
			
			e.printStackTrace();
		}finally{
			try {
				pstmt.close();
			} catch (Exception e) {
				
				e.printStackTrace();
			}
			jdbcUtil.closeConnection();
		}
		
		
	}



	public List<Forder> listAll() {
		List<Forder> forders=new ArrayList<Forder>();
		Forder forder=null;
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String sql="SELECT * FROM forder";
		jdbcUtil = new JDBCUtil();
		conn=jdbcUtil.getConnection();
		try {
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()){
				forder=new Forder();
				Account account=new Account();
				account.setAid(rs.getString("aid"));
				forder.setAccount(account);
				forder.setFaddress(rs.getString("faddress"));
				forder.setFdate(rs.getDate("fdate"));
				forder.setFemail(rs.getString("femail"));
				forder.setFid(rs.getInt("fid"));
				forder.setFname(rs.getString("fname"));
				forder.setFphone(rs.getString("fphone"));
				forder.setFpost(rs.getString("fpost"));
				forder.setFremark(rs.getString("fremark"));
				forder.setFtotal(rs.getDouble("ftotal"));
				Status status=new Status();
				status.setSid(rs.getInt("sid"));
				forder.setStatus(status);
				User users=new User();
				users.setUid(rs.getInt("uid"));
				forder.setUsers(users);
				forders.add(forder);
			}
		
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				rs.close();
				pstmt.close();
				jdbcUtil.closeConnection();
			} catch (Exception e) {
				
				e.printStackTrace();
			}
			
		}
		
		return forders;
	}

	@Override
	public List<Forder> listByStatusId(int id) {
		List<Forder> forders=new ArrayList<Forder>();
		Forder forder=null;
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String sql="SELECT * FROM forder where sid= ?";
		jdbcUtil = new JDBCUtil();
		conn=jdbcUtil.getConnection();
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			rs=pstmt.executeQuery();
			while(rs.next()){
				forder=new Forder();
				Account account=new Account();
				account.setAid(rs.getString("aid"));
				forder.setAccount(account);
				forder.setFaddress(rs.getString("faddress"));
				forder.setFdate(rs.getDate("fdate"));
				forder.setFemail(rs.getString("femail"));
				forder.setFid(rs.getInt("fid"));
				forder.setFname(rs.getString("fname"));
				forder.setFphone(rs.getString("fphone"));
				forder.setFpost(rs.getString("fpost"));
				forder.setFremark(rs.getString("fremark"));
				forder.setFtotal(rs.getDouble("ftotal"));
				Status status=new Status();
				status.setSid(rs.getInt("sid"));
				forder.setStatus(status);
				User users=new User();
				users.setUid(rs.getInt("uid"));
				forder.setUsers(users);
				forders.add(forder);
			}
		
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				rs.close();
				pstmt.close();
				jdbcUtil.closeConnection();
			} catch (Exception e) {
				
				e.printStackTrace();
			}
			
		}
		
		return forders;
	}

	@Override
	public Forder getForderByFid(int fid) {
		
		Forder forder=null;
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String sql="SELECT * FROM forder where fid= ?";
		jdbcUtil = new JDBCUtil();
		conn=jdbcUtil.getConnection();
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, fid);
			rs=pstmt.executeQuery();
			rs.next();
				forder=new Forder();
				Account account=new Account();
				account.setAid(rs.getString("aid"));
				forder.setAccount(account);
				forder.setFaddress(rs.getString("faddress"));
				forder.setFdate(rs.getDate("fdate"));
				forder.setFemail(rs.getString("femail"));
				forder.setFid(rs.getInt("fid"));
				forder.setFname(rs.getString("fname"));
				forder.setFphone(rs.getString("fphone"));
				forder.setFpost(rs.getString("fpost"));
				forder.setFremark(rs.getString("fremark"));
				forder.setFtotal(rs.getDouble("ftotal"));
				Status status=new Status();
				status.setSid(rs.getInt("sid"));
				forder.setStatus(status);
				User users=new User();
				users.setUid(rs.getInt("uid"));
				forder.setUsers(users);
		
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				rs.close();
				pstmt.close();
				jdbcUtil.closeConnection();
			} catch (Exception e) {
				
				e.printStackTrace();
			}
			
		}
		
		return forder;
	}

}
