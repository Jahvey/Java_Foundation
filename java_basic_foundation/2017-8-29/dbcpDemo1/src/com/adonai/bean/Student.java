package com.adonai.bean;

public class Student {
	private String stuId;// 学生id
	private String name;// 学生姓名
	private String password;
	private String gender;// 学生
	private String phone;// 学生电话
	private int age;// 学生年龄
	private String address;// 学生家庭地址
	private String img;
	private String major;
	
	@Override
	public String toString() {
		return "Student [stuId=" + stuId + ", name=" + name + ", password=" + password + ", gender=" + gender
				+ ", phone=" + phone + ", age=" + age + ", address=" + address + ", img=" + img + ", major=" + major
				+ "]";
	}
	public String getStuId() {
		return stuId;
	}
	public void setStuId(String stuId) {
		this.stuId = stuId;
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
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}


}
