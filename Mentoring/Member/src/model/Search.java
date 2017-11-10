package model;

public class Search {
	private int age = 0;
	private String field = null;
	private String region = null;
	private String total = null;
	
	public void setAge(int age) {
		this.age = age;
	}
	public void setTotal(String total) {
		this.total = total;
	}
	public void setField(String field) {
		this.field = field;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public int getAge() {
		return age;
	}
	public String getField() {
		return field;
	}
	public String getRegion() {
		return region;
	}
	public String getTotal() {
		return total;
	}
	
	
}
