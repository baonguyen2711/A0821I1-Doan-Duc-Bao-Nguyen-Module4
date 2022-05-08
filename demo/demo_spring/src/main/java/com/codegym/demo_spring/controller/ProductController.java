package com.codegym.demo_spring.controller;

import com.codegym.demo_spring.model.Product;
import com.codegym.demo_spring.service.CategoryService;
import com.codegym.demo_spring.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.Optional;

@Controller
public class ProductController {

    @Autowired
    ProductService productService;
    @Autowired
    CategoryService categoryService;


    @GetMapping
    public ModelAndView getHome(Pageable pageable,
                                Model model) {
//        counter.increment();
        model.addAttribute("categories", categoryService.getAll());
        return new ModelAndView("home", "products", productService.getAll(pageable));
    }

    @GetMapping("/admin")
    public ModelAndView getList(@RequestParam("search_key") Optional<String> search_key,
                                @RequestParam(required = false, name = "search_by") String search_by
                                , Product product, Pageable pageable, Model model, @ModelAttribute("sort") String sort2,
                                @ModelAttribute("search") String search) {
        Page<Product> products = productService.getAll(pageable);

        boolean isASC = false;
        Sort sort = products.getSort();

        if (sort.isSorted()) {
            isASC = "asc".equalsIgnoreCase(sort.toString().split(":")[1].trim());
        }
        if (search_key.isPresent()) {
            model.addAttribute("search_key", search_key.get());
            model.addAttribute("search_by", search_by);
            switch (search_by) {
                case "name":
                    products = productService.searchByName(search_key.get(), pageable);
                    break;
                case "price":
                    products = productService.searchByPrice(Double.parseDouble(search_key.get()), pageable);
                    break;
                case "manufacturer":
                    products = productService.searchByManufacturer(search_key.get(), pageable);
                    break;
                case "category":
                    model.addAttribute("categories", categoryService.getAll());
                    products = productService.searchByCategory(search_key.get(), pageable);
                    break;
            }
        } else {
            model.addAttribute("categories", categoryService.getAll());
            products = productService.getAll(pageable);
        }
        model.addAttribute("reverseSortDir", isASC ? "desc" : "asc");
        model.addAttribute("products", products);
        model.addAttribute("product", product);
        model.addAttribute("sort", sort2);
        model.addAttribute("search", search);
        model.addAttribute("categories", categoryService.getAll());
        return new ModelAndView("/product/list", "products", products);
    }


    @GetMapping("/admin/create")
    public ModelAndView getCreat(Model model) {
        model.addAttribute("categories", categoryService.getAll());
        return new ModelAndView("/product/create", "products", new Product());
    }

    @PostMapping("/admin/create")
    public ModelAndView saveProduct(@Valid @ModelAttribute("products") Product products, BindingResult bindingResult, Model model) {
        if (bindingResult.hasFieldErrors()) {
            model.addAttribute("categories", categoryService.getAll());
            return new ModelAndView("/product/create");
        } else {
            productService.save(products);
            return new ModelAndView("redirect:/admin");
        }
    }

    @GetMapping("/admin/{id}/update")
    public ModelAndView getUpdate(@PathVariable int id, Model model) {
        model.addAttribute("categories", categoryService.getAll());
        return new ModelAndView("/product/update", "products", productService.getById(id));
    }

    @PostMapping("/admin/{id}/update")
    public ModelAndView updateProduct(@Valid @ModelAttribute("products") Product products, BindingResult bindingResult, Model model) {
        if (bindingResult.hasFieldErrors()) {
            model.addAttribute("categories", categoryService.getAll());
            return new ModelAndView("/product/update");
        } else {
            productService.save(products);
            return new ModelAndView("redirect:/admin");
        }
    }

    @GetMapping("/admin/{id}/delete")
    public ModelAndView getDelete(@PathVariable Integer id, Model model) {
        model.addAttribute("categories", categoryService.getAll());
        return new ModelAndView("/product/delete", "products", productService.getById(id));
    }

    @PostMapping("/admin/{id}/delete")
    public String deleteById(@ModelAttribute Product product, @PathVariable Integer id) {
        productService.deleteById(id);
        return "redirect:/admin";
    }

//    @GetMapping("/admin/search")
//    public ModelAndView searchByName(@RequestParam("search_key") Optional<String> search_key,
//                                     @RequestParam(required=false,name="search_by") String search_by, Model model,
//                                     Pageable pageable) {
//        Page<Product> products =productService.getAll(pageable);
//        if (search_key.isPresent()) {
//            model.addAttribute("search_key", search_key.get());
//            switch (search_by) {
//                case "name":
//                    products = productService.searchByName(search_key.get(), pageable);
//                    break;
//                case "price":
//                    products = productService.searchByPrice(Double.parseDouble(search_key.get()), pageable);
//                    break;
//                case "manufacturer":
//                    products = productService.searchByManufacturer(search_key.get(), pageable);
//                    break;
//                case "category":
//                    model.addAttribute("categories", categoryService.getAll());
//                    products = productService.searchByCategory(search_key.get(), pageable);
//                    break;
//            }
//        } else {
//            model.addAttribute("categories", categoryService.getAll());
//            products = productService.getAll(pageable);
//        }
//        model.addAttribute("categories", categoryService.getAll());
//        return new ModelAndView("/product/list", "products", products);
//    }
}

