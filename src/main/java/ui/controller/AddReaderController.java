package ui.controller;

import dao.DaoRepository;
import dao.ReaderDao;
import domain.Reader;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class AddReaderController implements Initializable {

    private final ReaderDao readerDao = DaoRepository.getReaderDao();

    @FXML
    private Button addReaderButton2;
    @FXML
    private Button cancelButton2;
    @FXML
    private TextField firstName;
    @FXML
    private TextField lastName;
    @FXML
    private TextField phoneNumber;
    @FXML
    private TextField address;
    @FXML
    private Label messageLabel;


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        addReaderButton2.setOnAction(event -> {
            messageLabel.setText("");
            Reader reader = new Reader();
            reader.setFirstName(firstName.getText());
            reader.setLastName(lastName.getText());
            reader.setMobilePhone(phoneNumber.hashCode());
            reader.setAddress(address.getText());
            if (firstName.getText().isEmpty()) {
                messageLabel.setText("Please enter reader name.");
                return;
            }
            readerDao.saveOrUpdate(reader);
            Stage stage = (Stage) addReaderButton2.getScene().getWindow();
            stage.close();

        });

        cancelButton2.setOnAction(event -> {
            Stage stage = (Stage) cancelButton2.getScene().getWindow();
            stage.close();
        });


    }
}
