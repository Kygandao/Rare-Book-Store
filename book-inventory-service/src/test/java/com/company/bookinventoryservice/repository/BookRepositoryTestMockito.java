package com.company.bookinventoryservice.repository;

import com.company.bookinventoryservice.model.Book;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.mockito.Mockito.when;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class BookRepositoryTestMockito {

    @MockBean
    BookRepository bookRepository;

    Book outputBook;
    List<Book> bookList;

    @Before
    public void setUp() throws Exception {
        outputBook =  new Book("Drinking At The Shadows","Shelby T. Rivers","Western","1924",
                "1st","Hardcover","Fine",589.60);
        outputBook.setId(1);

        bookList = new ArrayList<>();
        bookList.add(outputBook);
    }

    @Test
    public void postABook() {

        Book book1 = new Book("Drinking At The Shadows","Shelby T. Rivers","Western","1924",
                "1st","Hardcover","Fine",589.60);
        book1.setId(1);

        when(bookRepository.save(book1)).thenReturn(book1);

        assertEquals(bookList.size(),1);
    }


    @Test
    public void getAllBooks() {

        when(bookRepository.findAll()).thenReturn(bookList);

        assertEquals(bookList.size(),1);
    }

    @Test
    public void getBookById() {
        Book book1 = new Book("Drinking At The Shadows","Shelby T. Rivers","Western","1924",
                "1st","Hardcover","Fine",589.60);
        book1.setId(1);

        when(bookRepository.findById(outputBook.getId())).thenReturn(Optional.ofNullable(outputBook));

        Optional<Book> book2 = bookRepository.findById(outputBook.getId());
        assertEquals(book2.get(),book1);

    }

    @Test
    public void updateBookById() {
        Book book1 = new Book("Drinking At The Shadows","Shelby T. Rivers","Western","1924",
                "1st","Hardcover","Fine",999.60);
        book1.setId(1);

        when(bookRepository.save(book1)).thenReturn(book1);

        when(bookRepository.findById(outputBook.getId())).thenReturn(Optional.ofNullable(outputBook));

        boolean test = book1.equals(outputBook);

        assertFalse(test);

    }

//    @Test
//    public void deleteBookById() {
//    }

    @Test
    public void getBookByAuthor() {
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

        when(bookRepository.findBookByAuthor(book1.getAuthor())).thenReturn(bookList2);

        List<Book> bookListFromRepo = bookRepository.findBookByAuthor(book1.getAuthor());

        assertEquals(bookList2, bookListFromRepo);
    }

    @Test
    public void getBookByGenre() {
        Book book1 = new Book("Drinking At The Shadows","Shelby T. Rivers","Western","1924",
                "1st","Hardcover","Fine",589.60);
        book1.setId(1);

        when(bookRepository.save(book1)).thenReturn(book1);

        Book book2 = new Book("Hurt By History","Shelby T. Rivers","Western","1931",
                "1st","Hardcover","Near-Fine",986.98);
        book2.setId(2);

        when(bookRepository.save(book2)).thenReturn(book2);

        List<Book> bookList2 = new ArrayList<>();
        bookList2.add(book1);
        bookList2.add(book2);

        when(bookRepository.findBookByGenre(book1.getGenre())).thenReturn(bookList2);

        List<Book> bookListFromRepo = bookRepository.findBookByGenre(book1.getGenre());

        assertEquals(bookList2, bookListFromRepo);

    }

    @Test
    public void getBookByCondition() {

        Book book1 = new Book("Drinking At The Shadows","Shelby T. Rivers","Western","1924",
                "1st","Hardcover","Fine",589.60);
        book1.setId(1);

        when(bookRepository.save(book1)).thenReturn(book1);

        Book book2 = new Book("Hurt By History","Shelby T. Rivers","Western","1931",
                "1st","Hardcover","Fine",986.98);
        book2.setId(2);

        when(bookRepository.save(book2)).thenReturn(book2);

        List<Book> bookList2 = new ArrayList<>();
        bookList2.add(book1);
        bookList2.add(book2);

        when(bookRepository.findBookByBookCondition(book1.getBookCondition())).thenReturn(bookList2);

        List<Book> bookListFromRepo = bookRepository.findBookByBookCondition(book1.getBookCondition());

        assertEquals(bookList2, bookListFromRepo);
    }
}