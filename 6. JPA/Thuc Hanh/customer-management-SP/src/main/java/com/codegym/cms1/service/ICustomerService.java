package com.codegym.cms1.service;

import com.codegym.cms1.model.Customer;

public interface ICustomerService {
    boolean insertWithStoredProcedure(Customer customer);
}
