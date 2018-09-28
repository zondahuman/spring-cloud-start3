package com.abin.lee.cloud.service.ribbon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Created by abin on 2018/9/26.
 */
@EnableDiscoveryClient
@SpringBootApplication
public class CloudServiceRibbonApplication {

    public static void main(String[] args) {
        SpringApplication.run(CloudServiceRibbonApplication.class, args);
//        new SpringApplicationBuilder(CloudServiceRibbonApplication.class).web(true).run(args);
    }

}