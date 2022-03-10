package com.company.bookstorecloudservice.controller;

import com.company.bookstorecloudservice.util.feign.BookInventoryClient;
import com.company.bookstorecloudservice.util.feign.CustomerClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.awt.print.Book;
import java.util.List;

@RestController
@RefreshScope
public class BookstoreCloudInventoryServiceController {



    @Autowired
    private final BookInventoryClient inventoryClient;

   BookstoreCloudInventoryServiceController(BookInventoryClient inventoryClient) {
       this.inventoryClient = inventoryClient;
   }

    @GetMapping("/books")
    public List<Book> getAllBooks() {
        return inventoryClient.getAllBooks();
    }

    //GET BOOK BY ID
    @GetMapping("/books/{id}")
    public Book getBookById(@PathVariable Integer id) {
       return inventoryClient.getBookById(id);
    }

    //GET BOOKS BY AUTHOR
    @GetMapping("/books/authors/{author}")
    public List<Book> getBooksByAuthor(@PathVariable String author) {
       return inventoryClient.getBooksByAuthor(author);
    }

    //GET BOOKS BY GENRE
    @GetMapping("/books/genre/{genre}")
    public List<Book> getBooksByGenre(@PathVariable String genre) {
       return inventoryClient.getBooksByGenre(genre);
    }

    //GET BOOKS BY CONDITION
    @GetMapping("/books/bookCondition/{bookCondition}")
    public List<Book> getBooksByCondition(@PathVariable String bookCondition) {
       return inventoryClient.getBooksByCondition(bookCondition);
    }

    //CREATE NEW BOOK
    @PostMapping("/books")
    public Book createBook(@RequestBody @Valid Book book) {
       return inventoryClient.createBook(book);
    }

    //UPDATE BOOK BY ID
    @PutMapping("/books/{id}")
    public void updateBook(@RequestBody Book book, @PathVariable Integer id) {
    }

    //DELETE BOOK BY ID
    @DeleteMapping("/books/{id}")
    public void deleteBook(@PathVariable Integer id) {
    }


}
