package model;

import java.io.Serializable;

@SuppressWarnings("serial")

public class Member implements Serializable {
	private String mbID = null;
	private String mbName = null;
	private int age;
	private String pwd = null;
	private String job = null;
	private String address = null;
	private String[] email = null;
	private String[] birth = null;
	private String[] phone = null;
	private String[] field = null;
	private String[] region = null;
	private String gender;
	private String Admin_Id = null;
	private String img = null;
	
	public String getMbID() {
		return mbID;
	}
	public void setMbID(String mbID) {
		this.mbID = mbID;
	}
	public String getMbName() {
		return mbName;
	}
	public void setMbName(String mbName) {
		this.mbName = mbName;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String[] getEmail() {
		return email;
	}
	public void setEmail(String[] email) {
		this.email = email;
	}
	public String[] getBirth() {
		return birth;
	}
	public void setBirth(String[] birth) {
		this.birth = birth;
	}
	public String[] getPhone() {
		return phone;
	}
	public void setPhone(String[] phone) {
		this.phone = phone;
	}
	public String[] getField() {
		return field;
	}
	public void setField(String[] field) {
		this.field = field;
	}
	public String[] getRegion() {
		return region;
	}
	public void setRegion(String[] region) {
		this.region = region;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getAdmin_Id() {
		return Admin_Id;
	}
	public void setAdmin_Id(String admin_Id) {
		Admin_Id = admin_Id;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	
}
