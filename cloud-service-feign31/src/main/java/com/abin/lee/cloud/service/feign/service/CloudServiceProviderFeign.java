package com.abin.lee.cloud.service.feign.service;

import com.abin.lee.cloud.service.feign.configuration.CloudServiceProviderConfiguration;
import com.abin.lee.cloud.service.feign.hystrix.CloudServiceProviderFeignHystrix;
import com.abin.lee.cloud.service.model.CloudModel;
import feign.Param;
import feign.RequestLine;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;
import java.util.Map;

/**
 * Created by abin on 2018/9/27.
 * feign客户客户端的时候，默认使用springmvc的注解@RequestMapping，method只能使用一个
 * 可以指定使用feign的注解@RequestLine
 */
//首先使用serverId查找服务，如果找不到再使用url查找。
//@FeignClient(value = "cloud-service-provider", url = "http://localhost:9455", fallback = CloudServiceProviderFeignHystrix.class)
@FeignClient(value = "cloud-service-provider", url = "http://localhost:9455", configuration = CloudServiceProviderConfiguration.class, fallback = CloudServiceProviderFeignHystrix.class)
public interface CloudServiceProviderFeign {

    @RequestLine("POST /add")
    Integer add(@Param("param1") Integer param1, @Param("param2") Integer param2);

    @RequestLine("POST /find")
    Map<String, String> find(@Param("name") String name, @Param("count") String count);

    @RequestLine("GET /get?id={id}")
    Integer get(@Param("id") Long id);

    @RequestLine("GET /getList?id={id}")
    List<Integer> getList(@Param("id") Long id);

    @RequestLine("GET /findOrderByParam")
    List<CloudModel> findOrderByParam(@ModelAttribute("cloudModel") CloudModel orderModel);

    @RequestLine("GET /findOrderById")
    List<CloudModel> findOrderById(@Param("id") Long id);


}

