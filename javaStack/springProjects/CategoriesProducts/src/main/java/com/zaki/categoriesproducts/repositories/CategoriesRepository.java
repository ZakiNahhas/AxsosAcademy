package com.zaki.categoriesproducts.repositories;

import com.zaki.categoriesproducts.models.Category;
import com.zaki.categoriesproducts.models.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CategoriesRepository extends CrudRepository<Category, Long> {
    List<Category> findAll();
    Optional<Category> findById(Long id);
    List<Category> findAllByProducts(Product product);
    List<Category> findByProductsNotContains(Product product);
}
