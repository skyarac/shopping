package com.shopping.service;

import java.util.List;

import com.shopping.entity.Forder;
import com.shopping.entity.Sorder;

public interface ForderService {
	
	/**
	 * @param forder
	 * @return
	 * 保存并返回订单信息
	 */
	public Forder save(Forder forder);
	
	/**
	 * @param fid
	 * @param sid
	 * 根据主订单号和状态编号更新住订单的状态
	 */
	public void updateForderStatus(int fid,int statusId);
	/**
     * @param forder
     * @param sorder
     * @return
     * 添加订单项
     */
    public Forder addSorder(Forder forder,Sorder sorder);
    /**
	 * @param forder
	 * @param gid
	 * @param snumber
	 * @return
	 * 根据住订单更新订单项
	 */
    public Forder updateSorder(Forder forder,int gid,int snumber);
    /**
	 * @param forder
	 * @return
	 * 计算总价
	 */
	public double countTotal(Forder forder);
	/**
	 * @param forder
	 * @param gid
	 * @return
	 * 删除订单项
	 */
	public Forder deleteSorder(Forder forder,int gid);
	/**
	 * @return
	 * 列出所有订单信息
	 */
	public List<Forder> listAll();
	
	/**
	 * @param statusId
	 * @return
	 * 根据订单的状态返回订单集合
	 */
	public List<Forder> listByStatusId(int statusId);
}
