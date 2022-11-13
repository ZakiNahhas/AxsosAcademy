package com.zaki.dojoninja.controllers;

import com.zaki.dojoninja.models.Dojo;
import com.zaki.dojoninja.models.Ninja;
import com.zaki.dojoninja.service.DojosNinjasService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class DojosNinjasController {
    private final DojosNinjasService dojosNinjasService;

    public DojosNinjasController(DojosNinjasService dojosNinjasService) {
        this.dojosNinjasService = dojosNinjasService;
    }

    @GetMapping("/dojos/new")
    public String newDojo(@ModelAttribute("dojos") Dojo dojo) {
        return "newDojo.jsp";
    }

    @PostMapping("/dojos/create")
    public String createDojo(@Valid @ModelAttribute("dojos") Dojo dojo, BindingResult result) {
        if (result.hasErrors()) {
            return "redirect:/dojos/new";
        }
        dojosNinjasService.createDojo(dojo);
        return "redirect:/dojos/new";
    }

    @GetMapping("/ninjas/new")
    public String newNinja(@ModelAttribute("ninjas") Ninja ninja, Model model) {
        model.addAttribute("dojos", dojosNinjasService.allDojos());
        return "newNinja.jsp";
    }

    @PostMapping("/ninjas/create")
    public String createNinja(@Valid @ModelAttribute("ninjas") Ninja ninja, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("dojos", dojosNinjasService.allDojos());
            return "newNinja.jsp";
        }
        dojosNinjasService.createNinja(ninja);
        return "redirect:/dojos/new";
    }

    @GetMapping("/dojos/{id}")
    public String showDojo(@PathVariable("id") Long id, Model model) {
        model.addAttribute("dojo", this.dojosNinjasService.getDojoWhereId(id));
        return "showDojo.jsp";
    }
}
