package com.aysac.di.controllers;

import com.aysac.di.models.Product;
import com.aysac.di.services.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class SomeController {

    //private ProductService productService = new ProductService();

    @GetMapping
    public List<Product> list() {
        ProductService productService = new ProductService();
        return productService.findAll();
    }

    @GetMapping("/{id}")
    public Product show(@PathVariable Long id){
        ProductService productService = new ProductService();
        return productService.findById(id);
    }

}
