package ui.controller;

import dao.BookDao;
import dao.DaoRepository;
import dao.ReaderDao;
import domain.Book;
import domain.Reader;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class HandOutBookController implements Initializable {
    private final ReaderDao readerDao = DaoRepository.getReaderDao();
    private final BookDao bookDao = DaoRepository.getBookDao();


    @FXML
    private TableView<Reader> readerList2;

    @FXML
    private Button okButton;

    @FXML
    private DatePicker dueDate;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        readerList2.getItems().addAll(readerDao.getReaders());

        okButton.setOnAction(event -> {
            Book book = new Book();
            book.setDate(dueDate.getValue());
            bookDao.saveOrUpdate(book);
            Stage stage = (Stage) okButton.getScene().getWindow();
            stage.close();

        });

    }
}
