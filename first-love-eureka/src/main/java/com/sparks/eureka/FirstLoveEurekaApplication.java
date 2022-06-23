package com.sparks.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * Eureka
 *
 * @author zp
 */
@EnableEurekaServer
@SpringBootApplication
public class FirstLoveEurekaApplication {

    public static void main(String[] args) {
        SpringApplication.run(FirstLoveEurekaApplication.class, args);
    }

}
