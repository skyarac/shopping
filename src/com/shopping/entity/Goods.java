package com.shopping.entity;

import java.util.Date;

/*
 * 商品类
 * 
 * */
public class Goods {
	/*
	 * gid INT AUTO_INCREMENT, gname NATIONAL VARCHAR(20) NOT NULL, gprice
	 * DOUBLE(18, 1) NOT NULL, gpic NATIONAL VARCHAR(100) NOT NULL, gremark
	 * NATIONAL VARCHAR(500) NOT NULL, gxremark NATIONAL VARCHAR(1000), gdate
	 * TIMESTAMP(6) NOT NULL, giscommend BIT(1) DEFAULT 0 NOT NULL, gisopen
	 * BIT(1) DEFAULT 0 NOT NULL, cid INT NOT NULL,
	 */
	private int gid;
	private String gname;
	private double gprice;
	private String gpic;
	private String gremark;
	private String gxremark;
	private Date gdate;
	private boolean giscommend;
	private boolean gisopen;
	private Category category;

	public int getGid() {
		return gid;
	}

	public void setGid(int gid) {
		this.gid = gid;
	}

	public String getGname() {
		return gname;
	}

	public void setGname(String gname) {
		this.gname = gname;
	}

	public double getGprice() {
		return gprice;
	}

	public void setGprice(double gprice) {
		this.gprice = gprice;
	}

	public String getGpic() {
		return gpic;
	}

	public void setGpic(String gpic) {
		this.gpic = gpic;
	}

	public String getGremark() {
		return gremark;
	}

	public void setGremark(String gremark) {
		this.gremark = gremark;
	}

	public String getGxremark() {
		return gxremark;
	}

	public void setGxremark(String gxremark) {
		this.gxremark = gxremark;
	}

	public Date getGdate() {
		return gdate;
	}

	public void setGdate(Date gdate) {
		this.gdate = gdate;
	}

	public boolean isGiscommend() {
		return giscommend;
	}

	public void setGiscommend(boolean giscommend) {
		this.giscommend = giscommend;
	}

	public boolean isGisopen() {
		return gisopen;
	}

	public void setGisopen(boolean gisopen) {
		this.gisopen = gisopen;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

}
