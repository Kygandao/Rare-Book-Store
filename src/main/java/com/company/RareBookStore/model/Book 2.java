package com.company.RareBookStore.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Objects;

@Entity
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
@Table(name = "book")
public class Book implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotEmpty(message = "Must provide the Title of the Book")
    private String title;
    @NotEmpty(message = "Must provide the Author of the Book")
    private String author;
    private String genre;
//    @Size(min = 4, max = 4, message = "Year must be exactly 4 digits")
    private int yearWritten;
    private String edition;
    private String binding;
    @NotEmpty(message = "Must provide the Condition of the Book")
    private String bookCondition;
    @PositiveOrZero
    private float price;
    private Integer customerId;

    public Book() {
    }

    public Book(Integer id, String title, String author, String genre, int yearWritten, String edition, String binding, String bookCondition, float price) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.yearWritten = yearWritten;
        this.edition = edition;
        this.binding = binding;
        this.bookCondition = bookCondition;
        this.price = price;
    }

    public Integer getBookId() {
        return id;
    }

    public void setBookId(Integer id) {
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

    public int getYearWritten() {
        return yearWritten;
    }

    public void setYearWritten(int yearWritten) {
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

    public void setPrice(float price) {
        this.price = price;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return yearWritten == book.yearWritten && Double.compare(book.price, price) == 0 && Objects.equals(id, book.id) && Objects.equals(title, book.title) && Objects.equals(author, book.author) && Objects.equals(genre, book.genre) && Objects.equals(edition, book.edition) && Objects.equals(binding, book.binding) && Objects.equals(bookCondition, book.bookCondition) && Objects.equals(customerId, book.customerId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, author, genre, yearWritten, edition, binding, bookCondition, price, customerId);
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", genre='" + genre + '\'' +
                ", yearWritten=" + yearWritten +
                ", edition='" + edition + '\'' +
                ", binding='" + binding + '\'' +
                ", bookCondition='" + bookCondition + '\'' +
                ", price=" + price +
                ", customerId=" + customerId +
                '}';
    }
}
