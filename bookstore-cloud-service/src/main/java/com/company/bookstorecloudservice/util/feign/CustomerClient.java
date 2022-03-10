package com.company.bookstorecloudservice.util.feign;

import com.company.customerservice.model.Customer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "customer-service")
public interface CustomerClient {

    //GET ALL CUSTOMERS
    @GetMapping("/customers")
    public List<Customer> getAllCustomers();

    //GET CUSTOMER BY ID
    @GetMapping("/customers/{id}")
    public Customer getCustomerById(@PathVariable Integer id);

    //CREATE NEW CUSTOMER
    @PostMapping("/customers")
    public Customer createCustomer(@RequestBody Customer customer);

    //UPDATE CUSTOMER BY ID
    @PutMapping("/customers/{id}")
    public void updateCustomer(@RequestBody Customer customer, @PathVariable Integer id);

    //DELETE CUSTOMER BY ID
    @DeleteMapping("/customers/{id}")
    public void deleteCustomer(@PathVariable Integer id);


}
