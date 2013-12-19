package com.bajar.listviewcustom;

public class Item {
	String name;
	String status;
	int imageUrl;	//provide Resource
	
	public Item(){
		name="";
		status="";
		imageUrl=0;
	}
	public Item(String name, String status, int imageUrl) {
		this.name = name;
		this.status = status;
		this.imageUrl = imageUrl;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(int imageUrl) {
		this.imageUrl = imageUrl;
	}
	
}
