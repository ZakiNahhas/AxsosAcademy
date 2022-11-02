package com.zaki.omikuji;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
public class Omikuji {
    @RequestMapping("/")
    public String home(){
        return "omikujiForm.jsp";
    }

@PostMapping( "/handle")
    public String handle(@RequestParam(value="number") String number,
                       @RequestParam(value="city") String city,
                       @RequestParam(value="realPerson") String realPerson,
                       @RequestParam(value="endeavor") String endeavor,
                       @RequestParam(value = "livingThing") String livingThing,
                       @RequestParam(value="smthNice")String smthNice,
                       HttpSession session) {
    session.setAttribute("number", number);
    session.setAttribute("city", city);
    session.setAttribute("realPerson", realPerson);
    session.setAttribute("endeavor", endeavor);
    session.setAttribute("livingThing", livingThing);
    session.setAttribute("smthNice", smthNice);

    return "redirect:/result";
}
    @RequestMapping("/result")
    public String result(){
        return "result.jsp";
    }
}
