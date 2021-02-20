
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import java.net.URL;

public class LibraryApplication extends Application{

    private static Stage window;
    private static BorderPane stage;

    @Override
    public void start(Stage primaryStage) throws Exception {


        window = primaryStage;
        window.setTitle("Library application");
        window.setOnCloseRequest(event -> {
                    window.close();
                });

        URL path = getClass().getResource("ui/menu.fxml").toURI().toURL();
        Parent root = FXMLLoader.load(path);

        stage = (BorderPane) root;

        Scene scene = new Scene(stage, 800, 500);

        window.setScene(scene);
        window.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    
    }



