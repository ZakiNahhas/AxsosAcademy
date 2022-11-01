package com.zaki.displaytime;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class DisplayTime {
    @RequestMapping("")
    public String index() {

        return "index.jsp";
    }
    @RequestMapping("/date")
    public String date() {

        return "date.jsp";
    }
    @RequestMapping("/time")
    public String time() {

        return "time.jsp";
    }
}
