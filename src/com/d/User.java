package com.d;

public class User {
	
	private String uname;
	private String gender;
	private String country;
	private String pass;
	private String confpass;
	
	
	public String getUname() {
		return uname;
	}


	public void setUname(String uname) {
		this.uname = uname;
	}


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	public String getCountry() {
		return country;
	}


	public void setCountry(String country) {
		this.country = country;
	}


	public String getPass() {
		return pass;
	}


	public void setPass(String pass) {
		this.pass = pass;
	}


	public String getConfpass() {
		return confpass;
	}


	public void setConfpass(String confpass) {
		this.confpass = confpass;
	}


	@Override
	public String toString() {
		return "User [uname=" + uname + ", gender=" + gender + ", country=" + country + ", pass=" + pass + ", confpass="
				+ confpass + "]";
	}


	}

