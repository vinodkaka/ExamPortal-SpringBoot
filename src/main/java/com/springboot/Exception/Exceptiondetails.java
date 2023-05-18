package com.springboot.Exception;

import java.util.Date;

public class Exceptiondetails {
	
	private Date timestamp;
	private String errormsg;
	private int errorcode;
	
	
	
	public Exceptiondetails() {
	}
	
	public Exceptiondetails(Date timestamp, String errormsg, int errorcode) {
		this.timestamp = timestamp;
		this.errormsg = errormsg;
		this.errorcode = errorcode;
	}
	public Date getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
	public String getErrormsg() {
		return errormsg;
	}
	public void setErrormsg(String errormsg) {
		this.errormsg = errormsg;
	}
	public int getErrorcode() {
		return errorcode;
	}
	public void setErrorcode(int errorcode) {
		this.errorcode = errorcode;
	}

}
