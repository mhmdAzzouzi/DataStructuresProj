package sample;

import animatefx.animation.FadeIn;
import animatefx.animation.FlipInX;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sample.DataStructures.BST;
import sample.DataStructures.LinkedList;
import sample.DataStructures.Queue;
import sample.Models.Book;
import sample.Models.Data;
import sample.Models.Librarian;
import sample.DataStructures.Stack;
import sample.Models.User;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class Main extends Application {

    public static Stage stage;
    public static LinkedList linkedlist = new LinkedList();
    public static Stack stack = new Stack();
    //    public static Librarian librarian = new Librarian();
    public static ArrayList<Book> arrayList = new ArrayList<>();
    public static BST binaryTree = new BST();
    public static Queue queue = new Queue();
    public static ArrayList<User> userList = new ArrayList<>();
    public static User loggedIn;

    public static void restoreSize() {
//         920, 649)
        stage.setWidth(920);
        stage.setHeight(649);
    }

    public static void restoreSize2() {
        stage.setWidth(600);
        stage.setHeight(390);
    }


    @Override
    public void start(Stage primaryStage) throws IOException {
        stage = primaryStage;
        Parent root = FXMLLoader.load(getClass().getResource("/sample/View/SignUp.fxml"));
        primaryStage.setTitle("Book Club House");
        primaryStage.setScene(new Scene(root, 600, 390));
        Data.load();

        stage.show();
        new FadeIn(root).play();
    }

    public static void switchScene(Parent root) throws IOException {
        stage.getScene().setRoot(root);
    }


    public static void main(String[] args) {
        launch(args);
        System.out.println(userList);
    }
}
