package com.codegym.democms.repository;

import com.codegym.democms.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomerRepository extends JpaRepository<User,Integer> {
    Optional<User> findByEmail(String email);

}
