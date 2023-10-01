package org.hiseb.hisebapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = { "org.hiseb.hisebapi.controller", "org.hiseb.hisebapi.service",
		"org.hiseb.hisebapi.repo", "org.hiseb.hisebapi.entity" })
public class HisebApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(HisebApiApplication.class, args);
	}

}
