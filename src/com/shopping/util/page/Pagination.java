package com.shopping.util.page;

import java.io.Serializable;
import java.util.List;

@SuppressWarnings("serial")
public class Pagination extends SimplePage implements Serializable, Paginable {
	/**
	 * 当前页的数据
	 */
	private List<?> list;

	public Pagination() {
	}

	/**
	 * @param pageNo
	 * 			页码
	 * @param pageSize
	 * 			每页几条数据
	 * @param totalCount
	 * 			总共几条数据
	 */
	public Pagination(int pageNo, int pageSize, int totalCount) {
		super(pageNo, pageSize, totalCount);
	}

	/**
	 * @param pageNo
	 * 			页码
	 * @param pageSize
	 * 			每页几条数据
	 * @param totalCount
	 * 			总共几条数据
	 * @param list
	 * 			分页内容
	 */
	public Pagination(int pageNo, int pageSize, int totalCount, List<?> list) {
		super(pageNo, pageSize, totalCount);
		this.list = list;
	}

	/**
	 * 第一条数据的位置
	 * 
	 * @return
	 */
	public int getFirstResult() {
		return (pageNo - 1) * pageSize;
	}

	/**
	 * 获得分页内容
	 * 
	 * @return
	 */
	public List<?> getList() {
		return list;
	}

	@SuppressWarnings("rawtypes")
	public void setList(List list) {
		this.list = list;
	}

}
