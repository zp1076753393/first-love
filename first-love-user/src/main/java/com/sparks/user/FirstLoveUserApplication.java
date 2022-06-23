package com.sparks.user;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * 用户微服务启动类
 *
 * @author zp
 */
@EnableEurekaClient
@SpringBootApplication
@MapperScan("com.sparks.user.dao")
public class FirstLoveUserApplication {

    public static void main(String[] args) {
        SpringApplication.run(FirstLoveUserApplication.class, args);
    }

}
