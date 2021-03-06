package com.company.bookstorecloudservice.util.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@FeignClient(name = "book-inventory-service")
public interface BookInventoryClient {

    //GET ALL BOOKS
    @GetMapping("/books")
    public List getAllBooks();

    //GET BOOK BY ID
    @GetMapping("/books/{id}")
    public Object getBookById(@PathVariable Integer id);

    //GET BOOKS BY AUTHOR
    @GetMapping("/books/authors/{author}")
    public List getBooksByAuthor(@PathVariable String author);

    //GET BOOKS BY GENRE
    @GetMapping("/books/genre/{genre}")
    public List getBooksByGenre(@PathVariable String genre);

    //GET BOOKS BY CONDITION
    @GetMapping("/books/bookCondition/{bookCondition}")
    public List getBooksByCondition(@PathVariable String bookCondition);

    //CREATE NEW BOOK
    @PostMapping("/books")
    public Object createBook(@RequestBody Object book);

    //UPDATE BOOK BY ID
    @PutMapping("/books/{id}")
    public void updateBook(@RequestBody Object book, @PathVariable Integer id);

    //DELETE BOOK BY ID
    @DeleteMapping("/books/{id}")
    public void deleteBook(@PathVariable Integer id);

}
