package com.google.ai.dto;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class ResponseStructure<T> {
	String message;
	int status;
	List<T> data;
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public List<T> getData() {
		return data;
	}
	public void setData(List<T> data) {
		this.data = data;
	}
	
}
