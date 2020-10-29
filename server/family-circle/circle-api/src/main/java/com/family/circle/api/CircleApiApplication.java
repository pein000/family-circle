package com.family.circle.api;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author pein
 */
@SpringBootApplication
@MapperScan("com.family.circle.api.mapper")
public class CircleApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(CircleApiApplication.class, args);
    }

}
