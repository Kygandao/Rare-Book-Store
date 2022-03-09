package com.company.bookstorecloudservice.util.feign;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.awt.print.Book;
import java.util.List;

@FeignClient(name = "book-inventory-service")
public interface BookInventoryClient {

    //GET ALL BOOKS
    @GetMapping("/books")
    public List<Book> getAllBooks();

    //GET BOOK BY ID
    @GetMapping("/book/{id}")
    public Book getBookById(@PathVariable Integer id);

    //GET BOOKS BY AUTHOR
    @GetMapping("/books/authors/{author}")
    public List<Book> getBooksByAuthor(@PathVariable String author);

    //GET BOOKS BY GENRE
    @GetMapping("/books/genre/{genre}")
    public List<Book> getBooksByGenre(@PathVariable String genre);

    //GET BOOKS BY CONDITION
    @GetMapping("/books/bookCondition/{bookCondition}")
    public List<Book> getBooksByCondition(@PathVariable String bookCondition);

    //CREATE NEW BOOK
    @PostMapping("/books")
    public Book createBook(@RequestBody @Valid Book book);

    //UPDATE BOOK BY ID
    @PutMapping("/book/{id}")
    public void updateBook(@RequestBody Book book, @PathVariable Integer id);

    //DELETE BOOK BY ID
    @DeleteMapping("/books/{id}")
    public void deleteBook(@PathVariable Integer id);

}
