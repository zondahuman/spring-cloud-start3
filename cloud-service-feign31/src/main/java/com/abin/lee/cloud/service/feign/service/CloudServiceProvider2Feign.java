package com.abin.lee.cloud.service.feign.service;

import com.abin.lee.cloud.service.feign.configuration.CloudServiceProvider2Configuration;
import com.abin.lee.cloud.service.feign.hystrix.CloudServiceProvider2FeignHystrix;
import com.abin.lee.cloud.service.model.CloudModel;
import feign.Param;
import feign.RequestLine;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;
import java.util.Map;

/**
 * Created by abin on 2018/9/27.
 * https://www.jb51.net/article/133770.htm
 * https://blog.csdn.net/huaseven0527/article/details/80533983
 */
//首先使用serverId查找服务，如果找不到再使用url查找。
//@FeignClient(value = "cloud-service-provider", url = "http://localhost:9455", fallback = CloudServiceProvider2FeignHystrix.class)
@FeignClient(value = "cloud-service-provider", url = "http://localhost:9455", configuration = CloudServiceProvider2Configuration.class, fallback = CloudServiceProvider2FeignHystrix.class)
public interface CloudServiceProvider2Feign {

    @RequestLine("POST /add2")
    Integer add2(@Param("param1") Integer param1, @Param("param2") Integer param2);

    @RequestLine("POST /find2")
    Map<String, String> find2(@Param("name") String name, @Param("count") String count);

    @RequestLine("GET /get2")
    Integer get2(@Param("id") Long id);

    @RequestLine("GET /getList2")
    List<Integer> getList2(@Param("id") Long id);

    @RequestLine("GET /findOrderByParam2")
    List<CloudModel> findOrderByParam2(@ModelAttribute("cloudModel") CloudModel orderModel);

    @RequestLine("GET /findOrderById2")
    List<CloudModel> findOrderById2(@Param("id") Long id);


}

