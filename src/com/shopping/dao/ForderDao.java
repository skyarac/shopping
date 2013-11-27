package com.shopping.dao;

import java.util.List;

import com.shopping.entity.Forder;
import com.shopping.entity.Sorder;

public interface ForderDao {
	/*
	 * ���涩��
	 * */
	public Forder saveForder(Forder forder);
	/*
	 * ���¶���״̬
	 * */
	public void updateForderStatus(int fid,int sid);
	/*
	 * �������������Ӷ�����������Ӷ�����
	 * */
    public Forder addSorder(Forder forder,Sorder sorder);
	/*
	 * ����������,��Ʒ��ź����������Ӷ�����
	 * */
	public Forder updateSorder(Forder forder,int gid,int snumber);
	/*
	 * ���㶩���ܼ�
	 * */
	public double cluTotal(Forder forder);
	/*
	 * ɾ���Ӷ�����
	 * */
	public Forder deleteSorder(Forder forder,int gid);
	/*
	 * �������ж�����Ϣ
	 * */
	public List<Forder> getForders();

}
