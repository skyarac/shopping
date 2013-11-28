package com.shopping.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
/*
 * 订单项类
 * */
public class Forder {
 /*
  *     fid        INT                     AUTO_INCREMENT,
	    fdate      TIMESTAMP(6)             NOT NULL,
	    ftotal      Double    NOT NULL,
	    fname      NATIONAL VARCHAR(20)    NOT NULL,
	    fphone     NATIONAL VARCHAR(20)    NOT NULL,
	    fremark    NATIONAL VARCHAR(50)    NOT NULL,
	    femail     NATIONAL VARCHAR(20)    NOT NULL,
	    fpost      NATIONAL VARCHAR(10)    NOT NULL,
		faddress   national varchar(50)    not null,
	    uid        INT                     NOT NULL,
	    aid        INT,
	    sid        INT                     NOT NULL,
  * */
	private int fid;
	private Date fdate;
	private Double ftotal;
	private String fname;
	private String fphone;
	private String fremark;
	private String femail;
	private String fpost;
	private String faddress;
	private Users users;
	private Account account;
	private Status status;
	/*
	 * �洢������
	 * */
	private List<Sorder> sorders=new ArrayList<Sorder>();
	public int getFid() {
		return fid;
	}
	public void setFid(int fid) {
		this.fid = fid;
	}
	public Date getFdate() {
		return fdate;
	}
	public void setFdate(Date fdate) {
		this.fdate = fdate;
	}
	public Double getFtotal() {
		return ftotal;
	}
	public void setFtotal(Double ftotal) {
		this.ftotal = ftotal;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getFphone() {
		return fphone;
	}
	public void setFphone(String fphone) {
		this.fphone = fphone;
	}
	public String getFremark() {
		return fremark;
	}
	public void setFremark(String fremark) {
		this.fremark = fremark;
	}
	public String getFemail() {
		return femail;
	}
	public void setFemail(String femail) {
		this.femail = femail;
	}
	public String getFpost() {
		return fpost;
	}
	public void setFpost(String fpost) {
		this.fpost = fpost;
	}
	public String getFaddress() {
		return faddress;
	}
	public void setFaddress(String faddress) {
		this.faddress = faddress;
	}
	public Users getUsers() {
		return users;
	}
	public void setUsers(Users users) {
		this.users = users;
	}
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	public List<Sorder> getSorders() {
		return sorders;
	}
	public void setSorders(List<Sorder> sorders) {
		this.sorders = sorders;
	}
	
	
}
