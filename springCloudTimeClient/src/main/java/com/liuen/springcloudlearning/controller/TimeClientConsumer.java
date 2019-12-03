package com.liuen.springcloudlearning.controller;

import com.liuen.springcloudlearning.po.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Author: En Liu
 * Email: liuen@sungbio.com
 * Date: 2018/2/12 0012
 * Description:
 */
@RestController
@Slf4j
public class TimeClientConsumer {
    @Autowired
    RestTemplate restTemplate;
    @Autowired
    LoadBalancerClient loadBalancerClient;

    @RequestMapping(value = "/timeClient",method = RequestMethod.GET)
    public String consume(){
        return restTemplate.getForEntity("http://TIMESERVICE/hello",String.class).getBody();
    }

    @GetMapping("/user/{id}")
    public User find(@PathVariable Long id){
        return restTemplate.getForObject("http://TIMESERVICE/"+id, User.class);
    }

    @GetMapping("/log-user-instance")
    public void logUserInstance(){
        ServiceInstance serviceInstance = this.loadBalancerClient.choose("TIMESERVICE");
        log.info("{}:{}:{}", serviceInstance.getInstanceId()
        ,serviceInstance.getHost(), serviceInstance.getPort());
    }
}
