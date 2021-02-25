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

    private final BookDao bookDao = DaoRepository.getBookDao();
    private List<Book> allBooks;
    private final ReaderDao readerDao = DaoRepository.getReaderDao();


    @FXML
    private Button addBookButton;

    @FXML
    private Button addReaderButton;

    @FXML
    private Button markAsBorrowedButton;

    @FXML
    private TableView<Book> bookList;

    @FXML
    private TableView<Reader> readerList;


    @Override
    public void initialize(URL location, ResourceBundle resources) {

       /*allBooks = bookDao.getBooks();
        bookList.getItems().addAll(allBooks);

        readerList.getItems().addAll(readerDao.getReaders());

        Book book = new Book();
        bookDao.saveOrUpdate(book);
        bookList.refresh();*/

        addBookButton.setOnAction(event -> {
            try {
                LibraryApplication.setWindow(MenuEnum.ADD_BOOK);
            }catch (IOException e){
                e.printStackTrace();
            }
        });

        addReaderButton.setOnAction(event -> {
            try {
                LibraryApplication.setWindow(MenuEnum.ADD_READER);
            }catch (IOException e){
                e.printStackTrace();
            }
        });

        markAsBorrowedButton.setOnAction(event -> {
            try {
                LibraryApplication.setWindow(MenuEnum.MARK_AS_BORROWED);
            }catch (IOException e){
                e.printStackTrace();
            }
        });

    }
}
