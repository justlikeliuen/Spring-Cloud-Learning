package com.liuen.springcloudlearning.controller;

import com.liuen.springcloudlearning.po.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author: liuen
 * @date: 2019-12-03
 * @since:
 **/
@FeignClient(name = "TIMESERVICE")
public interface UserFeignClient {
    @GetMapping(value = "/{idByfeign}")
    public User findById(@PathVariable("idByfeign")Long idByfeign);
}
