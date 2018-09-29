package com.abin.lee.cloud.service.feign.controller;

import com.abin.lee.cloud.service.common.JsonUtil;
import com.abin.lee.cloud.service.feign.service.CloudServiceProvider2Feign;
import com.abin.lee.cloud.service.feign.service.CloudServiceProviderFeign;
import com.abin.lee.cloud.service.model.CloudModel;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * Created by abin on 2018/9/27.
 */
@RefreshScope // 使用该注解的类，会在接到SpringCloud配置中心配置刷新的时候，自动将新的配置更新到该类对应的字段中。
@Slf4j
@RestController
public class CloudServiceFeignController {

    private final Logger logger = LoggerFactory.getLogger(getClass());
    @Resource
    CloudServiceProviderFeign cloudServiceProviderFeign;
    @Resource
    CloudServiceProvider2Feign cloudServiceProvider2Feign;

    @RequestMapping(value = "/add", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public Integer add(Integer param1, Integer param2) {
        log.info("param1=" + param1 + ", param2=" + param2);
        Integer result = this.cloudServiceProviderFeign.add(param1, param2);
        logger.info(", result:" + result);
        return result;
    }

    @RequestMapping(value = "/find", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public Map<String, String> find(String name, String count) {
        log.info("name=" + name + ", count=" + count);
        Map<String, String> map = this.cloudServiceProviderFeign.find(name, count);
        log.info("map=" + map);
        return map;
    }

    @RequestMapping(value = "/get/{id}", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public Integer get(@PathVariable("id") Long id) {
        log.info("id=" + id);
        Integer result = this.cloudServiceProviderFeign.get(id);
        log.info("result=" + JsonUtil.toJson(result));
        return result;
    }

    @RequestMapping(value = "/getList/{id}", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public List<Integer> getList(@PathVariable("id") Long id) {
        log.info("id=" + id);
        List<Integer> result = this.cloudServiceProviderFeign.getList(id);
        log.info("result=" + JsonUtil.toJson(result));
        return result;
    }

    @RequestMapping(value = "/findOrderByParam", method = {RequestMethod.GET, RequestMethod.POST})
    List<CloudModel> findOrderByParam(@ModelAttribute("cloudModel") CloudModel orderModel){
        log.info("orderModel=" + JsonUtil.toJson(orderModel));
        List<CloudModel> result = this.cloudServiceProviderFeign.findOrderByParam(orderModel);
        log.info("result=" + JsonUtil.toJson(result));
        return result;
    }

    @RequestMapping(value = "/findOrderById", method = {RequestMethod.GET, RequestMethod.POST})
    List<CloudModel> findOrderById(@RequestParam("id") Long id){
        log.info("id=" + id);
        List<CloudModel> result = this.cloudServiceProviderFeign.findOrderById(id);
        log.info("result=" + JsonUtil.toJson(result));
        return result;
    }



    @RequestMapping(value = "/add2", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public Integer add2(Integer param1, Integer param2) {
        log.info("param1=" + param1 + ", param2=" + param2);
        Integer result = this.cloudServiceProvider2Feign.add2(param1, param2);
        logger.info(", result:" + result);
        return result;
    }

    @RequestMapping(value = "/find2", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public Map<String, String> find2(String name, String count) {
        log.info("name=" + name + ", count=" + count);
        Map<String, String> map = this.cloudServiceProvider2Feign.find2(name, count);
        log.info("map=" + map);
        return map;
    }


}
