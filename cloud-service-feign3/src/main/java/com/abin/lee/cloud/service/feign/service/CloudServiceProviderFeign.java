package com.abin.lee.cloud.service.feign.service;

import com.abin.lee.cloud.service.feign.configuration.CloudServiceProviderConfiguration;
import com.abin.lee.cloud.service.model.CloudModel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

/**
 * Created by abin on 2018/9/27.
 */
//首先使用serverId查找服务，如果找不到再使用url查找。
@FeignClient(value = "cloud-service-provider", url = "http://localhost:9455", configuration = CloudServiceProviderConfiguration.class)
public interface CloudServiceProviderFeign {

    @RequestMapping(value = "/provider/add", method = {RequestMethod.POST})
    Integer add(@RequestParam("param1") Integer param1, @RequestParam("param2") Integer param2);

    @RequestMapping(value = "/provider/find", method = {RequestMethod.POST})
    Map<String, String> find(@RequestParam("name") String name, @RequestParam("count") String count);

    @RequestMapping(value = "/provider/get", method = RequestMethod.GET)
    List<String> get(@RequestParam("id") Long id);

    @RequestMapping(value = "/provider/findOrderByParam", method = RequestMethod.GET)
    List<CloudModel> findOrderByParam(@RequestAttribute("cloudModel") CloudModel orderModel);

    @RequestMapping(value = "/provider/findOrderById", method = RequestMethod.GET)
    List<CloudModel> findOrderById(@RequestParam("id") Long id);





}

