package domain;

import javax.persistence.*;
import java.time.LocalDate;


@Entity
@Table(name = "book")
public class Book {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "title")
    private String title;

    @Column(name = "authors")
    private String authors;

    @Column(name = "genre")
    private String genre;

    @Column(name = "publishingYear")
    private LocalDate publishingYear;

    @Column(name = "borrowed")
    private boolean borrowed;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {
            CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH
    })

    @JoinColumn(name = "reader_id")
    private Reader reader;

    @Column(name = "dueDate")
    private LocalDate dueDate;

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthors() {
        return authors;
    }

    public void setAuthors(String authors) {
        this.authors = authors;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public LocalDate getPublishingYear() {
        return publishingYear;
    }

    public void setPublishingYear(LocalDate publishingYear) {
        this.publishingYear = publishingYear;
    }

    public boolean isBorrowed() {
        return borrowed;
    }

    public void setBorrowed(boolean borrowed) {
        this.borrowed = borrowed;
    }

    public Reader getReader() {
        return reader;
    }

    public void setReaderId(Reader reader) {
        this.reader = reader;
    }

    public LocalDate getDate() {
        return dueDate;
    }

    public void setDate(LocalDate date) {
        this.dueDate = date;
    }
}
