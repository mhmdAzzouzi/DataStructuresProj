package sample.Controllers.Items;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

public class UserCard {
    @FXML
    Label usernameLabel, idLabel, emailLabel, friendsNumberLabel;

    @FXML
    ImageView imageAdd;

    @FXML
    AnchorPane UserCardBox;


    public void setLabels(String name, String email, int id, int friendsNumber) {
        usernameLabel.setText(name);
        emailLabel.setText(email);
        friendsNumberLabel.setText((String.valueOf(friendsNumber)));
        idLabel.setText((String.valueOf(id)));
    }

    public void addFriend() {
        imageAdd.setImage(new Image("/sample/images/check.png"));
    }
}
