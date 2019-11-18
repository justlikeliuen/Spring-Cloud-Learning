package com.liuen.springcloudlearning.controller;

import com.liuen.springcloudlearning.po.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
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
@EnableEurekaClient
public class TimeClientConsumer {
    @Autowired
    RestTemplate restTemplate;

    @RequestMapping(value = "/timeClient",method = RequestMethod.GET)
    public String consume(){
        return restTemplate.getForEntity("http://TIMESERVICE/hello",String.class).getBody();
    }

    @GetMapping("/user/{id}")
    public User find(@PathVariable Long id){
        return restTemplate.getForObject("http://localhost:8088/"+id, User.class);
    }
}
