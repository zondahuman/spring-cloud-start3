package com.abin.lee.cloud.service.feign.hystrix;

import com.abin.lee.cloud.service.feign.service.CloudServiceProviderFeign;
import com.abin.lee.cloud.service.model.CloudModel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

/**
 * Created by abin on 2018/9/27.
 * feign客户客户端的时候，默认使用springmvc的注解@RequestMapping，method只能使用一个
 * 可以指定使用feign的注解@RequestLine
 * 断路器打开的要求

 10秒内连续20个同样的请求
 失败率过50%
 断路器关闭

 休眠期5分钟
 5分钟后尝试请求，请求成功则关闭
 */
//HelloClient类去Spring容器中寻找HelloClientFallBack
//所以添加注解Component
@Component
public class CloudServiceProviderFeignHystrix implements CloudServiceProviderFeign {

    @Override
    public Integer add(@RequestParam("param1") Integer param1, @RequestParam("param2") Integer param2) {
        return -1;
    }

    @Override
    public Map<String, String> find(@RequestParam("name") String name, @RequestParam("count") String count) {
        return null;
    }

    @Override
    public Integer get(@RequestParam("id") Long id) {
        return -1;
    }

    @Override
    public List<Integer> getList(@RequestParam("id") Long id) {
        return null;
    }

    @Override
    public List<CloudModel> findOrderByParam(@RequestAttribute("cloudModel") CloudModel orderModel) {
        return null;
    }

    @Override
    public List<CloudModel> findOrderById(@RequestParam("id") Long id) {
        return null;
    }
}

