package com.codegym.appblog.controller;


import com.codegym.appblog.model.Blog;
import com.codegym.appblog.repository.BlogRepository;
import com.codegym.appblog.service.BlogService;
import com.codegym.appblog.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Controller
public class BlogController {

    @Autowired
    BlogService blogService;
    @Autowired
    CategoryService categoryService;

    @Autowired
    BlogRepository blogRepository;


    @GetMapping("/")
    public ModelAndView index() {
        return new ModelAndView("home");
    }
    @GetMapping("/admin")
    public ModelAndView admin(@PageableDefault(size = 5) Pageable pageable,Model model) {
        model.addAttribute("categories",categoryService.getAll());
        return new ModelAndView("/admin/list","blogs",blogService.getAll(pageable));
    }

    @GetMapping("/user")
    public ModelAndView getUserList(@PageableDefault(size = 5) Pageable pageable,
                                    Model model) {
//        counter.increment();
        model.addAttribute("categories",categoryService.getAll());
        return new ModelAndView("/user/list2", "blogs", blogService.getAll(pageable));
    }
    @GetMapping("/admin/search")
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
        return new ModelAndView("/admin/list", "blogs", blogs);
    }
    @GetMapping("/user/search")
    public ModelAndView searchByTitle2(@RequestParam Optional<String> search_key, Model model,
                                      @PageableDefault(size = 5) Pageable pageable) {
        Page<Blog> blogs;
        if (search_key.isPresent()) {
            model.addAttribute("search_key", search_key.get());
            blogs = blogService.searchByTitle(search_key.get(), pageable);
        } else {
            model.addAttribute("search_key", "");
            blogs = blogService.getAll(pageable);
        }
        return new ModelAndView("/user/list2", "blogs", blogs);
    }

    @GetMapping("/admin/create")
    public ModelAndView getCreate(Model model) {
        model.addAttribute("categories", categoryService.getAll());
        return new ModelAndView("/admin/create", "blogs", new Blog());
    }

    @PostMapping("/admin/create")
    public String saveBlog(@ModelAttribute Blog blog) {
        if (blog != null) {
            blogService.save(blog);
        }
        return "redirect:/admin";
    }

    @GetMapping("/admin/{id}/update")
    public ModelAndView getUpdate(@PathVariable int id, Model model) {
        model.addAttribute("categories", categoryService.getAll());
        return new ModelAndView("/admin/update", "blogs", blogService.getById(id));
    }

    @PostMapping("/admin/{id}/update")
    public String update(@ModelAttribute Blog blog) {
        blogService.save(blog);
        return "redirect:/admin";
    }

    @GetMapping("/admin/{id}/delete")
    public ModelAndView getDelete(@PathVariable Integer id, Model model) {
        model.addAttribute("categories", categoryService.getAll());
        return new ModelAndView("/admin/delete", "blogs", blogService.getById(id));
    }

    @PostMapping("/admin/{id}/delete")
    public String deleteById(@ModelAttribute Blog blog, @PathVariable Integer id) {
        System.out.println(id);
        if (blog != null) {
            blogService.deleteById(id);
        }
        return "redirect:/admin";
    }

    @GetMapping("/admin/{id}/info")
    public ModelAndView getInfo(@PathVariable int id, Model model) {
        model.addAttribute("categories", categoryService.getAll());
        return new ModelAndView("/admin/info", "blogs", blogService.getById(id));
    }

    @GetMapping("/user/{id}/info")
    public ModelAndView getInfo1(@PathVariable int id, Model model) {
        model.addAttribute("categories", categoryService.getAll());
        return new ModelAndView("/user/info2", "blogs", blogService.getById(id));
    }

    @GetMapping("/api/blogs")
    public ResponseEntity<Iterable<Blog>> findAllCustomer() {
        List<Blog> blogs = (List<Blog>) blogService.findAll();
        if (blogs.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogs, HttpStatus.OK);
    }

    @GetMapping("/api/blogs/{id}")
    public ResponseEntity<Blog> findCustomerById(@PathVariable Integer id) {
        Optional<Blog> blogOptional = blogService.findById(id);
        if (!blogOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(blogOptional.get(), HttpStatus.OK);
    }

    @PostMapping("/api/blogs")
    public ResponseEntity<Blog> saveCustomer(@RequestBody Blog blog) {
        return new ResponseEntity<>(blogService.save(blog), HttpStatus.CREATED);
    }

    @PutMapping("/api/blogs/{id}")
    public ResponseEntity<Blog> updateCustomer(@PathVariable Integer id, @RequestBody Blog blog) {
        Optional<Blog> blogOptional = blogService.findById(id);
        if (!blogOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        blog.setId(blogOptional.get().getId());
        return new ResponseEntity<>(blogService.save(blog), HttpStatus.OK);
    }

    @DeleteMapping("/api/blogs/{id}")
    public ResponseEntity<Blog> deleteCustomer(@PathVariable Integer id) {
        Optional<Blog> blogOptional = blogService.findById(id);
        if (!blogOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        blogService.deleteById(id);
        return new ResponseEntity<>(blogOptional.get(), HttpStatus.NO_CONTENT);
    }

//    @PostMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
//    @ResponseBody
//    public List<Blog> getListSearch(@RequestBody Optional<String> search, Model model) {
//        List<Blog> blogs;
//        if (search.isPresent()) {
//            model.addAttribute("search", search.get());
//            blogs = blogService.searchByTitle1(search.get());
//        } else {
//            model.addAttribute("search", "");
//           blogs = blogService.getAll();
//        }
//        return blogs;
//    }
}
