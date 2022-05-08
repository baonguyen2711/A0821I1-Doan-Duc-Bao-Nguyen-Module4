package com.codegym.demo_spring.model;

import org.springframework.stereotype.Component;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

import javax.validation.constraints.Pattern;
import java.util.Date;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "Tên không được để trống")
//    @Pattern(regexp = "^[\\D]*",message = "Tên phải là Chữ")
    @Pattern(regexp = "^[A-ZÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĂĐĨŨƠƯĂẠẢẤẦẨẪẬẮẰẲẴẶẸẺẼỀỀỂỄỆỈỊỌỎỐỒỔỖỘỚỜỞỠỢỤỦỨỪỬỮỰỲỴÝỶỸ].*"
            ,message = "Tên phải viết hoa chữ đầu")
    @Pattern(regexp = "^\\S.*"
            ,message = "Tên không được có khoảng cách đầu dòng ")
    private String name;


    private double price;

    private String date;

    @NotBlank(message = "Tên không được để trống")
    @Pattern(regexp = "^[\\D]*",message = "Tên phải là Chữ")
    @Pattern(regexp = "^[A-ZÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĂĐĨŨƠƯĂẠẢẤẦẨẪẬẮẰẲẴẶẸẺẼỀỀỂỄỆỈỊỌỎỐỒỔỖỘỚỜỞỠỢỤỦỨỪỬỮỰỲỴÝỶỸ][\\D]*"
            ,message = "Tên phải viết hoa chữ đầu")
    @Pattern(regexp = "^\\S*[A-ZÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĂĐĨŨƠƯĂẠẢẤẦẨẪẬẮẰẲẴẶẸẺẼỀỀỂỄỆỈỊỌỎỐỒỔỖỘỚỜỞỠỢỤỦỨỪỬỮỰỲỴÝỶỸ][\\D]*"
            ,message = "Tên không được có khoảng cách đầu dòng ")
    private String manufacturer;

    @ManyToOne(targetEntity = Category.class)
    private Category category;

    public Product() {
    }

    public Product(Integer id, String name, Double price, String date, String manufacturer, Category category) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.date = date;
        this.manufacturer = manufacturer;
        this.category = category;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
