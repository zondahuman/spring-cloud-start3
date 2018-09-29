package com.abin.lee.cloud.service.feign.service;

import com.abin.lee.cloud.service.feign.hystrix.CloudServiceProviderFeignHystrix;
import com.abin.lee.cloud.service.model.CloudModel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

/**
 * Created by abin on 2018/9/27.
 * feign客户客户端的时候，默认使用springmvc的注解@RequestMapping，method只能使用一个
 * 可以指定使用feign的注解@RequestLine
 */
//首先使用serverId查找服务，如果找不到再使用url查找。
@FeignClient(value = "cloud-service-provider", url = "http://localhost:9455", fallback = CloudServiceProviderFeignHystrix.class)
//@FeignClient(value = "cloud-service-provider", url = "http://localhost:9455", configuration = CloudServiceProviderConfiguration.class)
public interface CloudServiceProviderFeign {

    @RequestMapping(value = "/add", method = {RequestMethod.POST})
    Integer add(@RequestParam("param1") Integer param1, @RequestParam("param2") Integer param2);

    @RequestMapping(value = "/find", method = {RequestMethod.POST})
    Map<String, String> find(@RequestParam("name") String name, @RequestParam("count") String count);

    @RequestMapping(value = "/get", method = {RequestMethod.GET})
    Integer get(@RequestParam("id") Long id);

    @RequestMapping(value = "/getList", method = {RequestMethod.GET})
    List<Integer> getList(@RequestParam("id") Long id);


    @RequestMapping(value = "/findOrderByParam", method = {RequestMethod.POST})
    List<CloudModel> findOrderByParam(@ModelAttribute("cloudModel") CloudModel orderModel);

    @RequestMapping(value = "/findOrderById", method = {RequestMethod.GET})
    List<CloudModel> findOrderById(@RequestParam("id") Long id);


}

