package com.sparks.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * rabbitmq启动类
 *
 * @author zp
 */
@EnableEurekaClient
@SpringBootApplication
public class FirstLoveRabbitmqApplication {

    public static void main(String[] args) {
        SpringApplication.run(FirstLoveRabbitmqApplication.class, args);
    }

}
