package com.example.EurekaClient3;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("producer-client")
public interface Interface1 {

    @GetMapping(value = "/restService1")
    String getRestService();
}
