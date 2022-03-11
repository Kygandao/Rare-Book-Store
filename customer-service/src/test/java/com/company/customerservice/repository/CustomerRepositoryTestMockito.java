package com.company.customerservice.repository;

import com.company.customerservice.model.Address;
import com.company.customerservice.model.Customer;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.mockito.Mockito.when;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class CustomerRepositoryTestMockito {

    @MockBean
    CustomerRepository customerRepository;

    Address outputAddress;

    Customer outputCustomer;
    List<Customer> customerList;

    @Before
    public void setUp() throws Exception {
        outputAddress = new Address("216 Odio Road","","Kansas City","Kansas","42647");
        outputCustomer =  new Customer("Quinn Lawson","Allistair Delaney",
                "qallistairdelaney9967@outlook.com",outputAddress,"(449) 212-6453",false);
        outputCustomer.setId(1);

        customerList = new ArrayList<>();
        customerList.add(outputCustomer);
    }

    @Test
    public void postABook() {

        Address address = new Address("216 Odio Road","","Kansas City","Kansas","42647");

        Customer customer1 = new Customer("Quinn Lawson","Allistair Delaney",
                "qallistairdelaney9967@outlook.com",address,"(449) 212-6453",false);
        customer1.setId(1);

        when(customerRepository.save(customer1)).thenReturn(customer1);

        assertEquals(customerList.size(),1);
    }


    @Test
    public void getAllBooks() {

        when(customerRepository.findAll()).thenReturn(customerList);

        assertEquals(customerList.size(),1);
    }

    @Test
    public void getBookById() {
        Address address = new Address("216 Odio Road","","Kansas City","Kansas","42647");

        Customer customer1 = new Customer("Quinn Lawson","Allistair Delaney",
                "qallistairdelaney9967@outlook.com",address,"(449) 212-6453",false);
        customer1.setId(1);

        when(customerRepository.findById(outputCustomer.getId())).thenReturn(Optional.ofNullable(outputCustomer));

        Optional<Customer> book2 = customerRepository.findById(outputCustomer.getId());
        assertEquals(book2.get(),customer1);

    }

    @Test
    public void updateBookById() {
        Address address = new Address("218 Odio Road","","Kansas City","Kansas","42647");

        Customer customer1 = new Customer("Quinn Lawson","Allistair Delaney",
                "qallistairdelaney9967@outlook.com",address,"(449) 212-6453",true);
        customer1.setId(1);

        when(customerRepository.save(customer1)).thenReturn(customer1);

        when(customerRepository.findById(outputCustomer.getId())).thenReturn(Optional.ofNullable(outputCustomer));

        boolean test = customer1.equals(outputCustomer);

        assertFalse(test);

    }

//    @Test
//    public void deleteBookById() {
//    }
}