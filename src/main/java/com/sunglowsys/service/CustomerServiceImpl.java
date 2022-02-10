package com.sunglowsys.service;

import com.sunglowsys.domain.Customer;
import com.sunglowsys.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService{

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Customer create(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public Customer update(Customer customer, Long id) {

        Customer customer1 = customerRepository.findById(id).get();
        
        if(customer.getFirstName() != null ){
            customer1.setFirstName(customer.getFirstName());
        }
        if(customer.getLastName() != null ){
            customer1.setLastName(customer.getLastName());
        }
        if(customer.getEmail() != null ){
            customer1.setEmail(customer.getEmail());
        }
        if(customer.getMobile() != null ){
            customer1.setMobile(customer.getMobile());
        }
        if(customer.getGender() != null ){
            customer1.setGender(customer.getGender());
        }
        return customerRepository.save(customer1);
    }
    @Override
    public Customer findCustomerById(Long id) {
        return customerRepository.findById(id).get();

    }

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public void delete(Long id) {
        customerRepository.deleteById(id);
        System.out.println("deleted:"+id);
    }
}
