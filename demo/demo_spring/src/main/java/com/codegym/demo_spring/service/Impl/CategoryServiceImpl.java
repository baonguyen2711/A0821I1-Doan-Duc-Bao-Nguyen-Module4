package com.codegym.demo_spring.service.Impl;

import com.codegym.demo_spring.model.Category;
import com.codegym.demo_spring.repository.CategoryRepository;
import com.codegym.demo_spring.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    @Override
    public List<Category> getAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Page<Category> searchByCategory(String category, Pageable pageable) {
        return categoryRepository.getAllByNameContaining(category,pageable);
    }
}
