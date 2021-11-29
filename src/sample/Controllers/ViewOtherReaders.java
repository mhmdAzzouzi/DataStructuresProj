package sample.Controllers;

import animatefx.animation.Flip;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import sample.Controllers.Items.UserCard;
import sample.DataStructures.Stack;
import sample.Main;
import sample.Models.User;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

public class ViewOtherReaders {

    @FXML
    TextField searchField;
    @FXML
    FlowPane userCardFlowPane;
//    @FXML
//    HBox userCardBox;

    @FXML
    public void initialize() throws IOException {
        Main.restoreSize();
        ArrayList<User> filtered = Main.userList;
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
            userCard1.setLabels(u.getName(), u.getEmail(), u.getID());
            userCardFlowPane.getChildren().add(userCard);
//            userCardFlowPane.setHgap(15);
//            userCardFlowPane.setVgap(15);
        }
    }

    public void searchItem() throws Exception {
        System.out.println(searchField.getText());
        if (searchField.getText().length() > 0) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/sample/View/Search.fxml"));
            Parent page = loader.load();
            Search controller = loader.getController();
            controller.searchItem(Integer.parseInt(searchField.getText()));
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
            }
        } catch (Exception e) {
            System.out.println("something went wrong");
        }


    }
}
