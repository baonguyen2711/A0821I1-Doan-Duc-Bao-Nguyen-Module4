package com.codegym.cms1.repository;

import com.codegym.cms1.model.Customer;

public interface ICustomerRepository {
    boolean insertWithStoredProcedure(Customer customer);
}
