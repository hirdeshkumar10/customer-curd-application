package com.sunglowsys.resource;

import com.sunglowsys.domain.Customer;
import com.sunglowsys.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api")
public class CustomerResource {

    @Autowired
    private CustomerService customerService;

    @PostMapping("/customers")
    public ResponseEntity<?> create(@RequestBody Customer customer) {
        Customer customer1 = (Customer) customerService.create(customer);
        return ResponseEntity.ok().body("Customer is created successfully: " + customer1);
    }
    @GetMapping("/customers")
    public ResponseEntity<List<Customer>> findAllCustomer() {
        List<Customer> result = customerService.findAll();
        return ResponseEntity.ok().body(result);
    }
    @GetMapping("/customers/{id}")
    public ResponseEntity<Customer> findCustomer(@PathVariable("id") Long id) {
        Customer customer = customerService.findCustomerById(id);
        return ResponseEntity.ok().body(customer);
    }
    @PutMapping("/customers/{id}")
    public Customer update(@RequestBody Customer customer, @PathVariable("id") Long id) {
        return customerService.update(customer, id);
    }
    @DeleteMapping("/customers/{id}")
    public void delete(@PathVariable("id") Long id) {
        customerService.delete(id);
    }
}
