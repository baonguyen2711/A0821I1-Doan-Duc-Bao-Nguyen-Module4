package com.codegym.appblog.repository;


import com.codegym.appblog.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlogRepository extends JpaRepository<Blog,Integer> {
    Page<Blog> getAllByTitleContaining(String title, Pageable pageable);
    Page<Blog> findAll(Pageable pageable);
}
