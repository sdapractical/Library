package windows;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.nio.file.Paths;

public class AddBookWindow {
    public static void display (String title) {

        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(title);

        Parent root = null;

        try {
            URL path = Paths.get("src/main/resources/ui/addBook.fxml").toUri().toURL();
            root = FXMLLoader.load(path);
        } catch (IOException e) {
            e.printStackTrace();
            window.close();
        }

        Scene scene = new Scene(root);



        window.setScene(scene);
        window.showAndWait();
    }
}
