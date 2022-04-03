package com.codegym.appblog.service;


import com.codegym.appblog.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BlogService {
    Page<Blog> getAll(Pageable pageable);
    void save(Blog blog);
    void deleteById(Integer id);
    Blog getById(Integer id);
    Page<Blog> searchByTitle(String title, Pageable pageable);
}
