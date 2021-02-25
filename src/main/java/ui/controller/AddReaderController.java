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
        Stage window = new Stage();
        Reader reader = new Reader();
        reader.setFirstName(firstName.getText());
        reader.setLastName(lastName.getText());
        reader.setMobilePhone(phoneNumber.hashCode());
        reader.setAddress(address.getText());

        addReaderButton2.setOnAction(event -> {
            messageLabel.setText("");

            if (firstName.getText().isEmpty()) {
                messageLabel.setText("Please enter your name.");
                return;
            }else {
                readerDao.saveOrUpdate(reader);
                window.close();
            }
        });

        cancelButton2.setOnAction(event -> {
            Stage stage = (Stage) cancelButton2.getScene().getWindow();
            stage.close();
        });

        /*addReaderButton.setOnAction(event ->{
            String firstNameText = firstName.getText();

            firstNameText = firstNameText.substring(0, 1).toUpperCase(Locale.ROOT) +
                    firstNameText.substring(1).toLowerCase();

            Reader reader = new Reader();
            reader.setFirstName(firstNameText);

            try {
                readerDao.saveOrUpdate(reader);

            }catch (ConstraintViolationException e){

            }


        });
*/

    }
}
