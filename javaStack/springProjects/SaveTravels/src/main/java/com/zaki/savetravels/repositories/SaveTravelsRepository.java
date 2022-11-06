package com.zaki.savetravels.repositories;
import com.zaki.savetravels.models.SaveTravels;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

// ...
@Repository
public interface SaveTravelsRepository extends CrudRepository<SaveTravels, Long> {
    // this method retrieves all the books from the database
    List<SaveTravels> findAll();
    // this method finds books with descriptions containing the search string
    List<SaveTravels> findByDescriptionContaining(String search);
    // this method counts how many titles contain a certain string
    Long countByExpenseContaining(String search);
    // this method deletes a book that starts with a specific title
    Long deleteByExpenseStartingWith(String search);
}

