package com.shopping.service;

import java.util.List;

import com.shopping.entity.Goods;

public interface GoodsService {
	
	/**
	 * @param goods
	 * 保存商品
	 * 
	 */
	public void save(Goods goods);

	/**
	 * @param gid
	 * 根据商品编号删除商品
	 */
	public void deleteByGid(int gid);

	/**
	 * @param cid
	 * 根据类别编号删除商品
	 */
	public void deleteByCid(int cid);

	/**
	 * @param goods
	 * 更新商品
	 */
	public void update(Goods goods);

	/**
	 * @param cid
	 * @return
	 * 查询并返回热点并推荐商品
	 */
	public List<Goods> getGiscommendGoods(int cid);

	/**
	 * @param cid
	 * @return
	 * 根据类别编号返回商品
	 */
	public List<Goods> getGoodsByCid(int cid);
}
