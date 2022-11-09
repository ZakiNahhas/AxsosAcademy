package com.zaki.categoriesproducts.repositories;
import com.zaki.categoriesproducts.models.Category;
import com.zaki.categoriesproducts.models.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductsRepository extends CrudRepository<Product, Long> {
    List<Product> findAll();
    Optional<Product> findById(Long id);
    List<Product> findAllByCategories(Category category);
    List<Product> findByCategoriesNotContains(Category category);
}
