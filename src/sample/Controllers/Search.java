package sample.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.VBox;
import sample.Controllers.Items.BookCard;
import sample.Main;
import sample.Models.Book;
import sample.Models.Data;
import sample.Models.User;

import java.io.IOException;
import java.util.ArrayList;

public class Search {
    @FXML
    TextField searchField;

    @FXML
    Label loggedinAs, message, friendsNumber;

    @FXML
    VBox cardposition;
    @FXML
    Button deleteButton;
    static boolean found;

    static String bookId;

    public void viewFriends() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/sample/View/Friends.fxml"));
        Parent root = loader.load();
        Main.switchScene(root);
    }

    @FXML
    public void initialize() throws IOException {
        loggedinAs.setText(String.valueOf(Main.loggedIn.getName()));
        ArrayList<User> filteredfriendsList = new ArrayList<>(Main.loggedIn.friendsList);
        filteredfriendsList.removeIf(user -> Main.loggedIn == user);
        if (filteredfriendsList.size() > 0) {
            friendsNumber.setText(String.valueOf(filteredfriendsList.size()));
        } else {
            friendsNumber.setText("0");
        }
        searchField.setOnKeyPressed((KeyEvent e) -> {
            if (e.getCode().equals(KeyCode.ENTER) || e.getCode().equals(KeyCode.TAB)) {
                try {
                    searchItem();
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
        });


    }

    public void searchItem(int id) throws IOException {
        Book book = Main.binaryTree.search(id);
        if (book != null) {

            FXMLLoader loader = new FXMLLoader(getClass().getResource("/sample/View/Items/book card.fxml"));
            Parent root = loader.load();
            BookCard cardController = loader.getController();
            cardController.setLabels(String.valueOf(book.getID()), book.getTitle(), book.getAuthor(), String.valueOf(book.getQuantity()), book.getGenre());
            cardposition.getChildren().clear();
            message.setText("");
            deleteButton.setVisible(!Main.loggedIn.getType().equals("User"));
            cardposition.getChildren().add(root);
        } else {
            found = false;
            Label label = new Label();
            cardposition.getChildren().clear();
            deleteButton.setVisible(false);
            message.setText("");
            label.setText("Book not found ...");
            cardposition.getChildren().add(label);
        }
    }

    public void deleteBookAction() {
        try {
            Main.binaryTree.deletion(Integer.parseInt(bookId));
            Main.stack.deleteBook(Integer.parseInt(bookId));
            Data.deleteFromArrayList(Integer.parseInt(bookId));
            Main.queue.deleteBook(Integer.parseInt(bookId));
            message.setText("Book was deleted !");
            deleteButton.setVisible(false);
        } catch (Exception e) {
            System.out.println("no book to delete");
        }
    }

    public void navigate(ActionEvent event) throws IOException {
        BookStacks nav = new BookStacks();
        nav.navigate(event);
    }

    public void searchItem() throws Exception {
        searchItem(Integer.parseInt(searchField.getText()));
    }
}
