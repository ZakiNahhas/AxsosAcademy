package com.zaki.ninjagold;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Random;

@Controller
public class NinjaGold {
    @RequestMapping("")

    public String home(HttpSession session) {
        if (session.getAttribute("money") != null) {
            session.setAttribute("money", 0);
            session.setAttribute("activities", new ArrayList<String>());
        }
        return "gold.jsp";
    }
    @RequestMapping(value = "/processMoney", method = RequestMethod.POST)
    public String process(HttpSession session) {
        Random randomNum = new Random();
        if ("money".equals("farm")) {
            randomNum.nextInt(10 + 11);
            ArrayList<String> activities = (ArrayList<String>)session.getAttribute("activities");
            activities.add("You entered a farm and earned " + randomNum);
        } else if ("money".equals("cave")) {
            randomNum.nextInt(10+11);
        } else if ("money".equals("house")) {
            randomNum.nextInt(10+11);
        } else if("money".equals("quest")){
            int rando = randomNum.nextInt(50+50) -50;
            }

        return "redirect:/";
    }
    @RequestMapping("/reset")
    public String reset(HttpSession session) {
        session.invalidate();
        return "gold.jsp";
    }
}
