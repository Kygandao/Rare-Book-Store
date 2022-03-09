package com.company.RareBookStore.repository;

import com.company.RareBookStore.model.Address;
import com.company.RareBookStore.model.Customer;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class CustomerRepositoryTest {

    @Autowired
    CustomerRepository customerRepository;

    @Before
    public void setUp() throws Exception {

        customerRepository.deleteAll();
    }

    @Test
    public void addGetDeleteCustomer() {

        Address address = new Address("216 Odio Road","","Kansas City","Kansas","42647");

        Customer customer = new Customer("Quinn Lawson","Allistair Delaney",
                "qallistairdelaney9967@outlook.com",address,"(449) 212-6453",false);

        customer = customerRepository.save(customer);

        Optional<Customer> customer1 = customerRepository.findById(customer.getId());

        assertEquals(customer1.get(),customer);

        customerRepository.deleteById(customer.getId());

        customer1 = customerRepository.findById(customer.getId());

        assertFalse(customer1.isPresent());

    }

    @Test
    public void getAllCustomers() {

        Address address = new Address("216 Odio Road","","Kansas City","Kansas","42647");

        Customer customer1 = new Customer("Quinn Lawson","Allistair Delaney",
                "qallistairdelaney9967@outlook.com",address,"(449) 212-6453",false);

        customer1 = customerRepository.save(customer1);

        Customer customer2 = new Customer("Sersi Lawson","Allistair Delaney",
                "qallistairdelaney5496@outlook.com",address,"(449) 866-6453",true);

        customer2 = customerRepository.save(customer2);

        List<Customer> customerList = customerRepository.findAll();

        assertEquals(customerList.size(), 2);
    }

    @Test
    public void updateCustomer(){

        Address address = new Address("216 Odio Road","","Kansas City","Kansas","42647");

        Customer customer = new Customer("Quinn Lawson","Allistair Delaney",
                "qallistairdelaney9967@outlook.com",address,"(449) 212-6453",false);

        customer = customerRepository.save(customer);

        customer.setPhone("(460) 895-8956");
        address.setStreet1("218 Odio Road");
        customer.setVip(true);

        customerRepository.save(customer);

        Optional<Customer> customer1 = customerRepository.findById(customer.getId());
        assertEquals(customer1.get(),customer);
    }
}