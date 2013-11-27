package com.shopping.entity;

public class Status {
/*
 *  sid       INT                     AUTO_INCREMENT,
    status    NATIONAL VARCHAR(20)    NOT NULL,
 * 
 * */
	private int sid;
	private String status;
	public Status(){
		
	}
	public Status(int i) {
		this.sid=i;
	}
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
}
