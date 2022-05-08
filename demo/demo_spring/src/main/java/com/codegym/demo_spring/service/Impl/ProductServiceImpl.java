package com.codegym.demo_spring.service.Impl;

import com.codegym.demo_spring.model.Product;
import com.codegym.demo_spring.repository.ProductRepository;
import com.codegym.demo_spring.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;

    @Override
    public Page<Product> getAll(Pageable pageable) {
        return productRepository.findAll(pageable);
    }

    @Override
    public Product save(Product product) {
        return productRepository.save(product);
    }

    @Override
    public void deleteById(Integer id) {
        productRepository.deleteById(id);
    }

    @Override
    public Product getById(Integer id) {
        return productRepository.getById(id);
    }

    @Override
    public Page<Product> searchByName(String name, Pageable pageable) {
        return productRepository.getAllByNameContaining(name, pageable);
    }

    @Override
    public Page<Product> searchByPrice(double price, Pageable pageable) {
        return productRepository.getAllByPriceGreaterThanEqual(price, pageable);
    }

    @Override
    public Page<Product> searchByManufacturer(String manufacturer, Pageable pageable) {
        return productRepository.getAllByManufacturerContaining(manufacturer, pageable);
    }

    @Override
    public Page<Product> searchByCategory(String nameCategory,Pageable pageable) {
        return productRepository.getAllByCategoryNameContaining(nameCategory,pageable);
    }

//    @Override
//    public Page<Product> searchByAnyColumn(String name, Double price, String manufacturer, Pageable pageable) {
//        return productRepository.searchByAnyColumn(name, price, manufacturer,pageable);
//    }

}
