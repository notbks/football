package com.bks.pojo;

public class Player {
	private int sid;
    private String password;
    private String name;
    private int majors;
    private int numbers;
    private String position;
    private String specialty;
    private boolean isCaptain;

	public String toString() {
		return "Player [sid=" + sid + ", password=" + password + ", name=" + name + ", majors=" + majors + ", numbers="
				+ numbers + ", position=" + position + ", specialty=" + specialty + ", isCaptain=" + isCaptain + "]";
	}

	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
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

	public int getNumbers() {
		return numbers;
	}

	public void setNumbers(int numbers) {
		this.numbers = numbers;
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

	public boolean isCaptain() {
		return isCaptain;
	}

	public void setCaptain(boolean isCaptain) {
		this.isCaptain = isCaptain;
	}
	
}
