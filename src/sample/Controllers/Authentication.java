package sample.Controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sample.Models.Data;
import sample.Main;
import sample.Models.User;

import java.io.IOException;
import java.util.ArrayList;

public class Authentication {
    @FXML
    TextField nameText, passwordText;
    @FXML
    Label errorMessage;

    public static String name;
    public static ArrayList<User> users = Main.userList;
    public static Stage stage = Main.stage;

    public void loginAction() throws IOException {
        Data.load();
        name = nameText.getText();
        try {
            if (name.length() <= 0 || !name.matches("[A-Z][a-zA-Z]*")) {
                errorMessage.setText("Please enter a valid name");
            } else if (passwordText.getText().length() <= 0 || passwordText.getLength() < 5) {
                errorMessage.setText("Please enter a valid password");
            } else {
//                System.out.println("nope");
//                User u = users.get(0);
//                if (name == u.getName() && passwordText.getText() == u.getPassword()) {
//
//                    try {
                FXMLLoader loginPage = new FXMLLoader(getClass().getResource("/sample/View/Home.fxml"));
                Parent root = loginPage.load();
                Main.restoreSize();
                Main.switchScene(root);
//                    } catch (Exception e) {
//                        e.printStackTrace();
//                    }
//                    Main.binaryTree.DisplayInorder();
//                } else {
//                    errorMessage.setText("Create a new account");
//                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void closeAction() throws IOException {
        stage.close();
    }
}
