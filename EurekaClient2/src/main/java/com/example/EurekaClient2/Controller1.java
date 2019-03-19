package com.example.EurekaClient2;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class Controller1 {

    @Autowired
    private DiscoveryClient discoveryClient;

    @GetMapping(value = "/client2")
    public String client2()
    {

        List<ServiceInstance> instances=discoveryClient.getInstances("producer-client");
        ServiceInstance serviceInstance=instances.get(0);
        System.out.println(instances);
        String baseUrl=serviceInstance.getUri().toString();

        baseUrl=baseUrl+"/restService1";
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response=null;
        try{
            response=restTemplate.exchange(baseUrl,
                    HttpMethod.GET, null,String.class);
        }catch (Exception ex)
        {
            System.out.println(ex);
        }
        System.out.println(response.getBody());
        return "response from client 2";
    }
}
