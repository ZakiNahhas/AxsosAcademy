package com.zaki.mail.controllers;

import com.zaki.mail.services.MailService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
@RequiredArgsConstructor
public class MailController {

    private final MailService mailService;

    @GetMapping("/")
    public String showShite() {
        return "content.jsp";
    }

    @GetMapping("/send-simple-mail")
    void sendMail() {
        mailService.sendSimpleMail();
    }
}
