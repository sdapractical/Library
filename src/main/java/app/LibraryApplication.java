package app;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import ui.model.MenuEnum;
import windows.AddBookWindow;
import windows.AddReaderWindow;
import windows.MarkAsBorrowed;

import java.io.IOException;
import java.net.URL;
import java.nio.file.Paths;

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

        URL path = Paths.get("src/main/resources/ui/menu.fxml").toUri().toURL();
          Parent root = FXMLLoader.load(path);

        stage = (BorderPane) root;

        Scene scene = new Scene(stage, 800, 500);

        window.setScene(scene);
        window.show();
    }

    public static void main(String[] args) {
        launch(args);
    }


    public static void setWindow(MenuEnum menu) throws IOException {

        switch (menu) {
            case ADD_BOOK: {
                AddBookWindow.display("Add book");
                break;

            }

            case ADD_READER: {
                AddReaderWindow.display("Add reader");
                break;

            }

            case MARK_AS_BORROWED: {
                MarkAsBorrowed.display("Borrowed");
                break;
            }
            default: {
                stage.setCenter(null);
            }
        }

    }
    }





