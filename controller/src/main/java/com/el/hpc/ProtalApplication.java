package com.el.hpc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

/**
 * Created by ShenQi on 17/4/20.
 */
@SpringBootApplication(scanBasePackages = {"com.el.hpc"})
@EnableMongoRepositories(basePackages = "com.el.hpc.dao")
@EnableAutoConfiguration
@ServletComponentScan
public class ProtalApplication {
    public static void main(String[] args) {
//        SpringApplication.run(ProtalApplication.class, args);

        SpringApplication app = new SpringApplication(ProtalApplication.class);
        app.setWebEnvironment(true);
//        app.setShowBanner(false);

//        Set<Object> set = new HashSet<Object>();
////        set.add("classpath:applicationContext.xml");
//        app.setSources(set);
        app.run(args);
    }
}