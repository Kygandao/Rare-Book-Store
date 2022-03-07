package com.company.RareBookStore.controller;

import com.company.RareBookStore.model.Book;
import com.company.RareBookStore.model.Customer;
import com.company.RareBookStore.repository.BookRepository;
import com.company.RareBookStore.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class BookController {

    @Autowired
    private BookRepository bookRepository;
    private CustomerRepository customerRepository;

    //GET ALL BOOKS
    @GetMapping("/books")
    @ResponseStatus(HttpStatus.OK)
    public List<Book> getAllBooks() {

        return bookRepository.findAll();
    }

    //GET ALL CUSTOMERS
    @GetMapping("/customers")
    @ResponseStatus(HttpStatus.OK)
    public List<Customer> getAllCustomers() {

        return customerRepository.findAll();
    }

    //GET BOOK BY ID
    @GetMapping("/books/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Book getBookById(@PathVariable Integer id) {
        Optional<Book> returnVal = bookRepository.findById(id);
        return returnVal.orElse(null);
    }

    //GET CUSTOMER BY ID
    @GetMapping("/customers/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Customer getCustomerById(@PathVariable Integer id) {
        Optional<Customer> returnVal = customerRepository.findById(id);
        return returnVal.orElse(null);
    }

    //GET BOOKS BY AUTHOR
    @GetMapping("/books/{author}")
    @ResponseStatus(HttpStatus.OK)
    public List<Book> getBooksByAuthor(@PathVariable String author) {
        return bookRepository.findBookByAuthor(author);
    }

    //GET BOOKS BY GENRE
    @GetMapping("/books/{genre}")
    @ResponseStatus(HttpStatus.OK)
    public List<Book> getBooksByGenre(@PathVariable String genre) {
        return bookRepository.findBookByGenre(genre);
    }

    //GET BOOKS BY CONDITION
    @GetMapping("/books/{genre}")
    @ResponseStatus(HttpStatus.OK)
    public List<Book> getBooksByCondition(@PathVariable String bookCondition) {
        return bookRepository.findBookByCondition(bookCondition);
    }

    //CREATE NEW BOOK
    @PostMapping("/books")
    @ResponseStatus(HttpStatus.CREATED)
    public Book createBook(@RequestBody Book book) {
        bookRepository.save(book);
        return book;
    }

    //UPDATE BOOK BY ID
    @PutMapping("/books/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void updateBook(@RequestBody Book book, @PathVariable Integer id) {
        if(book.getBookId() != id) {
            throw new IllegalArgumentException("Entered ID does not match existing book ID");
        }
        bookRepository.save(book);
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

    //DELETE BOOK BY ID
    @DeleteMapping("/books/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteBook(@RequestBody Book book, @PathVariable Integer id) {
        bookRepository.deleteById(id);
    }

    //DELETE CUSTOMER BY ID
    @DeleteMapping("/customers/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteCustomer(@RequestBody Customer customer, @PathVariable Integer id) {
        customerRepository.deleteById(id);
    }
}


