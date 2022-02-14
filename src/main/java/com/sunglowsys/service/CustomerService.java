package com.sunglowsys.service;

import com.sunglowsys.domain.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;


public interface CustomerService {

    Customer create(Customer customer);

    Customer update(Customer customer);

    Optional<Customer> findById(Long id);

    Page<Customer> findAll(Pageable pageable);

    void delete(Long id);

}
