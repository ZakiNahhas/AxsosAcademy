package com.languages.Services;

import com.languages.Models.Language;
import com.languages.Repositories.LanguageReopsitory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LanguageService {
    private final LanguageReopsitory languageReopsitory;

    public LanguageService(LanguageReopsitory languageReopsitory) {
        this.languageReopsitory = languageReopsitory;
    }

    public List<Language> allLanguages() {
        return languageReopsitory.findAll();
    }

    public Language createLanguage(Language a) {
        return languageReopsitory.save(a);
    }

    public Language findLanguage(Long id) {
        Optional<Language> optionalBook = languageReopsitory.findById(id);
        if (optionalBook.isPresent()) {
            return optionalBook.get();
        } else {
            return null;
        }
    }

    public Language updateLanguage(Long id, String name, String creator, double version) {
        Language language = languageReopsitory.findById(id).get();
        language.setName(name);
        language.setCreator(creator);
        language.setVersion(version);
        return languageReopsitory.save(language);
    }

    public Language updateLanguage(Language language) {
        return languageReopsitory.save(language);
    }

    public void deleteLanguage(Long id) {
        languageReopsitory.deleteById(id);
    }
}