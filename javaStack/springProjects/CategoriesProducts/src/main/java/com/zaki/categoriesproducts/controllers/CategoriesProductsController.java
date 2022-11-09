package com.zaki.categoriesproducts.controllers;

import com.zaki.categoriesproducts.models.Category;
import com.zaki.categoriesproducts.models.Product;
import com.zaki.categoriesproducts.service.CategoriesProductsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.List;

@Controller
public class CategoriesProductsController {

    private final CategoriesProductsService categoriesProductsService;

    public CategoriesProductsController(CategoriesProductsService categoriesProductsService) {
        this.categoriesProductsService = categoriesProductsService;
    }

    @RequestMapping("/")
    public String index(Model model) {
        List<Product> products = categoriesProductsService.allProducts();
        List<Category> categories = categoriesProductsService.allCategories();
        model.addAttribute("products", products);
        model.addAttribute("categories", categories);
        return "index.jsp";
    }

    @GetMapping("/category/new")
    public String newCategory(@ModelAttribute("categories") Category category) {
        return "createCategory.jsp";
    }

    @PostMapping("/category/create")
    public String createCategory(@Valid @ModelAttribute("categories") Category category, BindingResult result) {
        if (result.hasErrors()) {
            return "createCategory.jsp";
        }
        categoriesProductsService.createCategory(category);
        return "redirect:/";
    }

    @GetMapping("/products/new")
    public String newProduct(@ModelAttribute("products") Product product, Model model) {
        model.addAttribute("categories", categoriesProductsService.allCategories());
        return "createProduct.jsp";
    }

    @PostMapping("/products/create")
    public String createProduct(@Valid @ModelAttribute("products") Product product, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("categories", categoriesProductsService.allCategories());
            return "createProduct.jsp";
        }
        categoriesProductsService.createProduct(product);
        return "redirect:/";
    }

    @GetMapping("/products/{id}")
    public String showProduct(@PathVariable("id") Long id, Model model) {
        Product product = categoriesProductsService.findProduct(id);
        model.addAttribute("assignedCategories", categoriesProductsService.getAssignedProducts(product));
        model.addAttribute("unassignedCategories", categoriesProductsService.getUnassignedProducts(product));
        model.addAttribute("product", product);
        return "showProduct.jsp";
    }

    @PostMapping("/products/{id}")
    public String editProduct(@PathVariable("id") Long id, @RequestParam(value = "categoryId") Long catId, Model model) {
        Product product = categoriesProductsService.findProduct(id);
        Category category = categoriesProductsService.findCategory(catId);
        product.getCategories().add(category);
        categoriesProductsService.updateProduct(product);
        model.addAttribute("assignedCategories", categoriesProductsService.getAssignedProducts(product));
        model.addAttribute("unassignedCategories", categoriesProductsService.getUnassignedProducts(product));
        return "redirect:/products/" + id;
    }

    @GetMapping("/category/{id}")
    public String showCategory(@PathVariable("id") Long id, Model model) {
        Category category = categoriesProductsService.findCategory(id);
        model.addAttribute("assignedProducts", categoriesProductsService.getAssignedCategories(category));
        model.addAttribute("unassignedProducts", categoriesProductsService.getUnassignedCategories(category));
        model.addAttribute("category", category);
        return "showCategory.jsp";
    }

    @PostMapping("/category/{id}")
    public String editCategory(@PathVariable("id") Long id, @RequestParam(value = "productId") Long proId, Model model) {
        Product product = categoriesProductsService.findProduct(proId);
        Category category = categoriesProductsService.findCategory(id);
        category.getProducts().add(product);
        categoriesProductsService.updateCat(category);
        model.addAttribute("assignedProducts", categoriesProductsService.getAssignedCategories(category));
        model.addAttribute("unassignedCategories", categoriesProductsService.getUnassignedCategories(category));
        return "redirect:/category/" + id;
    }
}
