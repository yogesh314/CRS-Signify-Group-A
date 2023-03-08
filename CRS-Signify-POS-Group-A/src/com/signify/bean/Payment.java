package com.signify.bean;
public class Payment {
	private String studentId, referencedId, mode;
	private double amount;
	private int status;
	
	
	public String getStudentId() {
		return studentId;
	}
	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}
	public String getReferencedId() {
		return referencedId;
	}
	public void setReferencedId(String referencedId) {
		this.referencedId = referencedId;
	}
	public String getMode() {
		return mode;
	}
	public void setMode(String mode) {
		this.mode = mode;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}


}
