package com.liuen.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@EnableEurekaClient
public class SpringCloudTimeServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudTimeServiceApplication.class, args);
	}
}
