package com.sunglowsys.resource;

import com.sunglowsys.domain.Customer;
import com.sunglowsys.service.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class CustomerResource {

    private final Logger log = LoggerFactory.getLogger(CustomerResource.class);

    private final CustomerService customerService;

    public CustomerResource(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping("/customers")
    public ResponseEntity<?> create(@RequestBody Customer customer) throws URISyntaxException {
        log.debug("Rest Request to save Customer: {}",customer);
        if (customer.getId() != null){
            throw new RuntimeException("Id should be null in save api calls");
        }
        Customer result =  customerService.create(customer);
        return ResponseEntity
                .created(new URI("/api/customers/"+result.getId()))
                .body(result);
    }
    @GetMapping("/customers")
    public ResponseEntity<List<Customer>> findAllCustomer(Pageable pageable) {
        log.debug("Rest Request to getAll Customers: {}",pageable.toString());
        Page<Customer> result = customerService.findAll(pageable);
        return ResponseEntity
                .ok()
                .body(result.getContent());
    }
    @GetMapping("/customers/{id}")
    public ResponseEntity<Customer> findCustomerById(@PathVariable Long id) {
        log.debug("Rest Request to findById Customer: {}",id);
        Optional<Customer>  result = customerService.findById(id);
        return ResponseEntity
                .ok()
                .body(result.get());
    }

    @PutMapping("/customers/{id}")
    public ResponseEntity<Customer> updateCustomer(@RequestBody Customer customer) {
        log.debug("Rest Request to update Customer: {}",customer);
        if (customer.getId() == null){
            throw new RuntimeException("Id should not be null in update api calls");
        }
        Customer result = customerService.update(customer);
        return ResponseEntity
                .ok()
                .body(result);
    }
    @DeleteMapping("/customers/{id}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable("id") Long id) {
        log.debug("Rest Request to delete Customer: {}",id);
        customerService.delete(id);
        return ResponseEntity
                .ok()
                .build();
    }
}
