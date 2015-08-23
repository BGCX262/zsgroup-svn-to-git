package com.zswy.group.util.test;

public class PhoneNumer {
	
	private String type;
	private String number;
	
	public PhoneNumer(){
		
	}
	public PhoneNumer(String type, String number){
		this.type = type;
		this.number = number;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}

}
