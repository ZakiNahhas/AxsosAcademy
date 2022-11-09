package com.zaki.categoriesproducts.service;

import com.zaki.categoriesproducts.models.Category;
import com.zaki.categoriesproducts.models.Product;
import com.zaki.categoriesproducts.repositories.CategoriesRepository;
import com.zaki.categoriesproducts.repositories.ProductsRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriesProductsService {

    private final CategoriesRepository categoriesRepository;
    private final ProductsRepository   productsRepository;

    public CategoriesProductsService(CategoriesRepository categoriesRepository, ProductsRepository productsRepository) {
        this.productsRepository = productsRepository;
        this.categoriesRepository = categoriesRepository;
    }

    public List<Category> allCategories() {
        return categoriesRepository.findAll();
    }

    public List<Product> allProducts() {
        return productsRepository.findAll();
    }

    public Category createCategory(Category category) {
        return categoriesRepository.save(category);
    }

    public Product createProduct(Product product) {
        return productsRepository.save(product);
    }
    public Product updateProduct(Product product) {
        return productsRepository.save(product);
    }
    public Category updateCat(Category product) {
        return categoriesRepository.save(product);
    }

    public Category findCategory(Long id) {
        Optional<Category> optionalCategory = categoriesRepository.findById(id);
        if (optionalCategory.isPresent()) {
            return optionalCategory.get();
        } else {
            return null;
        }
    }

    public Product findProduct(Long id) {
        Optional<Product> optionalProduct = productsRepository.findById(id);
        if (optionalProduct.isPresent()) {
            return optionalProduct.get();
        } else {
            return null;
        }
    }
    public List<Category> getAssignedProducts(Product product){
        return categoriesRepository.findAllByProducts(product);
    }

    public List<Category> getUnassignedProducts(Product product){
        return categoriesRepository.findByProductsNotContains(product);
    }
    public List<Product> getAssignedCategories(Category category){
        return productsRepository.findAllByCategories(category);
    }

    public List<Product> getUnassignedCategories(Category category){
        return productsRepository.findByCategoriesNotContains(category);
    }

    public List<Category> findByCategory(Product product){
        return categoriesRepository.findAllByProducts(product);
    }

    public List<Product> findByProduct(Category category){
        return productsRepository.findAllByCategories(category);
    }
}