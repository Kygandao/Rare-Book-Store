package com.company.bookinventoryservice.controller;

import com.company.bookinventoryservice.model.Book;
import com.company.bookinventoryservice.repository.BookRepository;
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
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(BookController.class)
public class BookControllerTest {

    @Autowired
    private MockMvc mockMvc;

    private ObjectMapper mapper = new ObjectMapper();

    @MockBean
    BookRepository bookRepository;

    Book outputBook;
    String outputBookJson;
    List<Book> bookList;
    String bookListJson;

    @Before
    public void setUp() throws Exception {

        outputBook =  new Book("Drinking At The Shadows","Shelby T. Rivers","Western","1924",
                "1st","Hardcover","Fine",589.60);
        outputBook.setId(1);
        outputBookJson = mapper.writeValueAsString(outputBook);

       bookList = new ArrayList<>();
       bookList.add(outputBook);
       bookListJson = mapper.writeValueAsString(bookList);

    }


    @Test
    public void shouldReturnNewBookOnPostRequest() throws Exception{

        Book book1 = new Book("Drinking At The Shadows","Shelby T. Rivers","Western","1924",
                "1st","Hardcover","Fine",589.60);
        book1.setId(1);

        String inputJson = mapper.writeValueAsString(book1);

        when(bookRepository.save(book1)).thenReturn(book1);

        mockMvc.perform(
                        post("/books")
                                .content(inputJson)
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(content().json(outputBookJson));
    }

    @Test
    public void shouldReturnBookById() throws Exception {

        when(bookRepository.findById(outputBook.getId())).thenReturn(Optional.ofNullable(outputBook));

        mockMvc.perform(get("/books/1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(outputBookJson));
    }

    @Test
    public void shouldReturnAllBooks() throws Exception {

        when(bookRepository.findAll()).thenReturn(bookList);

        mockMvc.perform(get("/books"))
                .andExpect(status().isOk())
                .andExpect(content().json(bookListJson));
    }

    @Test
    public void shouldUpdateBookOnPut() throws Exception {
        Book book1 = new Book("Drinking At The Shadows","Shelby T. Rivers","Western","1924",
                "1st","Hardcover","Fine",589.60);
        book1.setId(1);

        String inputJson = mapper.writeValueAsString(book1);

        mockMvc.perform(
                        put("/books/1")
                                .content(inputJson)
                                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void shouldDeleteBookAndReturn200StatusCode() throws Exception {
        mockMvc.perform(delete("/books/1"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void shouldReturnBooksByAuthor() throws Exception {
        Book book1 = new Book("Drinking At The Shadows","Shelby T. Rivers","Western","1924",
                "1st","Hardcover","Fine",589.60);
        book1.setId(1);

        when(bookRepository.save(book1)).thenReturn(book1);

        Book book2 = new Book("Hurt By History","Shelby T. Rivers","Non-fiction","1931",
                "1st","Hardcover","Near-Fine",986.98);
        book2.setId(2);

        when(bookRepository.save(book2)).thenReturn(book2);

        List<Book> bookList2 = new ArrayList<>();
        bookList2.add(book1);
        bookList2.add(book2);
        String bookListJson2 = mapper.writeValueAsString(bookList2);

        when(bookRepository.findBookByAuthor(book1.getAuthor())).thenReturn(bookList2);

        mockMvc.perform(get("/books/authors/Shelby T. Rivers"))
                .andExpect(status().isOk())
                .andExpect(content().json(bookListJson2));
    }

    @Test
    public void shouldReturnBooksByGenre() throws Exception {
        Book book1 = new Book("Drinking At The Shadows","Shelby T. Rivers","Western","1924",
                "1st","Hardcover","Fine",589.60);
        book1.setId(1);

        when(bookRepository.save(book1)).thenReturn(book1);

        Book book2 = new Book("Hurt By History","Lars J. Singleton","Non-fiction","1931",
                "1st","Hardcover","Near-Fine",986.98);
        book2.setId(2);

        when(bookRepository.save(book2)).thenReturn(book2);

        List<Book> bookList2 = new ArrayList<>();
        bookList2.add(book1);
        bookList2.add(book2);
        String bookListJson2 = mapper.writeValueAsString(bookList2);

        when(bookRepository.findBookByGenre(book1.getGenre())).thenReturn(bookList2);

        mockMvc.perform(get("/books/genre/Western"))
                .andExpect(status().isOk())
                .andExpect(content().json(bookListJson2));
    }

    @Test
    public void shouldReturnBooksByBookCondition() throws Exception {
        Book book1 = new Book("Drinking At The Shadows","Shelby T. Rivers","Western","1924",
                "1st","Hardcover","Near-Fine",589.60);
        book1.setId(1);

        when(bookRepository.save(book1)).thenReturn(book1);

        Book book2 = new Book("Hurt By History","Lars J. Singleton","Non-fiction","1931",
                "1st","Hardcover","Near-Fine",986.98);
        book2.setId(2);

        when(bookRepository.save(book2)).thenReturn(book2);

        List<Book> bookList2 = new ArrayList<>();
        bookList2.add(book1);
        bookList2.add(book2);
        String bookListJson2 = mapper.writeValueAsString(bookList2);

        when(bookRepository.findBookByBookCondition(book1.getBookCondition())).thenReturn(bookList2);

        mockMvc.perform(get("/books/bookCondition/Near-Fine"))
                .andExpect(status().isOk())
                .andExpect(content().json(bookListJson2));
    }
}