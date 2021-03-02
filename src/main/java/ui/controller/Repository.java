package ui.controller;

import dao.BookDao;
import dao.ReaderDao;
import dao.impl.BookDaoImpl;
import dao.impl.ReaderDaoImpl;
import domain.Book;
import domain.Reader;

import java.util.List;

public class Repository {
    private static List<Reader> readers;
    private static List<Book> books;
    private static BookDao bookDao = new BookDaoImpl();
    private static ReaderDao readerDao = new ReaderDaoImpl();
    private static Book currentBookToHandOut;

    static {
        readers =readerDao.getReaders();
        books =bookDao.getBooks();

    }



    public static List<Reader> getReaders(){
        return readers;
    }

    public static List<Book> getBooks(){
        return books;
    }


    public static void setCurrentBookToHandOut(Book currentBookToHandOut) {
        Repository.currentBookToHandOut = currentBookToHandOut;
    }

    public static Book getCurrentBookToHandOut() {
        return currentBookToHandOut;
    }

}
