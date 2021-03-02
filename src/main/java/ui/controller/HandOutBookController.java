package ui.controller;

import dao.BookDao;
import dao.DaoRepository;
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
    private final BookDao bookDao = DaoRepository.getBookDao();
    Book book = new Book();



    @FXML
    private TableView<Reader> readerList2;

    @FXML
    private Button okButton;

    @FXML
    private DatePicker dueDate;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        readerList2.getItems().addAll(Repository.getReaders());

        okButton.setOnAction(event -> {
           Reader reader =  readerList2.getSelectionModel().getSelectedItem();
           Book book = Repository.getCurrentBookToHandOut();
            book.setDate(dueDate.getValue());
            book.setBorrowed(true);
            book.setReaderId(reader);
            bookDao.saveOrUpdate(book);

            Stage stage = (Stage) okButton.getScene().getWindow();
            stage.close();

        });

    }
}
