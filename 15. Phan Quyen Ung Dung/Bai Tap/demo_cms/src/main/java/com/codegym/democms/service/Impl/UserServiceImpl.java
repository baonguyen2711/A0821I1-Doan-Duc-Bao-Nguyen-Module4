package com.codegym.democms.service.Impl;

import com.codegym.democms.model.User;
import com.codegym.democms.repository.UserRepository;
import com.codegym.democms.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class UserServiceImpl implements IUserService {
    @Autowired
    UserRepository userRepository;

    @Override
    public Iterable<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> findById(Integer id) {
        return userRepository.findById(id);
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public void remove(Integer id) {
        userRepository.deleteById(id);
    }

}
