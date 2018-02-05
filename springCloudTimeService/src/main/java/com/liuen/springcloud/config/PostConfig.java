package com.liuen.springcloud.config;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * Author: En Liu
 * Email: liuen@sungbio.com
 * Date: 2018/2/5 0005
 * Description:
 */
@Component
public class PostConfig {
    @PostConstruct
    public void test(){
        System.out.println("post");
    }
}
