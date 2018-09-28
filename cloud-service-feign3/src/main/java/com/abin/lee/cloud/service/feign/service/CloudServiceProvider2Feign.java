package com.abin.lee.cloud.service.feign.service;

import com.abin.lee.cloud.service.feign.configuration.CloudServiceProvider2Configuration;
import com.abin.lee.cloud.service.model.CloudModel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * Created by abin on 2018/9/27.
 * https://www.jb51.net/article/133770.htm
 * https://blog.csdn.net/huaseven0527/article/details/80533983
 */
//首先使用serverId查找服务，如果找不到再使用url查找。
@FeignClient(value = "cloud-service-provider", url = "http://localhost:9455" )
//@FeignClient(value = "cloud-service-provider", url = "http://localhost:9455", configuration = CloudServiceProvider2Configuration.class)
public interface CloudServiceProvider2Feign {

    @RequestMapping(value = "/add2", method = {RequestMethod.POST})
    Integer add2(@RequestParam("param1") Integer param1, @RequestParam("param2") Integer param2);

    @RequestMapping(value = "/find2", method = {RequestMethod.POST})
    Map<String, String> find2(@RequestParam("name") String name, @RequestParam("count") String count);

    @RequestMapping(value = "/get2", method = {RequestMethod.GET})
    List<String> get2(@RequestParam("id") Long id);

    @RequestMapping(value = "/findOrderByParam2", method = {RequestMethod.GET})
    List<CloudModel> findOrderByParam2(@RequestAttribute("cloudModel") CloudModel orderModel);

    @RequestMapping(value = "/findOrderById2", method = {RequestMethod.GET})
    List<CloudModel> findOrderById2(@RequestParam("id") Long id);


}

