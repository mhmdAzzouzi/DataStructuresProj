package sample.Controllers;

import com.sun.xml.internal.bind.XmlAccessorFactory;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import sample.Main;
import sample.Models.User;

import java.io.IOException;

public class SignUp {
    @FXML
    TextField nameText, passwordText, emailText;
    @FXML
    Label errorMessage;
    @FXML
    CheckBox checkBox;

    static String name;

    public void signUpAction() throws IOException {
        name = nameText.getText();
        String password = passwordText.getText();
        String email = emailText.getText();
        try {
            if (name.length() <= 0) {
                errorMessage.setText("Please enter a valid name");
            } else if (email.length() <= 0) {
                errorMessage.setText("Please enter a valid email");
            } else if (password.length() <= 0 || password.length() < 5) {
                errorMessage.setText("Please enter a valid password");
            } else {
                try {
                    if ((checkBox.isSelected())) {
                        User user = new User(name, password, email);
                        Main.userList.add(user);
                        Main.loggedIn = user;
                        FXMLLoader home = new FXMLLoader(getClass().getResource("/sample/View/Home.fxml"));
                        Parent root = home.load();
                        Main.restoreSize();
                        Main.switchScene(root);
                    } else {
                        errorMessage.setText("Please accept our terms");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void backtologinAction() throws IOException {
        FXMLLoader home = new FXMLLoader(getClass().getResource("/sample/View/Authentication.fxml"));
        Parent root = home.load();
        Main.switchScene(root);

    }
}
