package com.example.redismongodb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class RedisMongodbApplication {

    public static void main(String[] args) {
        SpringApplication.run(RedisMongodbApplication.class, args);
    }

}
