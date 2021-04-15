package com.bit.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ParsingPropTestApplication implements CommandLineRunner {
	@Autowired
	BitBean bitBean;

	public static void main(String[] args) {
		SpringApplication.run(ParsingPropTestApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println(bitBean);
	}

}
