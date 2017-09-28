package com.cog.springcassandra;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages="com.cog.springcassandra")
public class SpringcassandraApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringcassandraApplication.class, args);
	}
}
