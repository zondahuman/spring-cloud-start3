package com.abin.lee.cloud.service.feign.configuration;

import feign.Contract;
import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by abin on 2018/9/28.
 *  如果启用了这里的注解Bean必须在feignClient注解的接口中使用feign的注解，默认使用springmvc注解
 */
@Configuration
public class CloudServiceProvider2Configuration {

    @Bean
    public Contract feignContract() {
        return new Contract.Default();
    }

    @Bean
    Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }

}
