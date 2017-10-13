package com.cog.springcassandra;

import java.util.Properties;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ComponentScan(basePackages="com.cog.springcassandra")
public class SpringcassandraApplication {

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(SpringcassandraApplication.class);
        /*Properties properties = new Properties();
        properties.setProperty("spring.resources.staticLocations",
<<<<<<< HEAD
                "classpath:/static/,classpath:/static/swagger/, classpath:/static/src/");
        app.setDefaultProperties(properties);*/
/*=======
                "classpath:/static/,classpath:/static/pdf/sample.pdf,classpath:/static/swagger/, classpath:/static/src/");
        app.setDefaultProperties(properties);
>>>>>>> origin/mail-branch-dev*/
		SpringApplication.run(SpringcassandraApplication.class, args);
	}
}


