package com.company.RareBookStore.repository;

import com.company.RareBookStore.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
    List<Book> findBookByAuthor(String author);
    List<Book> findBookByGenre(String genre);
    List<Book> findBookByBookCondition(String bookCondition);

}
