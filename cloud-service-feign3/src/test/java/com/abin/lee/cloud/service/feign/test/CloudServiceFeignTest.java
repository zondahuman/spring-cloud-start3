package com.abin.lee.cloud.service.feign.test;

import com.abin.lee.cloud.service.common.OkHttpClientUtil;
import com.google.common.collect.Maps;
import org.junit.Test;

import java.io.IOException;
import java.util.Map;

/**
 * Created by abin on 2018/7/12.
 */
public class CloudServiceFeignTest {
    private static final String httpUrl = "http://localhost:9444/";
    private static final String httpCreateUrl = "http://localhost:9444/add";
    private static final String httpFindUrl = "http://localhost:9444/find";

    public static void main(String[] args) throws IOException {


    }


    @Test
    public void testFeignAdd() throws IOException {
        Map<String, String> params = Maps.newHashMap();
        params.put("param1", "100");
        params.put("param2", "200");
        String result = OkHttpClientUtil.httpPost(httpCreateUrl, params);
        System.out.println("result=" + result);
    }

    @Test
    public void testFeignAddLoop() throws IOException {
        for (int i = 0; i < 100; i++) {
            Map<String, String> params = Maps.newHashMap();
            params.put("param1", "" + i);
            params.put("param2", "200");
            String result = OkHttpClientUtil.httpPost(httpCreateUrl, params);
            System.out.println("result=" + result);
        }

    }


    @Test
    public void testFeignFind() throws IOException {
        Map<String, String> params = Maps.newHashMap();
        params.put("name", "lee");
        params.put("count", "100");
        String result = OkHttpClientUtil.httpPost(httpFindUrl, params);
        System.out.println("result=" + result);
    }

    @Test
    public void testFeignFindLoop() throws IOException {
        for (int i = 0; i < 100; i++) {
            Map<String, String> params = Maps.newHashMap();
            params.put("name", "lee");
            params.put("count", "100");
            String result = OkHttpClientUtil.httpPost(httpFindUrl, params);
            System.out.println("result=" + result);
        }
    }


    @Test
    public void testFeignGet() throws IOException {
//        String result = OkHttpClientUtil.httpPost(httpUrl+"get?id=5", null);
        String result = OkHttpClientUtil.httpPost(httpUrl + "get/5", null);
        System.out.println("result=" + result);
    }

    @Test
    public void testFeignGetList() throws IOException {
//        String result = OkHttpClientUtil.httpPost(httpUrl+"get?id=5", null);
        String result = OkHttpClientUtil.httpPost(httpUrl + "getList/5", null);
        System.out.println("result=" + result);
    }

    @Test
    public void testFeignGetConf() throws IOException {
        String result = OkHttpClientUtil.httpGet(httpFindUrl);
        System.out.println("result=" + result);
    }


}
