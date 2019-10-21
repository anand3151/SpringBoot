package com.practice;

import java.io.Serializable;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonProperty;

@Component
public class Message implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Override
	public String toString() {
		return "Message {id=" + id + ", message=" + message + ", getId()=" + getId() + ", getMessage()=" + getMessage()
				
				+ "}";
	}
	@JsonProperty("iD")
	private String id;
	@JsonProperty("Message")
	private String message;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	
	
}
