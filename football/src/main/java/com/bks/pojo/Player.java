package com.bks.pojo;

public class Player {
	private String sid;//学号前6位不需要
    private String password;
    private String name;//姓名
    private int majors;//专业
    private int joinYear;//加入年份
    private int number;//球衣号码
    private String position;//场上位置
    private String specialty;//特长
    private String isCaptain;//是不是队长
    private String isManager;//是不是经理

	public String toString() {
		return "Player [sid=" + sid + ", name=" + name + ", majors=" + majors + ", joinYear=" + joinYear + ", numbers="
				+ number + ", position=" + position + ", specialty=" + specialty + ", isCaptain=" + isCaptain
				+ ", isManager=" + isManager + "]";
	}

	public String getSid() {
		return sid;
	}

	public void setSid(String sid) {
		this.sid = sid;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getMajors() {
		return majors;
	}

	public void setMajors(int majors) {
		this.majors = majors;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getSpecialty() {
		return specialty;
	}

	public void setSpecialty(String specialty) {
		this.specialty = specialty;
	}

	public String getIsCaptain() {
		return isCaptain;
	}

	public void setIsCaptain(String isCaptain) {
		this.isCaptain = isCaptain;
	}

	public String getIsManager() {
		return isManager;
	}

	public void setIsManager(String isManager) {
		this.isManager = isManager;
	}

	public int getJoinYear() {
		return joinYear;
	}

	public void setJoinYear(int joinYear) {
		this.joinYear = joinYear;
	}
	
}
