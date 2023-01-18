package com.example.demoscript;

import com.alibaba.fastjson.JSON;
import okhttp3.*;

import java.io.IOException;
import java.util.HashMap;

/**
 * @Author: sunBing
 * @CreateTime: 2022-11-09  17:33
 * @Description: TODO
 * @Version: 1.0
 */
public class Test01 {
    public static void main(String[] args) throws IOException {
        String str="直销（境外）";
        if (str.contains("境外")){
            System.out.println("yes");
        }

    }

    public static void run01(String outgoingApplicationId) throws IOException {
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        MediaType mediaType = MediaType.parse("application/json;charset=UTF-8");
        HashMap<String, Object> params = new HashMap<>(4);
        params.put("code", "outgoingAbroad");
        params.put("serviceCode", "product");
        HashMap<Object, Object> map = new HashMap<>(4);
        map.put("outgoingApplicationId", outgoingApplicationId);
        params.put("testInputParametersMap", map);
        RequestBody body = RequestBody.create(mediaType, JSON.toJSONString(params));
        Request request = new Request.Builder()
                .url("http://121.43.167.226:8080/api/bizservice/method/service_test")
                .method("PUT", body)
                .addHeader("Accept", "application/json, text/plain, */*")
                .addHeader("Accept-Language", "zh-CN,zh;q=0.9")
                .addHeader("Authorization", "Bearer eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdWQiOlsiYXBpIl0sImNvcnBJZCI6bnVsbCwidXNlcl9pZCI6IjJjOTA4MDljODM1YTlmNTYwMTgzNWQ5ODNiZDM0NjFmIiwidXNlcl9uYW1lIjoiMjgzNDM1MDIxNzc0NTc4OCIsInNjb3BlIjpbInJlYWQiXSwibW9iaWxlIjpmYWxzZSwiaXNBZG1pbiI6dHJ1ZSwiZXhwIjoxNjY4MTA3ODE4LCJpc0FwcEFkbWluIjpmYWxzZSwiYXV0aG9yaXRpZXMiOlsiVVNFUiIsIkFVVEhfU1lTVEVNX01BTkFHRSJdLCJqdGkiOiIwMGI4MmU1Ny0xMWJiLTQ3NjUtYjMxNy0yMTVkMjVmMjY2MGYiLCJjbGllbnRfaWQiOiJhcGkifQ.tQrNRbiBywoEjCZ4BO0MNF4wqYOVLSHUyaZ0kpCg9JrGj5awO1k_RfvOqs9bOgH-CCzU22CXy3aitDWY2sB1bqX_iBsuJIbgsKebu4q33z_6X-CiF4MDJN7QbuN38VRItpp2emXpNjfpKMNCHxX21SoCLGQoSP8CIHceN8xo11HRWHiwkFejRqQjVMSQE3CXA82pgwKX8mmRfPgbZr05_uR7iDnC1djKbERZTpr_3SLTLjqZ-gWWSnOoYL5CKZWXg20K4f7NkF5o9gdIE_f3q6cvrf9gubzFl1KWitDHBLobhhx_kuoAbFaWbS8pF_qQwGoffRa84HXkEtuwdpTjwg")
                .addHeader("Connection", "keep-alive")
                .addHeader("Content-Type", "application/json;charset=UTF-8")
                .addHeader("Origin", "http://121.43.167.226")
                .addHeader("Referer", "http://121.43.167.226/")
                .addHeader("User-Agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/107.0.0.0 Safari/537.36")
                .build();
        Response response = client.newCall(request).execute();
        System.out.println("response = " + JSON.toJSONString(response));
    }
}
