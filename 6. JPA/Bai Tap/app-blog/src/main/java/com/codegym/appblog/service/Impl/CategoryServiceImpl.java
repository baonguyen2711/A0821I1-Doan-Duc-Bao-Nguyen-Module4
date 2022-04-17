package com.codegym.appblog.service.Impl;

import com.codegym.appblog.model.Blog;
import com.codegym.appblog.model.Category;
import com.codegym.appblog.repository.CategoryRepository;
import com.codegym.appblog.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
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
}
