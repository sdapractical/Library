package ui.controller;


import dao.BookDao;
import dao.DaoRepository;
import domain.Book;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class AddBookController implements Initializable {

    private final BookDao bookDao = DaoRepository.getBookDao();


    @FXML
    private TextField title;
    @FXML
    private TextField author;
    @FXML
    private TextField genre;
    @FXML
    private DatePicker date;
    @FXML
    private Button addBookButton2;
    @FXML
    private Button cancelButton2;
    @FXML
    private Label messageLabel;




    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Stage window = new Stage();
        Book book = new Book();
        book.setTitle(title.getText());
        book.setAuthors(author.getText());
        book.setGenre(genre.getText());
        book.setDate(date.getValue());

        addBookButton2.setOnAction(event -> {

            messageLabel.setText("");

            if (author.getText().isEmpty()) {
                messageLabel.setText("Please enter an author.");
                return;
            }else {
                bookDao.saveOrUpdate(book);
                window.close();
            }
        });

        cancelButton2.setOnAction(event -> {
            Stage stage = (Stage) cancelButton2.getScene().getWindow();
            stage.close();
        });

    }
}
