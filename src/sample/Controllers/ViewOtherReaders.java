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
import javafx.scene.layout.FlowPane;
import sample.Controllers.Items.UserCard;
import sample.Main;
import sample.Models.User;

import java.io.IOException;
import java.util.ArrayList;

public class ViewOtherReaders {

    @FXML
    TextField searchField;
    @FXML
    Label loggedinAs;
    @FXML
    FlowPane userCardFlowPane;
    @FXML
    Label friendsNumber;

    public void viewFriends() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/sample/View/Friends.fxml"));
        Parent root = loader.load();
        Main.switchScene(root);
    }


    @FXML
    public void initialize() throws IOException {
        ArrayList<User> filteredfriendsList = new ArrayList<>(Main.loggedIn.friendsList);
        filteredfriendsList.removeIf(user -> Main.loggedIn == user);
        if (filteredfriendsList.size() > 0) {
            friendsNumber.setText(String.valueOf(filteredfriendsList.size()));
        } else {
            friendsNumber.setText("0");
        }
        Main.restoreSize();
        loggedinAs.setText(Main.loggedIn.getName());
        ArrayList<User> filtered = new ArrayList<>(Main.userList);
        filtered.removeIf(user -> user == Main.loggedIn || Main.loggedIn.friendsList.contains(user));
        for (int i = 0; i < filtered.size(); i++) {
            User u = filtered.get(i);
            System.out.println(u.getName());
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/sample/View/Items/UserCardTest.fxml"));
            Parent userCard = loader.load();
            UserCard userCard1 = loader.getController();
            userCard1.setLabels(u.getName(), u.getEmail(), u.getID(), Main.userList.get(i).friendsList.size(), false);

            userCardFlowPane.getChildren().add(userCard);
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

    public void navigate(ActionEvent event) throws IOException {
        BookStacks nav = new BookStacks();
        nav.navigate(event);
    }
}
