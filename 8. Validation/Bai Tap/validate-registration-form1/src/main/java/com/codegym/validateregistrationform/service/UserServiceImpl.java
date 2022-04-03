package com.codegym.validateregistrationform.service;

import com.codegym.validateregistrationform.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements  UserService{
    UserService userService = new UserServiceImpl();
    @Override
    public List<User> findAll() {
        return userService.findAll();
    }
}
