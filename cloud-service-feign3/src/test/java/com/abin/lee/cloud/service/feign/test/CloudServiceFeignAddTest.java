package com.abin.lee.cloud.service.feign.test;

import com.abin.lee.cloud.service.common.OkHttpClientUtil;
import com.google.common.collect.Maps;
import org.junit.Test;

import java.io.IOException;
import java.util.Map;

/**
 * Created by abin on 2018/7/12.
 */
public class CloudServiceFeignAddTest {
    private static final String httpUrl = "http://localhost:9444/add";
    private static final String httpCreateUrl = "http://localhost:9444/add";

    private static final String httpConfUrl = "http://localhost:9444/getConf";

    //    private static final String httpCreateUrl = "http://localhost:9455/add";
    public static void main(String[] args) throws IOException {


    }

    @Test
    public void testZipkinSimple1() throws IOException {
        String result = OkHttpClientUtil.httpPost(httpUrl, null);
        System.out.println("result=" + result);
    }

    @Test
    public void testFeignGetConf() throws IOException {
        Map<String, String> params = Maps.newHashMap();
        params.put("name", "lee");
        params.put("count", "100");

        String result = OkHttpClientUtil.httpPost(httpConfUrl, params);
        System.out.println("result=" + result);
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
    public void testGetConf() throws IOException {
        String result = OkHttpClientUtil.httpGet(httpConfUrl);
        System.out.println("result=" + result);
    }


}
