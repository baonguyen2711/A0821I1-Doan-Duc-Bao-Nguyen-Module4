package com.codegym.appblog.controller;


import com.codegym.appblog.model.Blog;
import com.codegym.appblog.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
public class BlogController {

    @Autowired
    BlogService blogService;

    @GetMapping("/")
    public ModelAndView getListBlog(@PageableDefault(size = 5) Pageable pageable) {
        return new ModelAndView("list", "blogs", blogService.getAll(pageable));
    }

    @GetMapping("/search")
    public ModelAndView searchByTitle(@RequestParam Optional<String> search_key, Model model,
                                      @PageableDefault(size = 5) Pageable pageable) {
        Page<Blog> blogs;
        if (search_key.isPresent()) {
            model.addAttribute("search_key", search_key.get());
            blogs = blogService.searchByTitle(search_key.get(), pageable);
        } else {
            model.addAttribute("search_key", "");
            blogs = blogService.getAll(pageable);
        }
        return new ModelAndView("list", "blogs", blogs);
    }

    @GetMapping("/create")
    public ModelAndView getCreate() {
        return new ModelAndView("create", "blogs", new Blog());
    }

    @PostMapping("/create")
    public String saveBlog(@ModelAttribute Blog blog) {
        if (blog != null) {
            blogService.save(blog);
        }
        return "redirect:/";
    }

    @GetMapping("/{id}/update")
    public ModelAndView getUpdate(@PathVariable int id) {
        return new ModelAndView("update", "blogs", blogService.getById(id));
    }

    @PostMapping("/{id}/update")
    public String update(@ModelAttribute Blog blog) {
        blogService.save(blog);
        return "redirect:/";
    }

    @GetMapping("/{id}/delete")
    public ModelAndView getDelete(@PathVariable int id) {
        return new ModelAndView("delete", "blogs", blogService.getById(id));
    }

    @PostMapping("/{id}/delete")
    public String delete(@PathVariable int id) {
        blogService.deleteById(id);
        return "redirect:/";
    }

    @GetMapping("/{id}/info")
    public ModelAndView getInfo(@PathVariable int id) {
        return new ModelAndView("info", "blogs", blogService.getById(id));
    }
}
