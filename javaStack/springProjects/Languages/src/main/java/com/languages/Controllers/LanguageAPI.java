package com.languages.Controllers;

import com.languages.Models.Language;
import com.languages.Services.LanguageService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LanguageAPI {
    private final LanguageService languageService;

    public LanguageAPI(LanguageService languageService) {
        this.languageService = languageService;
    }
    @RequestMapping("/api/languages")
    public List<Language> index(){
        return languageService.allLanguages();
    }
    @RequestMapping(value="/api/languages", method= RequestMethod.POST)
    public Language create(@RequestParam(value="name") String name,
                           @RequestParam(value="creator") String creator,
                           @RequestParam(value="version") double version){
        Language language = new Language(name,creator,version);
        return languageService.createLanguage(language);
    }

}
