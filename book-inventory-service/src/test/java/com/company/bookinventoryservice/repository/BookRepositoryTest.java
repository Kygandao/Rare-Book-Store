package com.company.bookinventoryservice.repository;

import com.company.bookinventoryservice.model.Book;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class BookRepositoryTest {

    @Autowired
    BookRepository bookRepository;

    @Before
    public void setUp() throws Exception {

        bookRepository.deleteAll();
    }

    @Test
    public void addGetDeleteBook() {

        Book book = new Book("Drinking At The Shadows","Shelby T. Rivers","Western","1924"
                ,"1st","Hardcover","Fine",589.60);

        book = bookRepository.save(book);

        Optional<Book> book1 = bookRepository.findById(book.getId());

        assertEquals(book1.get(),book);

        bookRepository.deleteById(book.getId());

        book1 = bookRepository.findById(book.getId());

        assertFalse(book1.isPresent());
    }

    @Test
    public void getAllBooks() {

        Book book1 = new Book("Drinking At The Shadows","Shelby T. Rivers","Western","1924",
                "1st","Hardcover","Fine",589.60);

        book1 = bookRepository.save(book1);

        Book book2 = new Book("Hurt By History","Lars J. Singleton","Non-fiction","1931",
                "1st","Hardcover","Near-Fine",986.98);

        book2 = bookRepository.save(book2);

        List<Book> bookList = bookRepository.findAll();

        assertEquals(bookList.size(),2);
    }

    @Test
    public void updateBook() {
        Book book = new Book("Drinking At The Shadows","Shelby T. Rivers","Western","1924"
                ,"1st","Hardcover","Fine",589.60);

        book = bookRepository.save(book);

        book.setPrice(590.99);

        bookRepository.save(book);

        Optional<Book> book1 = bookRepository.findById(book.getId());
        assertEquals(book1.get(), book);

    }

    @Test
    public void getBookByAuthor() {
        Book book1 = new Book("Drinking At The Shadows","Shelby T. Rivers","Western","1924",
                "1st","Hardcover","Fine",589.60);

        book1 = bookRepository.save(book1);

        Book book2 = new Book("Hurt By History","Lars J. Singleton","Non-fiction","1931",
                "1st","Hardcover","Near-Fine",986.98);

        book2 = bookRepository.save(book2);

        Book book3 = new Book("Painting The Ships","Shelby T. Rivers","Fantasy","1985",
                "1st","Hardcover","Very-Good",419.92
        );

        book3 = bookRepository.save(book3);

        List<Book> bookList = new ArrayList<>();
        bookList.add(book1);
        bookList.add(book3);

        List<Book> bookListFromRepo = bookRepository.findBookByAuthor(book1.getAuthor());

        assertEquals(bookList, bookListFromRepo);
    }

    @Test
    public void getBookByGenre() {
        Book book1 = new Book("Drinking At The Shadows","Shelby T. Rivers","Western","1924",
                "1st","Hardcover","Fine",589.60);

        book1 = bookRepository.save(book1);

        Book book2 = new Book("Hurt By History","Lars J. Singleton","Non-fiction","1931",
                "1st","Hardcover","Near-Fine",986.98);

        book2 = bookRepository.save(book2);

        Book book3 = new Book("Vanish At The Commander","Amal F. Hickman","Western","2008",
                "1st","Hardcover","Good",191.22);

        book3 = bookRepository.save(book3);

        List<Book> bookList = new ArrayList<>();
        bookList.add(book1);
        bookList.add(book3);

        List<Book> bookListFromRepo = bookRepository.findBookByGenre(book1.getGenre());

        assertEquals(bookList, bookListFromRepo);

    }

    @Test
    public void getBookByCondition() {

        Book book1 = new Book("Drinking At The Shadows","Shelby T. Rivers","Western","1924",
                "1st","Hardcover","Fine",589.60);

        book1 = bookRepository.save(book1);

        Book book2 = new Book("Reach Of The Ashes","Kane Q. Reed","Poetry","1972",
                "1st","Hardcover","Fine",357.62);

        book2 = bookRepository.save(book2);

        Book book3 = new Book("Vanish At The Commander","Amal F. Hickman","Western","2008",
                "1st","Hardcover","Good",191.22);

        book3 = bookRepository.save(book3);

        List<Book> bookList = new ArrayList<>();
        bookList.add(book1);
        bookList.add(book2);

        List<Book> bookListFromRepo = bookRepository.findBookByBookCondition(book2.getBookCondition());

        assertEquals(bookList, bookListFromRepo);
    }
}