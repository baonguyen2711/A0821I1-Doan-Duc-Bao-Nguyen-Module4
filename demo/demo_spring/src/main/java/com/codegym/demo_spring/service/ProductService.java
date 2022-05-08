package com.codegym.demo_spring.service;

import com.codegym.demo_spring.model.Category;
import com.codegym.demo_spring.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProductService {
    Page<Product> getAll(Pageable pageable);
    Product save(Product product);
    void deleteById(Integer id);
    Product getById(Integer id);
    Page<Product> searchByName(String name,Pageable pageable);
    Page<Product> searchByPrice(double price, Pageable pageable);
    Page<Product> searchByManufacturer(String manufacturer,Pageable pageable);
    Page<Product> searchByCategory(String nameCategory, Pageable pageable);

//    Page<Product> searchByAnyColumn(String name,Double price,String manufacturer,Pageable pageable);
}
