package com.codegym.muonsach.service;

import com.codegym.muonsach.model.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface MuonSachService {
    Page<Book> getAll(Pageable pageable);

    void save(Book book);

    void deleteById(Integer id);

    Book getById(Integer id);

    Page<Book> searchByNameBook(String nameBook, Pageable pageable);

}
