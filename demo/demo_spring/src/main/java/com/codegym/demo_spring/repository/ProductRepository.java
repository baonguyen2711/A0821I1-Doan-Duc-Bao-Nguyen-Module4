package com.codegym.demo_spring.repository;

import com.codegym.demo_spring.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ProductRepository extends JpaRepository<Product,Integer> {
    Page<Product> getAllByNameContaining(String name,Pageable pageable);
    Page<Product> getAllByPriceGreaterThanEqual(double price, Pageable pageable);
    Page<Product> getAllByManufacturerContaining(String manufacturer,Pageable pageable);
    Page<Product> getAllByCategoryNameContaining(String nameCategory,Pageable pageable);

    Page<Product> findAll(Pageable pageable);
//    @Query("select o from Product o where o.name like ?1 and o.price=?2 and o.manufacturer like ?3")
//    Page<Product> searchByAnyColumn(String name,Double price,String manufacturer,Pageable pageable);
}
