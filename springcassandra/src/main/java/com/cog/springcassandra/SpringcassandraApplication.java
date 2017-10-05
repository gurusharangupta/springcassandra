package com.cog.springcassandra;

import java.util.Properties;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ComponentScan(basePackages="com.cog.springcassandra")
public class SpringcassandraApplication {

	public static void main(String[] args) {
		SpringApplication app =
                new SpringApplication(SpringcassandraApplication.class);
        Properties properties = new Properties();
        properties.setProperty("spring.resources.staticLocations",
                "classpath:/static/,classpath:/static/swagger/");
        app.setDefaultProperties(properties);
		SpringApplication.run(SpringcassandraApplication.class, args);
	}
}


