package com.zaki.savetravels.controllers;
import com.zaki.savetravels.models.SaveTravels;
import com.zaki.savetravels.services.SaveTravelsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

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
    @DeleteMapping("/expenses1/{id}")
    public String destroy(@PathVariable("id") Long id) {
        saveTravelsService.deleteSaveTravels(id);
        return "redirect:/expenses1";
    }
    @GetMapping("/showExpenses/{id}")
    public String edit(@PathVariable("id") Long id, Model model) {
        SaveTravels saveTravels = saveTravelsService.findSaveTravels(id);
        model.addAttribute("saveTravels", saveTravels);
        return "edit.jsp";
    }

    @RequestMapping(value="/editExpenses/{id}", method = RequestMethod.PUT)
    public String  update(@PathVariable("id") Long id, @RequestParam(value="expense") String expense, @RequestParam(value="description") String desc,
                    @RequestParam(value="vendor") String vendor, @RequestParam(value="amount") Integer amount) {
        SaveTravels saveTravels = saveTravelsService.updateSaveTravels(id, expense, desc, vendor, amount);
        return "redirect:/expenses1";
    }
}
