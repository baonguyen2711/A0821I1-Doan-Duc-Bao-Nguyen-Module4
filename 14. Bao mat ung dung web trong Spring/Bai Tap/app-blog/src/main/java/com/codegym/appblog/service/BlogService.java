package com.codegym.appblog.service;


import com.codegym.appblog.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface BlogService {
    Page<Blog> getAll(Pageable pageable);
    List<Blog> getAll();
    Blog save(Blog blog);
    void deleteById(Integer id);
    Blog getById(Integer id);
    Page<Blog> searchByTitle(String title, Pageable pageable);

    List<Blog> searchByTitle1(String title);
    Iterable<Blog> findAll();

    Optional<Blog> findById(Integer id);
}
