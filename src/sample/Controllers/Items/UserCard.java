package sample.Controllers.Items;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import sample.Controllers.Friends;
import sample.Controllers.ViewOtherReaders;
import sample.Main;
import sample.Models.User;

import java.io.IOException;

public class UserCard {
    @FXML
    Label usernameLabel, idLabel, emailLabel, friendsNumberLabel;

    @FXML
    ImageView imageAdd;

    @FXML
    public Button addButton;
    @FXML
    AnchorPane UserCardBox;


    public void setLabels(String name, String email, int id, int friendsNumber, boolean isFriend) {
        usernameLabel.setText(name);
        emailLabel.setText(email);
        friendsNumberLabel.setText((String.valueOf(friendsNumber)));
        idLabel.setText((String.valueOf(id)));
        if (isFriend) {
            imageAdd.setImage(new Image("/sample/images/check.png"));
        }
    }

//    @FXML
//    public void increment(Label number) {
//        number.setText(String.valueOf(Integer.parseInt(number.getText()) + 1));
//    }

    public void addFriend() throws IOException {
        imageAdd.setImage(new Image("/sample/images/check.png"));
        for (User user : Main.userList) {
            if (user.getID() == Integer.parseInt(idLabel.getText())) {
                Main.loggedIn.friendsList.add(user);
                addButton.setMouseTransparent(true);
                break;
            }
        }

    }
}
