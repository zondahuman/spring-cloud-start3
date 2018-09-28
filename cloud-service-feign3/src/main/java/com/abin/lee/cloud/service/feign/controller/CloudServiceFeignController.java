package com.abin.lee.cloud.service.feign.controller;

import com.abin.lee.cloud.service.feign.service.CloudServiceFeign;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

/**
 * Created by abin on 2018/9/27.
 */

@Slf4j
@RestController
public class CloudServiceFeignController {

    private final Logger logger = LoggerFactory.getLogger(getClass());
    @Resource
    CloudServiceFeign cloudServiceFeign;


    @RequestMapping(value = "/add", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public Integer add(Integer param1, Integer param2) {
        log.info("param1=" + param1 + ", param2=" + param2);
        Integer result = this.cloudServiceFeign.add(param1, param2);
        logger.info(", result:" + result);
        return result;
    }


    @RequestMapping(value = "/getConf", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public Map<String, String> getConf(String name, String count) {
        log.info("name=" + name + ", count=" + count);
        Map<String, String> map = this.cloudServiceFeign.getConf(name, count);
        return map;
    }


}
