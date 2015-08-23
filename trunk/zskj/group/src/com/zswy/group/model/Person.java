package com.zswy.group.model;

public class Person {
	private int personid;
	private String name;
	private int age;
	private String sex;
	private String birthday;
	private String address;
	public Person(){}
	
	public Person(int personid,String name, int age, String sex, String birthday, String address){
		this.personid = personid;
		this.name = name;
		this.age = age;
		this.sex = sex;
		this.birthday = birthday;
		this.address = address;
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
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getPersonid() {
		return personid;
	}

	public void setPersonid(int personid) {
		this.personid = personid;
	}

	
	
	
}
