package com.practice;

import java.util.List;

public class Employee {

	int id;
	String name;
	String department;
	double salary;
	String gender;
	List<Projects> projects;
	
	public Employee(int id, String name, String department, double salary,String gender, List<Projects> projects) {
		this.id = id;
		this.name = name;
		this.department = department;
		this.salary = salary;
		this.gender = gender;
		this.projects = projects;
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
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public List<Projects> getProjects() {
		return projects;
	}
	public void setProjects(List<Projects> projects) {
		this.projects = projects;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", department=" + department + ", salary=" + salary
				+ ", gender=" + gender + ", projects=" + projects + "]";
	}
	
}
