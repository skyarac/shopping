package com.shopping.entity;

/*
 * 订单明细类
 * */
public class Sorder {
	/*
	 * sid INT AUTO_INCREMENT, sname NATIONAL VARCHAR(20), sprice DOUBLE(18, 1),
	 * snumber INT, fid INT NOT NULL, gid INT NOT NULL,
	 */
	private int sid;
	private String sname;
	private Double sprice;
	private int snumber;
	// private Forder forder;
	private Goods goods;

	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public Double getSprice() {
		return sprice;
	}

	public void setSprice(Double sprice) {
		this.sprice = sprice;
	}

	public int getSnumber() {
		return snumber;
	}

	public void setSnumber(int snumber) {
		this.snumber = snumber;
	}

	public Goods getGoods() {
		return goods;
	}

	public void setGoods(Goods goods) {
		this.goods = goods;
	}

	// public Forder getForder() {
	// return forder;
	// }
	// public void setForder(Forder forder) {
	// this.forder = forder;
	// }

}
