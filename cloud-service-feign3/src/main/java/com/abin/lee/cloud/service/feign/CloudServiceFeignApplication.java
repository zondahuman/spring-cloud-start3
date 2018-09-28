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
//启动器一定要加@EnableFeignClients，代表进行Feign调用，Feign会到Eureka拉取服务列表，供调用的。
@EnableFeignClients
public class CloudServiceFeignApplication {

    public static void main(String[] args) {
        SpringApplication.run(CloudServiceFeignApplication.class, args);
    }

}
