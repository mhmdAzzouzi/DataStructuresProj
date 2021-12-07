package sample.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.VBox;
import sample.Controllers.Items.BookItem;
import sample.DataStructures.Queue;
import sample.Main;
import sample.Models.Book;
import sample.Models.User;

import java.io.IOException;

import java.util.ArrayList;

public class ViewLatestAdditions {

    @FXML
    ScrollPane scrollPane;
    @FXML
    VBox listBox;
    @FXML
    TextField searchField;
    @FXML
    Label messageLabel, loggedinAs;
    @FXML
    Label friendsNumber;


    public void searchItem() throws Exception {
        System.out.println(searchField.getText());
        if (searchField.getText().length() > 0) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/sample/View/Search.fxml"));
            Parent page = loader.load();
            Search controller = loader.getController();
            controller.searchItem(Integer.parseInt(searchField.getText()));
            Search.bookId = searchField.getText();
            Main.switchScene(page);
        }
    }

    public void filterAll() throws IOException {
        drawList();
    }

    public void filterByLatest() throws IOException {
        Main.queue.display();
        listBox.getChildren().clear();
        if (Main.queue.length() == 0) {
            listBox.getChildren().add(messageLabel);
        }
        Queue queueToView = Main.queue.copy();
        for (int i = 0; i < Main.queue.length(); i++) {
            Book book = queueToView.dequeue();
            String author = book.getAuthor();
            String title = book.getTitle();
            String genre = book.getGenre();
            String quantity = String.valueOf(book.getQuantity());
            int rating = book.getRating();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/sample/View/Items/BookItem.fxml"));
            Parent component = loader.load();
            BookItem bookItem = loader.getController();
            bookItem.setItems(title, genre, author, quantity, rating);
            listBox.getChildren().add(component);
        }
    }

    public void drawList() throws IOException {
        System.out.println(Main.arrayList.size());
        listBox.getChildren().clear();
        for (int i = 0; i < Main.arrayList.size(); i++) {
            String author = Main.arrayList.get(i).getAuthor();
            String title = Main.arrayList.get(i).getTitle();
            String genre = Main.arrayList.get(i).getGenre();
            String quantity = String.valueOf(Main.arrayList.get(i).getQuantity());
            int rating = Main.arrayList.get(i).getRating();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/sample/View/Items/BookItem.fxml"));
            Parent component = loader.load();
            BookItem bookItem = loader.getController();
            bookItem.setItems(title, genre, author, quantity, rating);
            listBox.getChildren().add(component);
        }
    }

    @FXML
    public void initialize() throws IOException {
        loggedinAs.setText(String.valueOf(Main.loggedIn.getName()));
        ArrayList<User> filtered = new ArrayList<>(Main.loggedIn.friendsList);
        filtered.removeIf(user -> Main.loggedIn == user);
        if (filtered.size() > 0) {
            friendsNumber.setText(String.valueOf(filtered.size()));
        } else {
            friendsNumber.setText("0");
        }
        drawList();
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

    public void viewFriends() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/sample/View/Friends.fxml"));
        Parent root = loader.load();
        Main.switchScene(root);
    }

    public void navigate(ActionEvent event) throws IOException {
        BookStacks nav = new BookStacks();
        nav.navigate(event);
    }
}
