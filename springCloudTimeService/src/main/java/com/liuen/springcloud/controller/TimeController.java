package com.liuen.springcloud.controller;

import com.liuen.springcloud.dao.UserRepo;
import com.liuen.springcloud.entity.User;
import com.liuen.springcloud.service.TimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * Author: En Liu
 * Email: liuen@sungbio.com
 * Date: 2018/2/5 0005
 * Description:
 */
@RestController
public class TimeController {
    @Autowired
    TimeService timeService;
    @Autowired
    private UserRepo userRepo;

    @RequestMapping("/select/{name}")
    public List<Map<String,Object>> select(
            @PathVariable String name) {
        return timeService.select(name);
    }

    @RequestMapping("/select1/{name}")
    public String select1(
            @PathVariable String name) {
        return name;
    }

    @RequestMapping("/hello")
    public String select1() {
        return "Hello World";
    }

    @GetMapping("/{id}")
    public User findById(@PathVariable Long id){
        return userRepo.findById(id).get();
    }

/*    @Autowired
    private DiscoveryClient discoveryClient;

    @RequestMapping("/service-instances/{applicationName}")
    public List<ServiceInstance> serviceInstancesByApplicationName(
            @PathVariable String applicationName) {
        List<ServiceInstance> list = this.discoveryClient.getInstances(applicationName);;
        return this.discoveryClient.getInstances(applicationName);
    }*/
}
