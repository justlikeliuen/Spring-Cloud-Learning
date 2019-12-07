package com.liuen.springcloudlearning.controller;

import com.liuen.springcloudlearning.po.User;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author: liuen
 * @date: 2019-12-07
 * @since:
 **/
@RestController
@Slf4j
public class HystrixController {
    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/user/{id}")
    @HystrixCommand(fallbackMethod = "findByIdFallback", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "5000"),
            @HystrixProperty(name = "metrics.rollingStats.timeInMilliseconds", value = "10000")
    }, threadPoolProperties = {
            @HystrixProperty(name = "coreSize", value = "1"),
            @HystrixProperty(name = "maxQueueSize", value = "10")
    })
    public User find(@PathVariable Long id){
        return restTemplate.getForObject("http://TIMESERVICE/"+id, User.class);
    }

    public User findByIdFallback(Long id, Throwable throwable){
        log.error("error:",throwable);
        User user = new User();
        user.setAge(0);
        user.setName("default");
        return user;
    }
}
