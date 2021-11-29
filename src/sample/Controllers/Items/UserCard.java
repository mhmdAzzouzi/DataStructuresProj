package sample.Controllers.Items;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class UserCard {

    @FXML
    Label usernameLabel, idLabel, emailLabel, friendsNumberLabel;

    public void setLabels(String name, String email, int id) {
        usernameLabel.setText(name);
        emailLabel.setText(email);
        idLabel.setText((String.valueOf(id)));
    }

    public void addFriend() {

    }

}
