package com.company.bookinventoryservice.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler"})
@Table(name = "book")
public class Book implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String title;
    private String author;
    private String genre;
    private String yearWritten;
    private String edition;
    private String binding;
    private String bookCondition;
    private double price;

    public Book() {
    }

    public Book(String title, String author, String genre, String yearWritten, String edition, String binding, String bookCondition, double price) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.yearWritten = yearWritten;
        this.edition = edition;
        this.binding = binding;
        this.bookCondition = bookCondition;
        this.price = price;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getYearWritten() {
        return yearWritten;
    }

    public void setYearWritten(String yearWritten) {
        this.yearWritten = yearWritten;
    }

    public String getEdition() {
        return edition;
    }

    public void setEdition(String edition) {
        this.edition = edition;
    }

    public String getBinding() {
        return binding;
    }

    public void setBinding(String binding) {
        this.binding = binding;
    }

    public String getBookCondition() {
        return bookCondition;
    }

    public void setBookCondition(String bookCondition) {
        this.bookCondition = bookCondition;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Double.compare(book.price, price) == 0 && Objects.equals(id, book.id) && Objects.equals(title, book.title) && Objects.equals(author, book.author) && Objects.equals(genre, book.genre) && Objects.equals(yearWritten, book.yearWritten) && Objects.equals(edition, book.edition) && Objects.equals(binding, book.binding) && Objects.equals(bookCondition, book.bookCondition);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, author, genre, yearWritten, edition, binding, bookCondition, price);
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", genre='" + genre + '\'' +
                ", yearWritten='" + yearWritten + '\'' +
                ", edition='" + edition + '\'' +
                ", binding='" + binding + '\'' +
                ", bookCondition='" + bookCondition + '\'' +
                ", price=" + price +
                '}';
    }
}
