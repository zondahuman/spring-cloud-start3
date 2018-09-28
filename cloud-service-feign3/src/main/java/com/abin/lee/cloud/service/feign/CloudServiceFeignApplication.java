package com.abin.lee.cloud.service.feign;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * Created by abin on 2018/9/26.
 */
@EnableDiscoveryClient
@SpringBootApplication
@EnableFeignClients
public class CloudServiceFeignApplication {

    public static void main(String[] args) {
        SpringApplication.run(CloudServiceFeignApplication.class, args);
    }

}
