package com.khan.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.khan.model.Message;

@Configuration
public class MySpringConfig {

	@Bean
	public Message message(){
		return new Message();
	}
}
