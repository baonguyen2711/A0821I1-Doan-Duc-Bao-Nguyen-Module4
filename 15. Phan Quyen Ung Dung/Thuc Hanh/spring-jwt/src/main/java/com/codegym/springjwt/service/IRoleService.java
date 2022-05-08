package com.codegym.springjwt.service;


import com.codegym.springjwt.model.Role;

public interface IRoleService extends IGeneralService<Role> {
    Role findByName(String name);
}
