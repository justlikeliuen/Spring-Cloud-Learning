package com.liuen.springcloud;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class SpringcloudEurekaApplication {

	public static void main(String[] args) {
		new SpringApplicationBuilder(SpringcloudEurekaApplication.class)
				.web(WebApplicationType.SERVLET)
				.run(args);
	}
}
