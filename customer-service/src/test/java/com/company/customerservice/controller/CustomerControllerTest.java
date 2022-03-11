package com.company.customerservice.controller;

import com.company.customerservice.model.Address;
import com.company.customerservice.model.Customer;
import com.company.customerservice.repository.CustomerRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(CustomerController.class)
public class CustomerControllerTest {

    @Autowired
    private MockMvc mockMvc;

    private ObjectMapper mapper = new ObjectMapper();

    @MockBean
    CustomerRepository customerRepository;

    Address outputAddress;

    Customer outputCustomer;
    String outputCustomerJson;
    List<Customer> customerList;
    String customerListJson;

    @Before
    public void setUp() throws Exception {

        outputAddress = new Address("216 Odio Road","","Kansas City","Kansas","42647");
        outputCustomer =  new Customer("Quinn Lawson","Allistair Delaney",
                "qallistairdelaney9967@outlook.com",outputAddress,"(449) 212-6453",false);
        outputCustomer.setId(1);
        outputCustomerJson = mapper.writeValueAsString(outputCustomer);

        customerList = new ArrayList<>();
        customerList.add(outputCustomer);
        customerListJson = mapper.writeValueAsString(customerList);

    }


    @Test
    public void shouldReturnNewCustomerOnPostRequest() throws Exception{
        Address address = new Address("216 Odio Road","","Kansas City","Kansas","42647");

        Customer customer1 = new Customer("Quinn Lawson","Allistair Delaney",
                "qallistairdelaney9967@outlook.com",address,"(449) 212-6453",false);
        customer1.setId(1);

        String inputJson = mapper.writeValueAsString(customer1);

        when(customerRepository.save(customer1)).thenReturn(customer1);

        mockMvc.perform(
                        post("/customers")
                                .content(inputJson)
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(content().json(outputCustomerJson));
    }

    @Test
    public void shouldReturnCustomerById() throws Exception {

        when(customerRepository.findById(outputCustomer.getId())).thenReturn(Optional.ofNullable(outputCustomer));

        mockMvc.perform(get("/customers/1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(outputCustomerJson));
    }

    @Test
    public void shouldReturnAllCustomer() throws Exception {

        when(customerRepository.findAll()).thenReturn(customerList);

        mockMvc.perform(get("/customers"))
                .andExpect(status().isOk())
                .andExpect(content().json(customerListJson));
    }

    @Test
    public void shouldUpdateCustomersOnPut() throws Exception {
        Address address = new Address("218 Odio Road","","Kansas City","Kansas","42647");

        Customer customer1 = new Customer("Quinn Lawson","Allistair Delaney",
                "qallistairdelaney9967@outlook.com",address,"(449) 212-6453",true);
        customer1.setId(1);

        String inputJson = mapper.writeValueAsString(customer1);

        mockMvc.perform(
                put("/customers/1")
                        .content(inputJson)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void shouldDeleteCustomerAndReturn200StatusCode() throws Exception {
        mockMvc.perform(delete("/customers/1"))
                .andDo(print())
                .andExpect(status().isOk());
    }
}