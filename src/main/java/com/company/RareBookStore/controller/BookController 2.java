package com.company.RareBookStore.controller;

import com.company.RareBookStore.model.Book;
import com.company.RareBookStore.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    //GET ALL BOOKS
    @GetMapping("/books")
    @ResponseStatus(HttpStatus.OK)
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    //GET BOOK BY ID
    @GetMapping("/book/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Book getBookById(@PathVariable Integer id) {
        Optional<Book> returnVal = bookRepository.findById(id);
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
    @GetMapping("/books/{bookCondition}")
    @ResponseStatus(HttpStatus.OK)
    public List<Book> getBooksByCondition(@PathVariable String bookCondition) {
        return bookRepository.findBookByBookCondition(bookCondition);
    }

    //CREATE NEW BOOK
    @PostMapping("/books")
    @ResponseStatus(HttpStatus.CREATED)
    public Book createBook(@RequestBody @Valid Book book) {
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

    //DELETE BOOK BY ID
    @DeleteMapping("/books/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteBook(@RequestBody Book book, @PathVariable Integer id) {
        bookRepository.deleteById(id);
    }

}


