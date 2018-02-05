package com.liuen.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
//@EnableEurekaClient
@RestController
public class SpringCloudTimeServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudTimeServiceApplication.class, args);
	}

/*	@Autowired
	private DiscoveryClient discoveryClient;

	@RequestMapping("/service-instances/{applicationName}")
	public List<ServiceInstance> serviceInstancesByApplicationName(
			@PathVariable String applicationName) {
		List<ServiceInstance> list = this.discoveryClient.getInstances(applicationName);;
		return this.discoveryClient.getInstances(applicationName);
	}*/

}
