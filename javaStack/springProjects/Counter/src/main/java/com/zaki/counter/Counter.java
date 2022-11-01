package com.zaki.counter;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class Counter {
    @RequestMapping("/showCounter")
    public String home() {
        return "index.jsp";
    }

    @RequestMapping("/counter")
        public String index(HttpSession session){
            if (session.getAttribute("count") == null) {
                session.setAttribute("count", 1);
            }
            else {
                int count = (int)session.getAttribute("count");
                count++;
                session.setAttribute("count", count);
            }
        return "home.jsp";
    }
}
