package com.shopping.dao;

import java.util.List;

import com.shopping.entity.Forder;

public interface ForderDao {
	
	/**
	 * @param forder
	 * @return
	 * 保存住订单
	 */
	public Forder save(Forder forder);
	
	/**
	 * @param fid
	 * @param sid
	 * 根据主订单号和状态编号更新住订单的状态
	 */
	public void updateForderStatus(int fid,int sid);
	
	/**
	 * @return
	 * 列出所有订单信息
	 */
	public List<Forder> listAll();

	/**
	 * @param id
	 * @return
	 * 根据订单状态返回订单集合
	 */
	public List<Forder> listByStatusId(int id);

}
