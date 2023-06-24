package com.ust.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.ust.rest.repository.ProductRepository;
import com.ust.rest.resource.Product;



@SpringBootApplication
//@EnableSwagger2
public class FirstrestApplication  {
	@Autowired
	ProductRepository repo;

	public static void main(String[] args) {
		ConfigurableApplicationContext ctxt=SpringApplication.run(FirstrestApplication.class, args);
		
		boolean found=ctxt.containsBean("productRepostiory");
		System.out.println(found);
		
	}

	

}
