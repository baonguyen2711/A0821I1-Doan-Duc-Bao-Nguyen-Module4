package com.codegym.democms.service;

import com.codegym.democms.model.Role;

import java.util.Optional;

public interface IRoleService extends IGeneralService<Role>{
    Optional<Role> findByName(String name);
}
