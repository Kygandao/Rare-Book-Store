package com.company.RareBookStore.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
@Table(name = "book")
public class Book implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer Id;

    @NotEmpty(message = "Must provide the Title of the Book")
    private String title;
    @NotEmpty(message = "Must provide the Author of the Book")
    private String author;
    private String genre;
    @Size(min = 4, max = 4, message = "Year must be exactly 4 digits")
    private int yearWritten;
    private String edition;
    private String binding;
    @NotEmpty(message = "Must provide the Condition of the Book")
    private String condition;
    @PositiveOrZero
    private BigDecimal price;

    public Book() {
    }

    public Book(Integer id, String title, String author, String genre, int yearWritten, String edition, String binding, String condition, BigDecimal price) {
        Id = id;
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.yearWritten = yearWritten;
        this.edition = edition;
        this.binding = binding;
        this.condition = condition;
        this.price = price;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
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

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return yearWritten == book.yearWritten && Objects.equals(Id, book.Id) && Objects.equals(title, book.title) && Objects.equals(author, book.author) && Objects.equals(genre, book.genre) && Objects.equals(edition, book.edition) && Objects.equals(binding, book.binding) && Objects.equals(condition, book.condition) && Objects.equals(price, book.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Id, title, author, genre, yearWritten, edition, binding, condition, price);
    }

    @Override
    public String toString() {
        return "Book{" +
                "Id=" + Id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", genre='" + genre + '\'' +
                ", yearWritten=" + yearWritten +
                ", edition='" + edition + '\'' +
                ", binding='" + binding + '\'' +
                ", condition='" + condition + '\'' +
                ", price=" + price +
                '}';
    }
}
