package com.codegym.muonsach.service.Impl;

import com.codegym.muonsach.model.Book;
import com.codegym.muonsach.repository.BookRepository;
import com.codegym.muonsach.service.MuonSachService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class MuonSachServiceImpl implements MuonSachService {

    @Autowired
    BookRepository bookRepository;

    @Override
    public Page<Book> getAll(Pageable pageable) {
        return bookRepository.findAll(pageable);
    }

    @Override
    public void save(Book book) {
        bookRepository.save(book);
    }

    @Override
    public void deleteById(Integer id) {
        bookRepository.deleteById(id);
    }

    @Override
    public Book getById(Integer id) {
        return bookRepository.getById(id);
    }

    @Override
    public Page<Book> searchByNameBook(String nameBook, Pageable pageable) {
        return bookRepository.getByNameBookContaining(nameBook, pageable);
    }
}
