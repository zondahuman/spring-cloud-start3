package com.abin.lee.cloud.service.feign.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * Created by abin on 2018/9/27.
 */
//首先使用serverId查找服务，如果找不到再使用url查找。
@FeignClient(value = "cloud-service-provider", url = "http://localhost:8781")
public interface CloudServiceFeign {

    @RequestMapping(value = "/add", method = {RequestMethod.GET, RequestMethod.POST})
    Integer add(Integer param1, Integer param2);

    @RequestMapping(value = "/getConf", method = {RequestMethod.GET, RequestMethod.POST})
    Map<String, String> getConf(String name, String count) ;

    @RequestMapping(value = "/category/find", method = RequestMethod.GET)
    List<String> findCategory(@RequestParam("category_id") long categoryId);

    @RequestMapping(value = "/consumerRuleKey/find", method = RequestMethod.GET)
    List<String> findConsumerRuleKey(@RequestParam("consumerRuleKey_id") long consumerRuleKeyId);

    @RequestMapping(value = "/consumerRule/find", method = RequestMethod.GET)
    List<String> findConsumerRule(@RequestParam("consumerRule_id") long consumerRuleId);

    @RequestMapping(value = "/rule/find", method = RequestMethod.GET)
    List<String> findRule(@RequestParam("rule_id") long ruleId);



}

