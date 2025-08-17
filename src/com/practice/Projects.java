package com.practice;

public class Projects {

	public String name;
	public String code;
	public String client;
	
	public Projects(String name, String code, String client) {
		super();
		this.name = name;
		this.code = code;
		this.client = client;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getClient() {
		return client;
	}
	public void setClient(String client) {
		this.client = client;
	}
	
	@Override
	public String toString() {
		return "Projects [name=" + name + ", code=" + code + ", client=" + client + "]";
	}
	
	
}
