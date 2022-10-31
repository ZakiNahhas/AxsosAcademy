package com.zaki.controllerspractice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/greeting")
@SpringBootApplication
public class ControllerspracticeApplication {

    public static void main(String[] args) {
        SpringApplication.run(ControllerspracticeApplication.class, args);
    }
    @RequestMapping("/m/{track}/{module}/{lesson}")
    public String showLesson(@PathVariable("track") String track, @PathVariable("module") String module, @PathVariable("lesson") String lesson){
        return "Track: " + track + ", Module: " + module + ", Lesson: " + lesson;
    }
    @RequestMapping("")
    public String index(@RequestParam(value="q", required = false) String searchQuery) {
        return "You searched for: " + searchQuery;
    }
    @RequestMapping("/daikichi")
    public String daikichi() {
        return "Welcome!";
    }
    @RequestMapping("/world")
    public String world() {
        return "Welcome!";
    }
}
