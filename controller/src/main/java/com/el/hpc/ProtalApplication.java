package com.el.hpc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

/**
 * Created by ShenQi on 17/4/20.
 */
@SpringBootApplication(scanBasePackages = {"com.el.hpc"})
@EnableMongoRepositories(basePackages = "com.el.hpc.dao")
public class ProtalApplication {
    public static void main(String[] args) {
        SpringApplication.run(ProtalApplication.class, args);
    }
}