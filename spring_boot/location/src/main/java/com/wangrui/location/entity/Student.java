package com.wangrui.location.entity;

import java.io.Serializable;



public class Student implements Serializable{

	private Integer id;
	private String studentID;
	private String name;
	private String password;
	private String gender;
//	private Integer classID;
	private MyClass myClass;

	
	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getStudentID() {
		return studentID;
	}


	public void setStudentID(String studentID) {
		this.studentID = studentID;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	public MyClass getMyClass() {
		return myClass;
	}


	public void setMyClass(MyClass myClass) {
		this.myClass = myClass;
	}


	public Student() {
		
	}


	public Student(Integer id, String studentID, String name, String password, String gender, MyClass myClass) {
		super();
		this.id = id;
		this.studentID = studentID;
		this.name = name;
		this.password = password;
		this.gender = gender;
		this.myClass = myClass;
	}


	@Override
	public String toString() {
		return "Student [id=" + id + ", studentID=" + studentID + ", name=" + name + ", password=" + password
				+ ", gender=" + gender + ", myClass=" + myClass + "]";
	}
	
	
}
