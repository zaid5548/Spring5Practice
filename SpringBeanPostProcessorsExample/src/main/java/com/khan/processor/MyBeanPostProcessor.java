package com.khan.processor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

import com.khan.model.Message;

public class MyBeanPostProcessor implements BeanPostProcessor{
	
	public Object postProcessAfterInitialization(Object bean,String beanName)throws BeansException {
		System.out.println("Inside of postProcessAfterInitialization");
		Message message=null;
		if(bean instanceof Message) {
			message=(Message)bean;
			message.setMessage("Setting bean of postProcessAfterInitialization");
		}
		return message;
	}
	
	public Object postProcessBeforeInitialization(Object bean,String beanName)throws BeansException{
		System.out.println("Inside of postProcessBeforeInitialization");
		return bean;
	}
	
}
