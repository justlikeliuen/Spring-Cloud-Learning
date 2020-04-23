package com.liuen.springCloud;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@EnableZuulProxy
public class App 
{
    public static void main( String[] args )
    {
        new SpringApplicationBuilder(App.class).run(args);
    }
}
