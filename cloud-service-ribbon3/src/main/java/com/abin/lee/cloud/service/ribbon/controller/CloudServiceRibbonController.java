package com.abin.lee.cloud.service.ribbon.controller;

import com.abin.lee.cloud.service.common.JsonUtil;
import com.abin.lee.cloud.service.model.CloudModel;
import com.abin.lee.cloud.service.ribbon.service.CloudRibbonService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by abin on 2018/9/29.
 */
@RefreshScope // 使用该注解的类，会在接到SpringCloud配置中心配置刷新的时候，自动将新的配置更新到该类对应的字段中。
@Slf4j
@RestController
public class CloudServiceRibbonController {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Resource
    CloudRibbonService cloudRibbonService;


    @RequestMapping(value = "/add", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public Integer add(Integer param1, Integer param2) {
//        if (param1 % 2 == 1) {
//            throw new RuntimeException("a new exception");
//        }
        log.info("param1=" + param1 + ", param2=" + param2);
        Integer result = this.cloudRibbonService.add(param1, param2);
        logger.info(", result:" + result);
        return result;
    }


    @RequestMapping(value = "/find", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public Map<String, String> find(String name, String count) {
        log.info("name=" + name + ", count=" + count);
        Map<String, String> map = this.cloudRibbonService.find(name, count);
        logger.info(", map:" + map);
        return map;
    }


    @RequestMapping(value = "/get", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public Integer get(Long id) {
        log.info("id=" + id);
        Integer result = id.intValue() + 500;
        logger.info(", result:" + result);
        return result;
    }

    @RequestMapping(value = "/getList", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public List<Integer> getList(Long id) {
        log.info("id=" + id);
        List<Integer> list = new ArrayList<>();
        list.add(id.intValue() + 500);
        list.add(id.intValue() + 1000);
        logger.info(", result:" + JsonUtil.toJson(list));
        return list;
    }


    @RequestMapping(value = "/findOrderByParam", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    List<CloudModel> findOrderByParam(@ModelAttribute CloudModel cloudModel) {
        log.info("cloudModel=" + JsonUtil.toJson(cloudModel));
        Integer result = cloudModel.getId() + 500;
        logger.info(", result:" + result);
        List<CloudModel> list = new ArrayList<>();
        list.add(new CloudModel(1, "lee"));
        list.add(new CloudModel(2, "abin"));
        return list;
    }


    @RequestMapping(value = "/findOrderById", method = {RequestMethod.GET, RequestMethod.POST})
    List<CloudModel> findOrderById(Long id) {
        log.info("id=" + id);
        List<CloudModel> list = new ArrayList<>();
        list.add(new CloudModel(1, "lee"));
        list.add(new CloudModel(2, "abin"));
        log.info("list=" + JsonUtil.toJson(list));
        return list;
    }


}
