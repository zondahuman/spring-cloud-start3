package com.abin.lee.cloud.service.feign.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Created by abin on 2018/9/27.
 */
@FeignClient("COUPONS-RULE-SERVICE")
public interface CloudServiceFeign {

    @RequestMapping(value = "/category/find", method = RequestMethod.GET)
    List<String> findCategory(@RequestParam("category_id") long categoryId);

    @RequestMapping(value = "/consumerRuleKey/find", method = RequestMethod.GET)
    List<String> findConsumerRuleKey(@RequestParam("consumerRuleKey_id") long consumerRuleKeyId);

    @RequestMapping(value = "/consumerRule/find", method = RequestMethod.GET)
    List<String> findConsumerRule(@RequestParam("consumerRule_id") long consumerRuleId);

    @RequestMapping(value = "/rule/find", method = RequestMethod.GET)
    List<String> findRule(@RequestParam("rule_id") long ruleId);
}

