package com.shopping.util;

import java.util.List;

public class PageResult {
	private List list; //装分页列表的内容
	private int firstPage; //第一页
	private int prePage; //上一页
	private int nextPage;//下一页
	private int currentPage; //当前页数
	private int totalPage;//总共页数
	private int count; //总条数
	private int size;  //每页多少条
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
