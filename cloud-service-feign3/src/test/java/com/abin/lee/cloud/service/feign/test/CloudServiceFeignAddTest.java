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
    private static final String httpUrl = "http://localhost:9455/add";
    private static final String httpCreateUrl = "http://localhost:9455/add";

    private static final String httpConfUrl = "http://localhost:9455/getConf";

    //    private static final String httpCreateUrl = "http://localhost:9455/add";
    public static void main(String[] args) throws IOException {


    }

    @Test
    public void testZipkinSimple1() throws IOException {
        String result = OkHttpClientUtil.httpPost(httpUrl, null);
        System.out.println("result=" + result);
    }

    @Test
    public void testZipkinSimple2() throws IOException {
        String result = OkHttpClientUtil.httpGet(httpUrl);
        System.out.println("result=" + result);
    }

    @Test
    public void testZipkinCreate() throws IOException {
        Map<String, String> params = Maps.newHashMap();
        params.put("param1", "12345");
        params.put("param2", "67890");

        String result = OkHttpClientUtil.httpPost(httpCreateUrl, params);
        System.out.println("result=" + result);
    }


    @Test
    public void testGetConf() throws IOException {
        String result = OkHttpClientUtil.httpGet(httpConfUrl);
        System.out.println("result=" + result);
    }


}
