package com.zaki.savetravels.controllers;
import com.zaki.savetravels.models.SaveTravels;
import com.zaki.savetravels.services.SaveTravelsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
public class SaveTravelsController {
    private final SaveTravelsService saveTravelsService;
    public SaveTravelsController(SaveTravelsService saveTravelsService) {
        this.saveTravelsService = saveTravelsService;
    }

    @RequestMapping("/expenses")
    public String showExpenses(@ModelAttribute("saveTravels")SaveTravels saveTravels) {
        return "show.jsp";
    }
    @RequestMapping(value = "/expenses", method = RequestMethod.POST)
    public String handleForm(@Valid @ModelAttribute("saveTravels") SaveTravels saveTravels, BindingResult result,Model model) {
        if(result.hasErrors()) {
            List<SaveTravels> saveTravels1 = saveTravelsService.allSaveTravels();
            model.addAttribute("saveTravels1", saveTravels1);
            return "show.jsp";
        } else {
            saveTravelsService.createSaveTravels(saveTravels);
            return "redirect:/expenses1";
        }
    }

    @RequestMapping("/expenses1")
    public String allExpenses(@ModelAttribute ("saveTravels") SaveTravels saveTravels, Model model) {
        List<SaveTravels> saveTravels1 = saveTravelsService.allSaveTravels();
        model.addAttribute("saveTravels1", saveTravels1);

        return "show.jsp";
    }
}
