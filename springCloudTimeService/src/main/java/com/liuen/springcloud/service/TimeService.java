package com.liuen.springcloud.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Author: En Liu
 * Email: liuen@sungbio.com
 * Date: 2018/2/5 0005
 * Description:
 */
@Service
public class TimeService {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Map<String,Object>> select(String name){
        System.out.println(1);
        return jdbcTemplate.queryForList("select * from actor");
    }

    public String selectTest(String name){
        return name;
    }
}
