package com.company.RareBookStore.repository;

import com.company.RareBookStore.model.Address;
import com.company.RareBookStore.model.Customer;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CustomerRepositoryMockitoTest {


    @MockBean
    CustomerRepository customerRepository;

    Address inputAddress;
    Address outputAddress;

    Customer inputCustomer;
    Customer outputCustomer;
    List<Customer> customerList;

    @Before
    public void setUp() throws Exception {

        inputAddress = new Address("216 Odio Road","","Kansas City","Kansas","42647");
        inputCustomer = new Customer("Quinn Lawson","Allistair Delaney",
                "qallistairdelaney9967@outlook.com",inputAddress,"(449) 212-6453",false);
        outputAddress = new Address("216 Odio Road","","Kansas City","Kansas","42647");
        outputCustomer =  new Customer("Quinn Lawson","Allistair Delaney",
                "qallistairdelaney9967@outlook.com",outputAddress,"(449) 212-6453",false);
        outputCustomer.setId(1);
        customerList = new ArrayList<>();
        customerList.add(outputCustomer);

    }

    @Test
    public void findAllCustomers() {
        when(customerRepository.findAll()).thenReturn(customerList);

        assertEquals(1,customerList.size());
    }

    @Test
    public void saveFidOneCustomer() {

        when(customerRepository.save(inputCustomer)).thenReturn(outputCustomer);
        when(customerRepository.findById(outputCustomer.getId())).thenReturn(Optional.ofNullable(outputCustomer));

    }
}
