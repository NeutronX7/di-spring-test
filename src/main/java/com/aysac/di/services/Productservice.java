package com.aysac.di.services;

import com.aysac.di.models.Product;

import java.util.List;

public interface Productservice {
    List<Product> findAll();

    Product findById(Long id);
}
