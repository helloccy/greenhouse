package com.greenhouse.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Vera on 2019/1/22/0022.
 */
@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello(){
        return "hello world！";
    }
}
