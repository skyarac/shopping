package com.shopping.entity;

/*
 * 会员实体�? * */
public class User {
	/*
	 * uid INT AUTO_INCREMENT, ulogin NATIONAL VARCHAR(20) NOT NULL, uname
	 * NATIONAL VARCHAR(20) NOT NULL, upass NATIONAL VARCHAR(20) NOT NULL, usex
	 * NATIONAL VARCHAR(2) NOT NULL, uphone NATIONAL VARCHAR(20), upost NATIONAL
	 * VARCHAR(20), uemail NATIONAL VARCHAR(20), uaddress NATIONAL VARCHAR(20),
	 * PRIMARY KEY (uid)
	 */
	private int uid;
	private String ulogin;
	private String uname;
	private String upass;
	private String usex;
	private String uphone;
	private String upost;
	private String uemail;
	private String uaddress;

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public String getUlogin() {
		return ulogin;
	}

	public void setUlogin(String ulogin) {
		this.ulogin = ulogin;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getUpass() {
		return upass;
	}

	public void setUpass(String upass) {
		this.upass = upass;
	}

	public String getUsex() {
		return usex;
	}

	public void setUsex(String usex) {
		this.usex = usex;
	}

	public String getUphone() {
		return uphone;
	}

	public void setUphone(String uphone) {
		this.uphone = uphone;
	}

	public String getUpost() {
		return upost;
	}

	public void setUpost(String upost) {
		this.upost = upost;
	}

	public String getUemail() {
		return uemail;
	}

	public void setUemail(String uemail) {
		this.uemail = uemail;
	}

	public String getUaddress() {
		return uaddress;
	}

	public void setUaddress(String uaddress) {
		this.uaddress = uaddress;
	}

}
