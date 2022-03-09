package com.company.RareBookStore.controller;

import com.company.RareBookStore.model.Customer;
import com.company.RareBookStore.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CustomerController {

    @Autowired
    private CustomerRepository customerRepository;

    //GET ALL CUSTOMERS
    @GetMapping("/customers")
    @ResponseStatus(HttpStatus.OK)
    public List<Customer> getAllCustomers() {

        return customerRepository.findAll();
    }

    //GET CUSTOMER BY ID
    @GetMapping("/customers/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Customer getCustomerById(@PathVariable Integer id) {
        Optional<Customer> returnVal = customerRepository.findById(id);
        return returnVal.orElse(null);
    }

    //CREATE NEW CUSTOMER
    @PostMapping("/customers")
    @ResponseStatus(HttpStatus.CREATED)
    public Customer createCustomer(@RequestBody Customer customer) {
        customerRepository.save(customer);
        return customer;
    }

    //UPDATE CUSTOMER BY ID
    @PutMapping("/customers/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void updateCustomer(@RequestBody Customer customer, @PathVariable Integer id) {
        if(customer.getId() != id) {
            throw new IllegalArgumentException("Entered ID does not match existing customer ID");
        }
        customerRepository.save(customer);
    }

    //DELETE CUSTOMER BY ID
    @DeleteMapping("/customers/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteCustomer(@PathVariable Integer id) {
        customerRepository.deleteById(id);
    }
}



