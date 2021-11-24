package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sample.DataStructures.BST;
import sample.DataStructures.LinkedList;
import sample.Models.Book;
import sample.Models.Data;
import sample.Models.Librarian;
import sample.DataStructures.Stack;
import sample.Models.User;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class Main extends Application {

    private static Stage stage;
    public static LinkedList linkedlist = new LinkedList();
    public static Stack stack = new Stack();
    //    public static Librarian librarian = new Librarian();
    public static ArrayList<Book> arrayList = new ArrayList<>();
    public static BST binaryTree = new BST();
    public static User jihan = new User("p", "Jihan", "Farhat", "1111", "11");
    public static User mohammad = new User("p", "Mohammad", "Azzouzi", "0000", "00");
    public static User nour = new User("p", "", "", "2222", "22");
    public static User librarian = new User("a", "", "", "3333", "33");
    public static ArrayList<User> users = new ArrayList<>(Arrays.asList(jihan,mohammad,nour,librarian));

    @Override
    public void start(Stage primaryStage) throws IOException {
        stage = primaryStage;
        Parent root = FXMLLoader.load(getClass().getResource("View/Authentication.fxml"));
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
