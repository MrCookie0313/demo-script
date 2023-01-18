package com.example.demoscript.client;

import com.alibaba.fastjson.JSONObject;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Author: sunBing
 * @CreateTime: 2022-12-20  16:33
 * @Description: TODO
 * @Version: 1.0
 */
@FeignClient(value = "web-api",url ="127.0.0.1:8080")
public interface WebApiClient {

    @GetMapping("api/crm/project_list/detail_by_code")
    JSONObject findByCode(@RequestParam(required = true, name = "projectCode") String code);
}
