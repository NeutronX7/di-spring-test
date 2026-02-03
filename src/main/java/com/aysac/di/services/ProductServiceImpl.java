package com.aysac.di.services;

import com.aysac.di.models.Product;
import com.aysac.di.repostories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProductServiceImpl implements Productservice {

    @Autowired // provee una distancia
    private ProductRepository productRepositoryImpl;

    @Override
    public List<Product> findAll(){
        return productRepositoryImpl.findAll().stream().map(p -> {
            Double priceTax = p.getPrice() * 1.25d;
            //Product newProd = new Product(p.getId(), p.getName(), priceTax.longValue());
            Product newProd = (Product)p.clone();
            newProd.setPrice(priceTax.longValue());
            return newProd;
        }).collect(Collectors.toList());
    }

    @Override
    public Product findById(Long id){
        return productRepositoryImpl.findById(id);
    }

}
