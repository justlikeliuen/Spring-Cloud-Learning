package com.liuen.springcloud.controller;

import com.liuen.springcloud.service.TimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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

    @Autowired
    private DiscoveryClient discoveryClient;

    @RequestMapping("/service-instances/{applicationName}")
    public List<ServiceInstance> serviceInstancesByApplicationName(
            @PathVariable String applicationName) {
        List<ServiceInstance> list = this.discoveryClient.getInstances(applicationName);;
        return this.discoveryClient.getInstances(applicationName);
    }
}
