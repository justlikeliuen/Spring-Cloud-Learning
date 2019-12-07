package com.liuen.springcloudlearning.controller;

import com.liuen.springcloudlearning.po.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: liuen
 * @date: 2019-12-03
 * @since:
 **/
@RestController
public class UserFeignController {
    @Autowired
    UserFeignClient userFeignClient;

    @GetMapping("/feignUser/{idByfeign}")
    public User findById(@PathVariable Long idByfeign){
        return userFeignClient.findById(idByfeign);
    }
}
