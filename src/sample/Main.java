package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
import java.time.LocalTime;
import java.util.ArrayList;

public class Main extends Application {

    private static Stage stage;
    public static LinkedList linkedlist = new LinkedList();
    public static Librarian librarian = new Librarian();
    public static ArrayList<Book> arrayList = new ArrayList<>();
    @Override
    public void start(Stage primaryStage) throws IOException {
        stage = primaryStage;
        Parent root = FXMLLoader.load(getClass().getResource("Authentication.fxml"));
        primaryStage.setTitle("Book Club House");
        primaryStage.setScene(new Scene(root, 906, 648));
        stage.show();
    }

    public static void switchScene(Parent root) throws IOException {
        stage.getScene().setRoot(root);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
