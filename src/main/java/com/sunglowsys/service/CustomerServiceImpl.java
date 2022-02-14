package com.sunglowsys.service;

import com.sunglowsys.domain.Customer;
import com.sunglowsys.repository.CustomerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService{

    private final Logger log = LoggerFactory.getLogger(CustomerServiceImpl.class);

    private final CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }


    @Override
    public Customer create(Customer customer) {
        log.debug("Request to save Customer: {}",customer);
        return customerRepository.save(customer);
    }

    @Override
    public Customer update(Customer customer) {
        log.debug("Request to update Customer: {}",customer);
        return customerRepository.save(customer);
    }

    @Override
    public Optional<Customer> findById(Long id) {
        log.debug("Request to findById Customer: {}",id);
        return customerRepository.findById(id);
    }

    @Override
    public Page<Customer> findAll(Pageable pageable) {
        log.debug("Request to findAll Customer: {}",pageable.toString());
        return customerRepository.findAll(pageable);
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete Customer: {}",id);
        customerRepository.deleteById(id);

    }
}
