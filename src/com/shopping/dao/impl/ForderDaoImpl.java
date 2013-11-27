package com.shopping.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.shopping.dao.ForderDao;
import com.shopping.dao.SorderDao;
import com.shopping.entity.Account;
import com.shopping.entity.Forder;
import com.shopping.entity.Sorder;
import com.shopping.entity.Status;
import com.shopping.entity.Users;
import com.shopping.util.DataBaseConnection;

public class ForderDaoImpl implements ForderDao {
	private SorderDao sorderDao=new SorderDaoImpl();

	public Forder saveForder(Forder forder) {
		int fid=0;
	    Connection conn=null;
	    PreparedStatement pstmt=null;
	    ResultSet rs=null;
	    DataBaseConnection dbc=new DataBaseConnection();
	    conn=dbc.getConnection();
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
			dbc.close();
		}
	   
	    
		return forder;
	}

	public void updateForderStatus(int fid, int sid) {
		Connection conn=null;
		PreparedStatement pstmt=null;
		DataBaseConnection dbc=new DataBaseConnection();
		String sql="UPDATE forder SET sid=? WHERE fid=?";
		conn=dbc.getConnection();
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
			dbc.close();
		}
		
		
	}

	public Forder addSorder(Forder forder, Sorder sorder) {
		List<Sorder> sorders = forder.getSorders();
		int i = 0;
		/*判断订单中是否有重复的商品(订单子项)*/
		for (; i < sorders.size(); i++) {
			if (sorders.get(i).getGoods().getGid() == sorder.getGoods().getGid()){
				break;
			}
		}
		if (i < sorders.size())
			sorders.get(i).setSnumber(sorders.get(i).getSnumber() + 1);
		else
			sorders.add(sorder);
		forder.setSorders(sorders);
		// 从新计算购物总价
		forder.setFtotal(this.cluTotal(forder));
		return forder;
	}

	public Forder updateSorder(Forder forder, int gid, int snumber) {
		for(Sorder temp:forder.getSorders()){
			if(temp.getGoods().getGid()==gid){
				temp.setSnumber(snumber);
			}
		}
		forder.setFtotal(this.cluTotal(forder));
		return forder;
	}

	public double cluTotal(Forder forder) {
		double total = 0.0;
		for (Sorder sorder : forder.getSorders()) {
			total += sorder.getSnumber() * sorder.getSprice();
		}
		return total;
	}

	public Forder deleteSorder(Forder forder, int gid) {
		List<Sorder> sorders = forder.getSorders();
		for (int i = 0; i < sorders.size(); i++) {
			if (sorders.get(i).getGoods().getGid() == gid) {
				sorders.remove(i);
				break;
			}
		}
		// 删除后的购物项集合放入到购物车中
		forder.setSorders(sorders);
		// 从新计算购物总价
		forder.setFtotal(this.cluTotal(forder));
		return forder;
	}

	public List<Forder> getForders() {
		List<Forder> forders=new ArrayList<Forder>();
		Forder forder=null;
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		DataBaseConnection dbc=new DataBaseConnection();
		String sql="SELECT * FROM forder";
		conn=dbc.getConnection();
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
				Users users=new Users();
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
				dbc.close();
			} catch (Exception e) {
				
				e.printStackTrace();
			}
			
		}
		
		return forders;
	}

}
