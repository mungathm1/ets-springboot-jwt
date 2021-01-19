package com.midhun.employeetracking.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @RequestMapping("/testrun")
    public String testRestApi() {
        return "Hello Buddy!!";
    }
}
