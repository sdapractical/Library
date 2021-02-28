package ui.controller;


import dao.BookDao;
import dao.DaoRepository;
import domain.Book;
import domain.Reader;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
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
    private TextField publishingYear;
    @FXML
    private Button addBookButton2;
    @FXML
    private Button cancelButton2;
    @FXML
    private Label messageLabel;



    @Override
    public void initialize(URL location, ResourceBundle resources) {

        addBookButton2.setOnAction(event -> {
            Reader reader = new Reader();
            Book book = new Book();
            book.setTitle(title.getText());
            book.setAuthors(author.getText());
            book.setGenre(genre.getText());
            book.setPublishingYear(publishingYear.getText());
            book.setReaderId(null);
            messageLabel.setText("");

            if (author.getText().isEmpty()) {
                messageLabel.setText("Please enter an author.");
                return;
            }
                bookDao.saveOrUpdate(book);
                title.setText("");
                author.setText("");
                genre.setText("");
                publishingYear.setText("");
            Stage stage = (Stage) addBookButton2.getScene().getWindow();
            stage.close();




        });

        cancelButton2.setOnAction(event -> {
            Stage stage = (Stage) cancelButton2.getScene().getWindow();
            stage.close();

        });

    }
}
