package com.zaki.categoriesproducts.models;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name="categories")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long          id;
    private String        name;
    @Column(updatable = false)
    private Date          createdAt;
    private Date          updatedAt;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "categories_products",
        joinColumns = @JoinColumn(name = "category_id"),
        inverseJoinColumns = @JoinColumn(name = "product_id")
    )
    private List<Product> products;
}
