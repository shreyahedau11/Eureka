package com.example.EurekaClient;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class controller1 {


    @GetMapping(value = "/restService1")
    public ResponseEntity restService1() {

        return ResponseEntity.ok("1st rest service Called");
    }

    @GetMapping(value = "/")
    public ResponseEntity eurekaClient() {

        return ResponseEntity.ok("Eureka Client application");
    }

    public ResponseEntity restService2() {

        return ResponseEntity.ok("2nd rest service Called");
    }
}
