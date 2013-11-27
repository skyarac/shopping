package com.shopping.dao;

import java.util.List;

import com.shopping.entity.Goods;

public interface GoodsDao {
	/*
	 * 添加商品信息
	 * */
	public void save(Goods goods);
	/*
	 * 根据商品编号gid删除商品信息
	 * */
	public void deleteByGid(int gid);
	/*
	 * 根据类别编号删除商品信息
	 * */
	public void deleteByCid(int cid);
	/*
	 * 根据类别编号查询并返回商品信息
	 * */
	public void goodsModify(Goods goods);
	/*
	 * 根据类别号查询热点，推荐，有效商品
	 * */
	public List<Goods> queryGiscommendGoods(int cid);
	/*
	 * 根据商品类别编号cid查询商品信息
	 * */
	public List<Goods> queryGoodsByCid(int cid);
	
	

}
