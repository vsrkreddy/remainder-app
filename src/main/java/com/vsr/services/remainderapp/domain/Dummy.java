package com.vsr.services.remainderapp.domain;

public class Dummy {

	private String message;

	public Dummy(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "Dummy [message=" + message + "]";
	}
	
	

}
