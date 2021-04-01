package com.example.demo.errors;

public class UserErrorResponse {

	private int status;
	private String description;
	private long timeStamp;
	
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public long getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(long timeStamp) {
		this.timeStamp = timeStamp;
	}
	public UserErrorResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
