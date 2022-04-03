package com.codegym.service.Impl;

import com.codegym.model.Product;
import com.codegym.service.ProductService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductServiceImpl implements ProductService {
    private static final Map<Integer, Product> products;

    static {

        products = new HashMap<>();
        products.put(1, new Product(1, "Iphone 11", "15000000", "New","Apple"));
        products.put(2, new Product(2, "Iphone 11 Pro MaX", "18000000", "New","Apple"));
        products.put(3, new Product(3, "Note 10 Plus", "10000000", "Second Hand","Samsung"));
        products.put(4, new Product(4, "Vivo Neo 3", "9000000", "New","Vivo"));
        products.put(5, new Product(5, "Reno 7", "9000000", "New","Oppo"));
        products.put(6, new Product(6, "A52", "7000000", "Secon Hand","Samsung"));
    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(products.values());
    }

    @Override
    public void save(Product product) {
        products.put(product.getId(), product);
    }

    @Override
    public Product findById(int id) {
        return products.get(id);
    }

    @Override
    public void update(int id, Product product) {
        products.put(id, product);

    }

    @Override
    public void remove(int id) {
        products.remove(id);
    }
}
