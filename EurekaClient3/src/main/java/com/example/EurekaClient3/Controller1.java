package com.example.EurekaClient3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller1 {

    @Autowired
    Interface1 interface1;

    @GetMapping(value = "/client2")
    public String feignClient2()
    {
        System.out.println(interface1.getRestService());
        return "response from feign Client";
    }

}
