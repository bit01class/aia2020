package com.bit.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import lombok.ToString;

@Component
@PropertySource("bit.properties")
@ToString
public class BitBean {

	@Value("${bit.id}")
	String id;
	
	@Value("${bit.pw}")
	String pw;
	
	@Value("${bit.name}")
	String name;
}
