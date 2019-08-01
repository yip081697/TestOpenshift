package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication 
{
	public static void main(String[] args) //controller has to be in same package
	{
		SpringApplication.run(DemoApplication.class, args);
		//e.g. https://localhost:7889/C
	}

}