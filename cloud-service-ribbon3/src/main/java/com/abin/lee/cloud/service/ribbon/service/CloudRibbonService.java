package com.abin.lee.cloud.service.ribbon.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by abin on 2018/9/29.
 * https://blog.csdn.net/sunhuiliang85/article/details/76718810
 */
@Service
public class CloudRibbonService {
    private Logger logger = LoggerFactory.getLogger(CloudRibbonService.class);
    @Autowired
    RestTemplate restTemplate;


    public Integer add(Integer param1, Integer param2) {
        MultiValueMap<String, Object> request = new LinkedMultiValueMap<>();
        request.add("param1", param1);
        request.add("param2", param2);
        Integer result = restTemplate.postForObject("http://cloud-service-provider/add", request, Integer.class);
        return result;
    }

    public Map<String, String> find(String name, String count) {
        MultiValueMap<String, Object> request = new LinkedMultiValueMap<>();
        request.add("name", name);
        request.add("count", count);

        Map<String, String> response = restTemplate.postForObject("http://cloud-service-provider/find", request, Map.class);

        return response;
    }

}
