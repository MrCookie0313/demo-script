package com.example.demoscript;

import com.alibaba.fastjson.JSONObject;
import com.example.demoscript.client.WebApiClient;
import com.google.common.hash.BloomFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * @author cookie
 */
@SpringBootApplication 
@RestController
@EnableFeignClients
public class DemoScriptApplication {

    @Autowired
    @Qualifier("goodsIDBloom")
    BloomFilter<String> goodsIDBloom;
    @Autowired
    private WebApiClient webApiClient;
    public static void main(String[] args) {
        SpringApplication.run(DemoScriptApplication.class, args);
    }

    @PostMapping("test/scrip")
    public boolean test(@RequestBody List<Map<String, Object>> params) throws IOException {
        for (Map<String, Object> param : params) {
            String id = param.get("id").toString();
            Test01.run01(id);
        }
        return true;
    }

    @PostMapping("/api/goods/goods")
    public boolean test1(@RequestBody JSONObject params) {
        System.out.println("params = " + JSONObject.toJSONString(params));
        return true;
    }

    @PostMapping("/api/goods/parts")
    public boolean test2(@RequestBody JSONObject params) {
        System.out.println("params = " + JSONObject.toJSONString(params));
        return true;
    }

    @GetMapping("/fegin/test")
    public JSONObject test3() {
        String code = "QLCY0ROBOT01";
        return webApiClient.findByCode(code);
    }
}
