package com.abin.lee.cloud.service.ribbon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * Created by abin on 2018/9/26.
 */
@EnableDiscoveryClient
@SpringBootApplication
@EnableCircuitBreaker
public class CloudServiceRibbonApplication {

    public static void main(String[] args) {
        SpringApplication.run(CloudServiceRibbonApplication.class, args);
//        new SpringApplicationBuilder(CloudServiceRibbonApplication.class).web(true).run(args);
    }

    @Bean
    @LoadBalanced
    public RestTemplate initBean() {
        return new RestTemplate();
    }


}