package com.bks.pojo;

import java.util.Date;

public class PFile {
	private int fid;
	private String fname;
	private String fpath;
	private Date fdate;
	@Override
	public String toString() {
		return "PFile [fid=" + fid + ", fname=" + fname + ", fpath=" + fpath + ", fdate=" + fdate + "]";
	}
	
	public Date getFdate() {
		return fdate;
	}

	public void setFdate(Date fdate) {
		this.fdate = fdate;
	}

	public int getFid() {
		return fid;
	}
	public void setFid(int fid) {
		this.fid = fid;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getFpath() {
		return fpath;
	}
	public void setFpath(String fpath) {
		this.fpath = fpath;
	}
	
}
