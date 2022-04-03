package com.codegym.controller;

import com.codegym.model.Product;
import com.codegym.service.ProductService;
import com.codegym.service.Impl.ProductServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class ProductController {
    private final ProductService productService = new ProductServiceImpl();

    @GetMapping
    public String getHome(Model model) {

        List<Product> productList = productService.findAll();
        model.addAttribute("product", productList);
        return "index";
    }

    @GetMapping("/product")
    public String index(Model model) {

        List<Product> productList = productService.findAll();
        model.addAttribute("product", productList);
        return "index";
    }

    @GetMapping("/product/create")
    public String create(Model model) {
        model.addAttribute("product", new Product());
        return "create";
    }

    @PostMapping("/product/save")
    public String save(Product product,RedirectAttributes redirect) {
        product.setId((int) (Math.random() * 10000));
        productService.save(product);
        redirect.addFlashAttribute("success", "Add product successfully!");
        return "redirect:/product";
    }

    @GetMapping("/product/{id}/edit")
    public String edit(@PathVariable int id, Model model) {
        model.addAttribute("product", productService.findById(id));
        return "edit";
    }

    @PostMapping("/product/update")
    public String update(Product product, RedirectAttributes redirect) {
        productService.update(product.getId(), product);
        redirect.addFlashAttribute("success", "Update product successfully!");
        return "redirect:/product";
    }

    @GetMapping("/product/{id}/delete")
    public String delete(@PathVariable int id, Model model) {
        model.addAttribute("product", productService.findById(id));
        return "delete";
    }

    @PostMapping("/product/delete")
    public String delete(Product customer, RedirectAttributes redirect) {
        productService.remove(customer.getId());
        redirect.addFlashAttribute("success", "Removed product successfully!");
        return "redirect:/product";
    }

    @GetMapping("/product/{id}/view")
    public String view(@PathVariable int id, Model model) {
        model.addAttribute("product", productService.findById(id));
        return "view";
    }
}
