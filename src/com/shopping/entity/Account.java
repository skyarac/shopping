package com.shopping.entity;

public class Account {
	/*
	 *  aid       NATIONAL VARCHAR(20)    AUTO_INCREMENT,
	    alogin    NATIONAL VARCHAR(20)    NOT NULL,
	    aname     NATIONAL VARCHAR(20),
	    apass     NATIONAL VARCHAR(20),
	 * */
	private String aid;
	private String alogin;
	private String aname;
	private String apass;
	public String getAid() {
		return aid;
	}
	public void setAid(String aid) {
		this.aid = aid;
	}
	public String getAlogin() {
		return alogin;
	}
	public void setAlogin(String alogin) {
		this.alogin = alogin;
	}
	public String getAname() {
		return aname;
	}
	public void setAname(String aname) {
		this.aname = aname;
	}
	public String getApass() {
		return apass;
	}
	public void setApass(String apass) {
		this.apass = apass;
	}

}
