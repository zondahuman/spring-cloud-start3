package com.abin.lee.cloud.service.provider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Created by abin on 2018/9/26.
 */
@EnableDiscoveryClient
@SpringBootApplication
public class CloudServiceProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(CloudServiceProviderApplication.class, args);
//        new SpringApplicationBuilder(CloudServiceProviderApplication.class).web(true).run(args);
    }

}
