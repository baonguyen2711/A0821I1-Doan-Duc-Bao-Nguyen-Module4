package com.codegym.democms.service.Impl;

import com.codegym.democms.model.Role;
import com.codegym.democms.repository.RoleRepository;
import com.codegym.democms.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class RoleServiceImpl implements IRoleService {
    @Autowired
    RoleRepository roleRepository;
    @Override
    public Iterable<Role> findAll() {
        return roleRepository.findAll();
    }

    @Override
    public Optional<Role> findById(Integer id) {
        return roleRepository.findById(id);
    }

    @Override
    public Role save(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public void remove(Integer id) {
        roleRepository.deleteById(id);
    }

    @Override
    public Optional<Role> findByName(String name) {
        return roleRepository.findByName(name);
    }
}
