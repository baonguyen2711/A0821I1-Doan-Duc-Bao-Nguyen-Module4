package com.codegym.muonsach.controller;

import com.codegym.muonsach.model.Book;
import com.codegym.muonsach.model.Counter;
import com.codegym.muonsach.service.MuonSachService;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Random;

@Controller
@Aspect
@SessionAttributes("counter")
public class BookController {
    private Map<Integer, Book> bookMap = new HashMap<>();

    @Autowired
    MuonSachService muonSachService;

    @GetMapping
    public String getHome() {
        return "home";
    }

    @GetMapping("/login")
    public ModelAndView getLogin() {
        return new ModelAndView("login");
    }

    @PostMapping("/admin/index")
    public ModelAndView login(@ModelAttribute("counter") Counter counter,@RequestParam() String username, @RequestParam() String password, @PageableDefault(size = 5) Pageable pageable) {
        if ("admin".equals(username) && "123456".equals(password)) {
            counter.increment1();
            return new ModelAndView("/admin/index", "books", muonSachService.getAll(pageable));
        } else {
            String message = "Login fail";
            return new ModelAndView("login", "message", message);
        }

    }

    @GetMapping("/admin/index")
    public ModelAndView getIndex(@PageableDefault(size = 5) Pageable pageable) {

        return new ModelAndView("/admin/index", "books", muonSachService.getAll(pageable));
    }

    @GetMapping("/admin/search")
    public ModelAndView searchByTitle(@RequestParam Optional<String> search_key, Model model,
                                      @PageableDefault(size = 5) Pageable pageable) {
        Page<Book> books;
        if (search_key.isPresent()) {
            model.addAttribute("search_key", search_key.get());
            books = muonSachService.searchByNameBook(search_key.get(), pageable);
        } else {
            model.addAttribute("search_key", "");
            books = muonSachService.getAll(pageable);
        }
        return new ModelAndView("/admin/index", "books", books);
    }

    @GetMapping("/admin/create")
    public ModelAndView getCreate() {
        return new ModelAndView("/admin/create", "books", new Book());
    }

    @PostMapping("/admin/create")
    public String saveBlog(@ModelAttribute Book book) {
        if (book != null) {
            muonSachService.save(book);
        }
        return "redirect:/admin/index";
    }

    @GetMapping("/admin/{id}/update")
    public ModelAndView getUpdate(@PathVariable Integer id) {
        return new ModelAndView("/admin/edit", "books", muonSachService.getById(id));
    }

    @PostMapping("/admin/{id}/update")
    public String update(@ModelAttribute Book book) {
        if (book != null) {
            muonSachService.save(book);
        }
        return "redirect:/admin/index";
    }

    @GetMapping("/admin/{id}/delete")
    public ModelAndView getDelete(@PathVariable Integer id) {
        return new ModelAndView("/admin/delete", "books", muonSachService.getById(id));
    }

    @PostMapping("/admin/{id}/delete")
    public String deleteById(@ModelAttribute Book book, @PathVariable Integer id) {
        if (book != null) {
            muonSachService.deleteById(id);
        }
        return "redirect:/admin/index";
    }

    @ModelAttribute("counter")
    public Counter setUpCounter() {
        return new Counter();
    }

    @GetMapping("/customer/list")
    public ModelAndView getList(@PageableDefault(size = 5) Pageable pageable, @ModelAttribute("counter") Counter counter) {
        counter.increment();
        return new ModelAndView("/customer/list", "books", muonSachService.getAll(pageable));
    }

    @GetMapping("/customer/{id}/rentBook")
    public ModelAndView getRentBook(@PathVariable Integer id) {
        Book books = muonSachService.getById(id);
        Random rand = new Random();
        int random = rand.nextInt(99999 - 10000) + 10000;
        if (books == null || books.getAmount() == 0) {
            return new ModelAndView("/customer/errorRent");
        }
        ModelAndView modelAndView = new ModelAndView("/customer/rent", "books", books);
        modelAndView.addObject("random", random);
        return modelAndView;
    }

    @PostMapping("/rentBook/{random}")
    public String rentBook(@ModelAttribute Book book, @PathVariable int random) {
        bookMap.put(random, book);
        book.setAmount(book.getAmount() - 1);
        muonSachService.save(book);
        return "redirect:/customer/list";
    }

    @GetMapping("/customer/returnBook")
    public ModelAndView viewGiveBookBack() {
        return new ModelAndView("/customer/return", "random", new Integer("0"));
    }

    @PostMapping("/customer/returnBook")
    public String giveBookBack(@ModelAttribute Book book, @RequestParam int random, Model model) {
        String message = "";
        if (bookMap.containsKey(random)) {
            book = bookMap.get(random);
            bookMap.remove(random);
            book.setAmount(book.getAmount() + 1);
            muonSachService.save(book);
            model.addAttribute("books", book);
            return "/customer/info";
        } else {
            message = "The code is not correct";
            model.addAttribute("message", message);
            return "customer/return";
        }
    }


    @PostMapping("/customer/accept")
    public String accept() {
        return "redirect:/customer/list";
    }


    @GetMapping("/customer/search")
    public ModelAndView searchByNameBook(@RequestParam Optional<String> search_key, Model model,
                                         @PageableDefault(size = 5) Pageable pageable) {
        Page<Book> books;
        if (search_key.isPresent()) {
            model.addAttribute("search_key", search_key.get());
            books = muonSachService.searchByNameBook(search_key.get(), pageable);
        } else {
            model.addAttribute("search_key", "");
            books = muonSachService.getAll(pageable);
        }
        return new ModelAndView("/customer/list", "books", books);
    }

}

