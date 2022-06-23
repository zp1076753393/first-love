package com.sparks.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * 网关
 *
 * @author zp
 */
@EnableFeignClients(basePackages = "com.sparks.common")
@EnableEurekaClient
@SpringBootApplication
public class FirstLoveGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(FirstLoveGatewayApplication.class, args);
    }

}
