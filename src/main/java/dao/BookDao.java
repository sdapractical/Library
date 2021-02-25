package dao;

import domain.Book;

import java.util.List;

public interface BookDao {

    void saveOrUpdate(Book book);
    List<Book> getBooks();
    void getBookById (Book book);
    void delete(Book book);
}
