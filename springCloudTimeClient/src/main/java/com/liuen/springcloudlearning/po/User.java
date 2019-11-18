package com.liuen.springcloudlearning.po;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author: liuen
 * @date: 2019-11-17
 * @since:
 **/
@Data
public class User {
    private Long id;
    private String username;
    private String name;
    private int age;
    private BigDecimal balance;
}
