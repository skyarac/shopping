package com.shopping.dao;

import java.util.List;

import com.shopping.entity.Forder;
import com.shopping.entity.Sorder;

public interface ForderDao {
	/*
	 * 保存订单
	 * */
	public Forder saveForder(Forder forder);
	/*
	 * 更新订单状态
	 * */
	public void updateForderStatus(int fid,int sid);
	/*
	 * 传入主订单和子订单进行添加子订单项
	 * */
    public Forder addSorder(Forder forder,Sorder sorder);
	/*
	 * 传入主订单,商品编号和数量更新子订单项
	 * */
	public Forder updateSorder(Forder forder,int gid,int snumber);
	/*
	 * 计算订单总价
	 * */
	public double cluTotal(Forder forder);
	/*
	 * 删除子订单项
	 * */
	public Forder deleteSorder(Forder forder,int gid);
	/*
	 * 返回所有订单信息
	 * */
	public List<Forder> getForders();

}
