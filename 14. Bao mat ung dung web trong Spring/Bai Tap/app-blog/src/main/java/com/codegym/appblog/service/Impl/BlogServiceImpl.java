package com.codegym.appblog.service.Impl;

import com.codegym.appblog.model.Blog;
import com.codegym.appblog.repository.BlogRepository;
import com.codegym.appblog.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BlogServiceImpl implements BlogService {
    @Autowired
    BlogRepository blogRepository;

    @Override
    public Page<Blog> getAll(Pageable pageable) {
        return blogRepository.findAll(pageable);
    }

    @Override
    public List<Blog> getAll() {
        return blogRepository.findAll();
    }

    @Override
    public Blog save(Blog blog) {
      return blogRepository.save(blog);
    }

    @Override
    public void deleteById(Integer id) {
        blogRepository.deleteById(id);
    }

    @Override
    public Blog getById(Integer id) {
        return blogRepository.getById(id);
    }


    @Override
    public Page<Blog> searchByTitle(String title, Pageable pageable) {
        return blogRepository.getAllByTitleContaining(title, pageable);
    }

    @Override
    public List<Blog> searchByTitle1(String title) {
        return blogRepository.getTitlesByTitle(title);
    }

    @Override
    public Iterable<Blog> findAll() {
        return blogRepository.findAll();
    }

    @Override
    public Optional<Blog> findById(Integer id) {
        return blogRepository.findById(id);
    }
}
