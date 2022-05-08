package com.codegym.phonemanagement.service;

import com.codegym.phonemanagement.model.SmartPhone;

import java.util.Optional;

public interface SmartPhoneService {
    Iterable<SmartPhone> findAll();

    Optional<SmartPhone> findById(Long id);

    SmartPhone save(SmartPhone smartPhone);

    void remove(Long id);
}
