package ui.controller;

import dao.BookDao;
import dao.DaoRepository;
import dao.ReaderDao;
import domain.Book;
import domain.Reader;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import ui.model.MenuEnum;
import app.LibraryApplication;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class MainController implements Initializable {

    private  final BookDao bookDao = DaoRepository.getBookDao();

    private final ReaderDao readerDao = DaoRepository.getReaderDao();
    private List<Book> allBooks;

    @FXML
    private Button addBookButton;

    @FXML
    private Button deleteReaderButton;

    @FXML
    private Button deleteBookButton;

    @FXML
    private Button addReaderButton;

    @FXML
    private Button UnmarkAsBorrowedButton;

    @FXML
    private TableView<Book> bookList;

    @FXML
    private TableView<Reader> readerList;

    @FXML
    private Button handOutBook;



    @Override
    public void initialize(URL location, ResourceBundle resources) {
        readerList.getItems().addAll(readerDao.getReaders());
        allBooks = bookDao.getBooks();
        bookList.getItems().addAll(bookDao.getBooks());

        deleteBookButton.setOnAction(event -> {
            Book book = bookList.getSelectionModel().getSelectedItem();
            bookDao.delete(book);
            bookList.getItems().remove(book);
            bookList.refresh();

                });

            UnmarkAsBorrowedButton.setOnAction(event -> {
                Book book = bookList.getSelectionModel().getSelectedItem();
                    book.setBorrowed(false);
                    book.setReaderId(null);
                    book.setDate(null);

                bookDao.saveOrUpdate(book);
                bookList.refresh();


            });
            addBookButton.setOnAction(event -> {
                try {
                    LibraryApplication.setWindow(MenuEnum.ADD_BOOK);
                    bookList.getItems().clear();
                    bookList.getItems().addAll(Repository.getBooks());
                    bookList.refresh();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });

            deleteReaderButton.setOnAction(event -> {
                Reader reader = readerList.getSelectionModel().getSelectedItem();
                readerDao.deleteReader(reader);
                readerList.getItems().remove(reader);
                readerList.refresh();
            });

            addReaderButton.setOnAction(event -> {
                try {
                    LibraryApplication.setWindow(MenuEnum.ADD_READER);
                    readerList.getItems().clear();
                    readerList.getItems().addAll(Repository.getReaders());
                    readerList.refresh();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });


        handOutBook.setOnAction(event -> {
            try {
                Book book = bookList.getSelectionModel().getSelectedItem();
                Repository.setCurrentBookToHandOut(book);
                LibraryApplication.setWindow(MenuEnum.HAND_OUT_BOOK);
                bookList.refresh();

            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        }
}
