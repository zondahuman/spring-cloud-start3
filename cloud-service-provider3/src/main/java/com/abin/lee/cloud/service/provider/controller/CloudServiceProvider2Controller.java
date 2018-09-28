package com.abin.lee.cloud.service.provider.controller;

import com.abin.lee.cloud.service.common.JsonUtil;
import com.abin.lee.cloud.service.model.CloudModel;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//import org.springframework.cloud.context.config.annotation.RefreshScope;

/**
 * 创建“服务提供方”
 * 下面我们创建提供服务的客户端，并向服务注册中心注册自己。
 * https://www.cnblogs.com/ityouknow/p/6906917.html
 */
@RefreshScope // 使用该注解的类，会在接到SpringCloud配置中心配置刷新的时候，自动将新的配置更新到该类对应的字段中。
@Slf4j
@RestController
public class CloudServiceProvider2Controller {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Resource
    DiscoveryClient discoveryClient;


    @RequestMapping(value = "/add2", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public Integer add2(Integer param1, Integer param2) {
        log.info("param1=" + param1 + ", param2=" + param2);
        Integer result = param1 + param2;
        logger.info(", result:" + result);
        return result;
    }


    @RequestMapping(value = "/find2", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public Map<String, String> find2(String name, String count) {
        Map<String, String> map = new HashMap<>();
        String finName = "hi," + name;
        String finCount = "count is : " + count;
        log.info("finName=" + finName + ", finCount=" + finCount);
        map.put("finName", finName);
        map.put("finCount", finCount);
        return map;
    }


    @RequestMapping(value = "/get2", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public Integer get2(Long id) {
        log.info("id=" + id);
        Integer result = id.intValue() + 500;
        logger.info(", result:" + result);
        return result;
    }

    @RequestMapping(value = "/findOrderByParam2", method = RequestMethod.GET)
    @ResponseBody
    List<CloudModel> findOrderByParam2(@RequestAttribute("cloudModel") CloudModel cloudModel) {
        log.info("cloudModel=" + JsonUtil.toJson(cloudModel));
        Integer result = cloudModel.getId() + 500;
        logger.info(", result:" + result);
        List<CloudModel> list = new ArrayList<>();
        list.add(new CloudModel(1, "lee"));
        list.add(new CloudModel(2, "abin"));
        return list;
    }


    @RequestMapping(value = "/findOrderById2", method = RequestMethod.GET)
    List<CloudModel> findOrderById2(@RequestParam("id") Long id) {
        log.info("id=" + id);
        List<CloudModel> list = new ArrayList<>();
        list.add(new CloudModel(1, "lee"));
        list.add(new CloudModel(2, "abin"));
        log.info("list=" + JsonUtil.toJson(list));
        return list;
    }




}
