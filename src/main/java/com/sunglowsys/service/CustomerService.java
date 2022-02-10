package com.sunglowsys.service;

import com.sunglowsys.domain.Customer;

import java.util.List;


public interface CustomerService {

    Object create(Customer customer);

    Customer update(Customer customer, Long id);

    Customer findCustomerById(Long id);

    List<Customer> findAll();

    void delete(Long id);

}
