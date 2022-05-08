package com.codegym.demo_spring.service;

import com.codegym.demo_spring.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CategoryService {
    List<Category> getAll();
    Page<Category> searchByCategory(String category, Pageable pageable);
}
