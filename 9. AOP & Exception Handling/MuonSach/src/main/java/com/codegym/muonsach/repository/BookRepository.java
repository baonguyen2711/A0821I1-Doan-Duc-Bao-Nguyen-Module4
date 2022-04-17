package com.codegym.muonsach.repository;

import com.codegym.muonsach.model.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book,Integer> {
    Page<Book> getByNameBookContaining(String nameBook, Pageable pageable);
    Page<Book> findAll(Pageable pageable);

}
