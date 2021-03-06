package com.liuen.springCloud;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@EnableHystrixDashboard
public class App 
{
    public static void main( String[] args )
    {
        new SpringApplicationBuilder(App.class)
                .run(args);
    }
}
