package cn.zm.netflix.feign.web.service;

import cn.zm.netflix.feign.web.service.impl.HystrixHandler;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("SERVICE-APP")
public interface FeignService {
    @GetMapping("/account/ribbon/service")
    String testFeign();
}