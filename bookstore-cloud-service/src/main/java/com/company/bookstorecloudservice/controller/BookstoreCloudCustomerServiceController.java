package com.company.bookstorecloudservice.controller;

import com.company.bookstorecloudservice.util.feign.CustomerClient;
import com.company.customerservice.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RefreshScope
public class BookstoreCloudCustomerServiceController {

    @Autowired
    private final CustomerClient customerClient;

    BookstoreCloudCustomerServiceController(CustomerClient customerClient) {
        this.customerClient = customerClient;
    }

    //GET ALL CUSTOMERS
    @GetMapping("/customers")
    public List<Customer> getAllCustomers() {
        return customerClient.getAllCustomers();
    }

    //GET CUSTOMER BY ID
    @GetMapping("/customers/{id}")
    public Customer getCustomerById(@PathVariable Integer id) {
        return customerClient.getCustomerById(id);
    }

    //CREATE NEW CUSTOMER
    @PostMapping("/customers")
    public Customer createCustomer(@RequestBody Customer customer) {
        return customerClient.createCustomer(customer);
    }

    //UPDATE CUSTOMER BY ID
    @PutMapping("/customers/{id}")
    public void updateCustomer(@RequestBody Customer customer, @PathVariable Integer id) {
    customerClient.updateCustomer(customer, id);
    }

    //DELETE CUSTOMER BY ID
    @DeleteMapping("/customers/{id}")
    public void deleteCustomer(@PathVariable Integer id) {
    customerClient.deleteCustomer(id);
    }



}
