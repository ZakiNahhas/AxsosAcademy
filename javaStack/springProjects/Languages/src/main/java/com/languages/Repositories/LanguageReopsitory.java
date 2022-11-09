package com.languages.Repositories;

import com.languages.Models.Language;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface LanguageReopsitory extends CrudRepository<Language,Long> {
    List<Language> findAll();
    List<Language> findByName(String search);
    Long countByNameContaining(String search);
    Long deleteByNameStartingWith(String search);
}
