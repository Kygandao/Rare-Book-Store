package com.company.bookstorecloudservice.controller;

import com.company.bookstorecloudservice.util.feign.BookInventoryClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RefreshScope
public class BookstoreCloudInventoryServiceController {



    @Autowired
    private final BookInventoryClient inventoryClient;

   BookstoreCloudInventoryServiceController(BookInventoryClient inventoryClient) {
       this.inventoryClient = inventoryClient;
   }

   //GET ALL BOOKS
    @GetMapping("/books")
    public List getAllBooks() {
        return inventoryClient.getAllBooks();
    }

    //GET BOOK BY ID
    @GetMapping("/books/{id}")
    public Object getBookById(@PathVariable Integer id) {
        return inventoryClient.getBookById(id);
    }

    //GET BOOKS BY AUTHOR
    @GetMapping("/books/authors/{author}")
    public List getBooksByAuthor(@PathVariable String author) {
        return inventoryClient.getBooksByAuthor(author);
    }

    //GET BOOKS BY GENRE
    @GetMapping("/books/genre/{genre}")
    public List getBooksByGenre(@PathVariable String genre) {
        return inventoryClient.getBooksByGenre(genre);
    }

    //GET BOOKS BY CONDITION
    @GetMapping("/books/bookCondition/{bookCondition}")
    public List getBooksByCondition(@PathVariable String bookCondition) {
        return inventoryClient.getBooksByCondition(bookCondition);
    }

    //CREATE NEW BOOK
    @PostMapping("/books")
    public Object createBook(@RequestBody  Object book) {
        return inventoryClient.createBook(book);
    }

    //UPDATE BOOK BY ID
    @PutMapping("/books/{id}")
    public void updateBook(@RequestBody Object book, @PathVariable Integer id) {
        inventoryClient.updateBook(book, id);
    }

    //DELETE BOOK BY ID
    @DeleteMapping("/books/{id}")
    public void deleteBook(@PathVariable Integer id) {
        inventoryClient.deleteBook(id);
    }

}
