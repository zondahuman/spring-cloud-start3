package com.abin.lee.cloud.service.feign.hystrix;

import com.abin.lee.cloud.service.feign.service.CloudServiceProvider2Feign;
import com.abin.lee.cloud.service.model.CloudModel;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

/**
 * Created by abin on 2018/9/29.
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
public class CloudServiceProvider2FeignHystrix implements CloudServiceProvider2Feign {

    @Override
    public Integer add2(@RequestParam("param1") Integer param1, @RequestParam("param2") Integer param2) {
        return -1;
    }

    @Override
    public Map<String, String> find2(@RequestParam("name") String name, @RequestParam("count") String count) {
        return null;
    }

    @Override
    public List<String> get2(@RequestParam("id") Long id) {
        return null;
    }

    @Override
    public List<CloudModel> findOrderByParam2(@ModelAttribute("cloudModel") CloudModel orderModel) {
        return null;
    }

    @Override
    public List<CloudModel> findOrderById2(@RequestParam("id") Long id) {
        return null;
    }


}
