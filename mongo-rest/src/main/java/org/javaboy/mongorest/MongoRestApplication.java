package org.javaboy.mongorest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MongoRestApplication {

    /*
    http://localhost:8080/books

     */

    public static void main(String[] args) {
        SpringApplication.run(MongoRestApplication.class, args);
    }

}
