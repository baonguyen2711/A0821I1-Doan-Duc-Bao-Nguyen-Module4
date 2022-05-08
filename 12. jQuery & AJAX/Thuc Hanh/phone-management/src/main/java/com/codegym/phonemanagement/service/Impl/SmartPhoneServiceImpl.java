package com.codegym.phonemanagement.service.Impl;

import com.codegym.phonemanagement.model.SmartPhone;
import com.codegym.phonemanagement.repository.SmartPhoneRepository;
import com.codegym.phonemanagement.service.SmartPhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SmartPhoneServiceImpl implements SmartPhoneService {
    @Autowired
    SmartPhoneRepository smartPhoneRepository;

    @Override
    public Iterable<SmartPhone> findAll() {
        return smartPhoneRepository.findAll();
    }

    @Override
    public Optional<SmartPhone> findById(Long id) {
        return smartPhoneRepository.findById(id);
    }

    @Override
    public SmartPhone save(SmartPhone smartPhone) {
        return smartPhoneRepository.save(smartPhone);
    }

    @Override
    public void remove(Long id) {
        smartPhoneRepository.deleteById(id);
    }
}
