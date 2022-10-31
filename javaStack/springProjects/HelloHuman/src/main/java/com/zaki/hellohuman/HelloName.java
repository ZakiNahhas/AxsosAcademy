package com.zaki.hellohuman;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class HelloName {
    @RequestMapping("")
    public String helloHuman1() {
        return "Hello Human";
    }

    @RequestMapping("/firstN")
    public String helloHuman2(@RequestParam(value = "name", required = false) String firstname) {
        return "Hello" + " " + firstname;
    }

    @RequestMapping("/firstAndLast")
    public String helloHuman3(@RequestParam(value = "name", required = false) String firstname,
                              @RequestParam(value = "lastname", required = false) String lastname) {
        return "Hello" + " " + firstname + " " + lastname;
    }

    @RequestMapping("/firstAndLoop")
    public String helloHuman4(@RequestParam(value = "name", required = false) String firstname,
                              @RequestParam(value = "lastname", required = false) String lastname,
                              @RequestParam(value = "times", required = false) int times) {
        String s = "";
        for (int i = 0; i < times; i++) {
            s+="Hello " + " " + firstname + " " + lastname;
        }
        return s;
    }
}
