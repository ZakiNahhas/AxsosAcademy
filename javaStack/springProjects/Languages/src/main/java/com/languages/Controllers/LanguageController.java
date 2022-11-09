package com.languages.Controllers;

import com.languages.Models.Language;
import com.languages.Services.LanguageService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
@Controller
public class LanguageController {
    private final LanguageService languageService;

    public LanguageController(LanguageService languageService) {
        this.languageService = languageService;
    }
    @GetMapping("/languages")
    public String showAll(Model model){
        List<Language> language= languageService.allLanguages();
        model.addAttribute("language",language);
        return "index.jsp";

    }

    @PostMapping("/languages")
    public String create(@Valid @ModelAttribute("language") Language language, BindingResult result, Model model) {
        if (result.hasErrors()) {
            List<Language> Language = languageService.allLanguages();
            model.addAttribute("language", Language);
            return "index.jsp";
        } else {
            languageService.createLanguage(language);
            return "redirect:/languages";
        }
    }

        @GetMapping("/languages/{id}")
    public String show(@PathVariable("id")Long id,Model model){
        Language language=languageService.findLanguage(id);
        model.addAttribute("language",language);
        return "language.jsp";
    }

    @GetMapping("/languages/{id}/edit")
    public String edit(@PathVariable("id") Long id, Model model) {
        Language language = languageService.findLanguage(id);
        model.addAttribute("language", language);
        return "edit.jsp";
    }
    @PutMapping("languages/{id}")
    public String update(@Valid @ModelAttribute("languages") Language language, BindingResult result, @PathVariable("id") Long id) {
        if (result.hasErrors()) {
            return "edit.jsp";
        } else {
            languageService.updateLanguage(language);
            return "redirect:/languages";
        }
    }
    @DeleteMapping("/languages/{id}")
    public String destory(@PathVariable("id")Long id){
        languageService.deleteLanguage(id);
        return "redirect:/languages";
    }

}
