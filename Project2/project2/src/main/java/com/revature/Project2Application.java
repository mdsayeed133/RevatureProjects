package com.revature;

import com.revature.controllers.AuthController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = "com.revature") //we need this to scan for Spring Beans
@EnableJpaRepositories("com.revature.daos") //register our DAO as a bean (since its interfaces)
@EntityScan("com.revature") //register our model classes as DB entities
public class Project2Application {

	public static void main(String[] args) {
		SpringApplication.run(Project2Application.class, args);
	}

}
