package com.zaki.secondproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@SpringBootApplication
public class secondprojectApplication {

    public static void main(String[] args) {
        SpringApplication.run(secondprojectApplication.class, args);

    }
    @RequestMapping("/")
    // 3. Method that maps to the request route above
    public String hello() {
        return "Hello World!";
    }
    @RequestMapping("/new_route")
    // 3. Method that maps to the request route above
    public String who() {
        return "Who let the dogs out?!";
    }

}

