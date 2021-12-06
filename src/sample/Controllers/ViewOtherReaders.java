package sample.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
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
//            filtering usersList to display readers that aren't in the
//            friendslist of the current user
        filtered.removeIf(user -> user == Main.loggedIn || Main.loggedIn.friendsList.contains(user));
//            for(int i =0 ; i<  filtered.size() ; i++){
//                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/sample/View/Items/UserCard.fxml"));
//                    Parent userCard= loader.load();
//                    userCardBox.getChildren().add(userCard);
//            }
        for (int i = 0; i < filtered.size(); i++) {
            User u = filtered.get(i);
            System.out.println(u.getName());
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/sample/View/Items/UserCardTest.fxml"));
            Parent userCard = loader.load();
            UserCard userCard1 = loader.getController();
            userCard1.setLabels(u.getName(), u.getEmail(), u.getID(), Main.userList.get(i).friendsList.size(), false);

            userCardFlowPane.getChildren().add(userCard);
        }

    }

    public void searchItem() throws Exception {
        System.out.println(searchField.getText());
        if (searchField.getText().length() > 0) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/sample/View/Search.fxml"));
            Parent page = loader.load();
            Search controller= loader.getController();
            controller.searchItem(Integer.parseInt(searchField.getText()));
            Search.bookId=searchField.getText();
            Main.switchScene(page);
        }
    }

    public void navigate(ActionEvent event) throws IOException {
        Button b1 = (Button) event.getTarget();
        try {
            if ("addBook".equals(b1.getId())) {
                FXMLLoader page = new FXMLLoader(getClass().getResource("/sample/View/AddBook.fxml"));
                Parent root = page.load();
                Main.switchScene(root);


            } else if ("BookStacks".equals(b1.getId())) {
                FXMLLoader page2 = new FXMLLoader(getClass().getResource("/sample/View/BookStacks.fxml"));
                Parent root1 = page2.load();
                Main.switchScene(root1);

            } else if ("ViewLatestAdditions".equals(b1.getId())) {
                FXMLLoader page2 = new FXMLLoader(getClass().getResource("/sample/View/ViewLatestAdditions.fxml"));
                Parent root1 = page2.load();
                Main.switchScene(root1);
            } else if ("ViewOtherReaders".equals(b1.getId())) {
                FXMLLoader page2 = new FXMLLoader(getClass().getResource("/sample/View/ViewOtherReaders.fxml"));
                Parent root1 = page2.load();
                Main.switchScene(root1);
            } else if ("logout".equals(b1.getId())) {
                FXMLLoader page2 = new FXMLLoader(getClass().getResource("/sample/View/SignUp.fxml"));
                Parent root1 = page2.load();
                Main.restoreSize2();

                Main.switchScene(root1);
            }
        } catch (Exception e) {
            System.out.println("something went wrong");
        }


    }
}
