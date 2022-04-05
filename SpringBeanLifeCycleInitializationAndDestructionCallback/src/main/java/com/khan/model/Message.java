package com.khan.model;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class Message{
	private Integer messageid;
	private String message;
	
	public Message() {
		System.out.println("Welcome To SpringBeanLifeCycleInitializationCallback...");
	}
	
	public Integer getMessageid() {
		return messageid;
	}
	public void setMessageid(Integer messageid) {
		System.out.println("Set MessageId !");
		this.messageid = messageid;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		System.out.println("Set Message !");
		this.message = message;
	}

	@PreDestroy
	public void destroy() throws Exception {
		System.out.println("Message bean is going to destroy...");
		
	}

	@PostConstruct
	public void init() throws Exception {
		System.out.println("Message bean is ready to use...");		
	}
}
