package sample.Controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import sample.Main;
import sample.Models.User;

import java.io.IOException;

public class Authentication {
    @FXML
    TextField nameText;
    @FXML
    PasswordField passwordText;
    @FXML
    Label errorMessage;

    public static String name;

    public void loginAction() throws IOException {

        name = nameText.getText();
        try {
            if (name.length() <= 0) {
                errorMessage.setText("Please enter a valid name");
            } else if (passwordText.getText().length() <= 0 || passwordText.getLength() < 5) {
                errorMessage.setText("Please enter a valid password");
            } else {
                User found = null;
                for (int i = 0; i < Main.userList.size(); i++) {
                    User userToFind = Main.userList.get(i);
                    if (userToFind.getName().equals(name)) {
                        found = Main.userList.get(i);
                        Main.loggedIn = found;
                        break;
                    }
                }
                if (found != null && found.getPassword().equals(passwordText.getText())) {
                    FXMLLoader loginPage = new FXMLLoader(getClass().getResource("/sample/View/ViewLatestAdditions.fxml"));
                    Parent root = loginPage.load();
                    Main.restoreSize();
                    Main.switchScene(root);
                } else if (found == null) {
                    errorMessage.setText("User Not found");
                } else if (!found.getPassword().equals(passwordText.getText())) {
                    errorMessage.setText("Wrong User's name or Password");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void closeAction() throws IOException {
        FXMLLoader home = new FXMLLoader(getClass().getResource("/sample/View/SignUp.fxml"));
        Parent root = home.load();
        Main.switchScene(root);
    }
}
