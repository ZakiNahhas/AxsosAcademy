package com.zaki.categoriesproducts.models;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long           id;
    private String         name;
    private String         description;
    private float          price;
    @Column(updatable = false)
    private Date           createdAt;
    private Date           updatedAt;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "categories_products",
        joinColumns = @JoinColumn(name = "product_id"),
        inverseJoinColumns = @JoinColumn(name = "category_id")
    )
    private List<Category> categories;

    public Product() {

    }
}

