package com.liuen.springcloud;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@RefreshScope
public class SpringCloudConfigClientApplication {
	@Value("${name}")
	private String name;
	public static void main(String[] args) {
		ConfigurableApplicationContext configurableApplicationContext =
				SpringApplication.run(SpringCloudConfigClientApplication.class, args);
		SpringCloudConfigClientApplication cloudConfigClientApplication =
				configurableApplicationContext.getBean(SpringCloudConfigClientApplication.class);
		System.out.println(cloudConfigClientApplication.name);	//configClient 注入成功
	}

	@RequestMapping("/")
	public String test(){
		return name;
	}
}
