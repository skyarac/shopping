package com.shopping.dao;

import java.util.List;

import com.shopping.entity.Goods;

public interface GoodsDao {
	/*
	 * �����Ʒ��Ϣ
	 * */
	public void save(Goods goods);
	/*
	 * ������Ʒ���gidɾ����Ʒ��Ϣ
	 * */
	public void deleteByGid(int gid);
	/*
	 * ���������ɾ����Ʒ��Ϣ
	 * */
	public void deleteByCid(int cid);
	/*
	 * ��������Ų�ѯ��������Ʒ��Ϣ
	 * */
	public void goodsModify(Goods goods);
	/*
	 * �������Ų�ѯ�ȵ㣬�Ƽ�����Ч��Ʒ
	 * */
	public List<Goods> queryGiscommendGoods(int cid);
	/*
	 * ������Ʒ�����cid��ѯ��Ʒ��Ϣ
	 * */
	public List<Goods> queryGoodsByCid(int cid);
	
	

}
