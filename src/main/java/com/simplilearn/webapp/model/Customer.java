package com.simplilearn.webapp.model;

import java.util.Date;

public class Customer {

	// properties
	private int id;
	private String name;
	private int age;
	private String desc;
	private Date createdAt;
	private Date modifiedAt;
	
	// constructor
	public Customer() {}
	
	public Customer(int id) {
		this.id = id;
	}
	
	public Customer(String name, int age, String desc) {
		super();
		this.name = name;
		this.age = age;
		this.desc = desc;
		this.createdAt =  new Date();
		this.modifiedAt = new Date();
	}

	public Customer(int id, String name, int age, String desc) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.desc = desc;
		this.createdAt =  new Date();
		this.modifiedAt = new Date();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getModifiedAt() {
		return modifiedAt;
	}

	public void setModifiedAt(Date modifiedAt) {
		this.modifiedAt = modifiedAt;
	}

	
	

}