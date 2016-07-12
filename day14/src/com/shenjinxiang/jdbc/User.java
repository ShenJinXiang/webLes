package com.shenjinxiang.jdbc;

import java.util.Date;

public class User {

	private int id;
	private String username;
	private Date entry_date;
	private Date brithday;
	private String job;
	private double salary;
	private String resume;
	private String image;
	
	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", entry_date=" + entry_date
				+ ", brithday=" + brithday + ", job=" + job + ", salary=" + salary + ", resume=" + resume + ", image="
				+ image + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Date getEntry_date() {
		return entry_date;
	}

	public void setEntry_date(Date entry_date) {
		this.entry_date = entry_date;
	}

	public Date getBrithday() {
		return brithday;
	}

	public void setBrithday(Date brithday) {
		this.brithday = brithday;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public String getResume() {
		return resume;
	}

	public void setResume(String resume) {
		this.resume = resume;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}


}
