package com.shopping.entity;
/*
 * 商品类别实体类
 * */
public class Category {
	/*
	 *  cid      INT                     AUTO_INCREMENT,
	    ctype    NATIONAL VARCHAR(20)    NOT NULL,
	    chot     BIT(1)                  DEFAULT 0,
	    aid      NATIONAL VARCHAR(20)                     NOT NULL,
	 * */
	private int cid;
	private String ctype;
	private boolean chot;
	private Account account;
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getCtype() {
		return ctype;
	}
	public void setCtype(String ctype) {
		this.ctype = ctype;
	}
	public boolean getChot() {
		return chot;
	}
	public void setChot(boolean chot) {
		this.chot = chot;
	}
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
	

}
