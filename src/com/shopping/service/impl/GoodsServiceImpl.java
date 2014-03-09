package com.shopping.service.impl;

import java.util.List;

import com.shopping.dao.GoodsDao;
import com.shopping.dao.impl.GoodsDaoImpl;
import com.shopping.entity.Goods;
import com.shopping.service.GoodsService;

public class GoodsServiceImpl implements GoodsService {
	private GoodsDao goodsDao = new GoodsDaoImpl();

	@Override
	public void save(Goods goods) {
		goodsDao.save(goods);

	}

	@Override
	public void deleteByGid(int gid) {
		goodsDao.deleteByGid(gid);

	}

	@Override
	public void deleteByCid(int cid) {
		goodsDao.deleteByCid(cid);

	}

	@Override
	public void update(Goods goods) {
		goodsDao.update(goods);

	}

	@Override
	public List<Goods> getGiscommendGoods(int cid) {
		return goodsDao.getGiscommendGoods(cid);
	}

	@Override
	public List<Goods> getGoodsByCid(int cid) {
		return goodsDao.getGoodsByCid(cid);
	}

}
