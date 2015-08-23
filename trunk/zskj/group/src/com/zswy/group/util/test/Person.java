package com.zswy.group.util.test;

public class Person {
	private String name;
	private int age;
	private PhoneNumer homePhone;
	private PhoneNumer officePhone;
	public Person(String name,int age,PhoneNumer homePhone, PhoneNumer officePhone){
		this.name = name;
		this.age = age;
		this.homePhone = homePhone;
		this.officePhone = officePhone;
		
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
	public PhoneNumer getHomePhone() {
		return homePhone;
	}
	public void setHomePhone(PhoneNumer homePhone) {
		this.homePhone = homePhone;
	}
	public PhoneNumer getOfficePhone() {
		return officePhone;
	}
	public void setOfficePhone(PhoneNumer officePhone) {
		this.officePhone = officePhone;
	}
	
	
}
