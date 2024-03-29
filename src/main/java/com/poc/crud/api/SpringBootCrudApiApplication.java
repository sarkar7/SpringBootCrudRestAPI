package com.poc.crud.api;
/**
 * @author Sourabh Sarkar
 * Date - 01-09-2021
 * 
 */
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
public class SpringBootCrudApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootCrudApiApplication.class, args);
	}

}
