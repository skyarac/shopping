package com.shopping.util;

import java.util.List;

public class PageResult {
	private List list; //װ��ҳ�б������
	private int firstPage; //��һҳ
	private int prePage; //��һҳ
	private int nextPage;//��һҳ
	private int currentPage; //��ǰҳ��
	private int totalPage;//�ܹ�ҳ��
	private int count; //������
	private int size;  //ÿҳ������
	public List getList() {
		return list;
	}
	public void setList(List list) {
		this.list = list;
	}
	public int getFirstPage() {
		return firstPage;
	}
	public void setFirstPage(int firstPage) {
		this.firstPage = firstPage;
	}
	public int getPrePage() {
		return (this.currentPage-1==0?1:this.currentPage-1);
	}
	public void setPrePage(int prePage) {
		this.prePage = prePage;
	}
	public int getNextPage() {
		return (this.currentPage==totalPage?this.totalPage:this.currentPage+1);
	}
	public void setNextPage(int nextPage) {
		this.nextPage = nextPage;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getTotalPage() {
		return (this.count%this.size==0?this.count/this.size:this.count/this.size+1);
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	

}
