package sample.Controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import sample.Models.Data;
import sample.Main;

import java.io.IOException;

public class Authentication {
    @FXML
    TextField id, password;
    @FXML
    Label errorMessage;

    public void loginAction() throws IOException {
        if (id.getText().length() <= 0) {
            errorMessage.setText("Invalid ID");
        } else if (password.getText().length() <= 0) {
            errorMessage.setText("Invalid Password");
        } else {
            Data.initialize();
            FXMLLoader loginPage = new FXMLLoader(getClass().getResource("/sample/View/Home.fxml"));
            Parent root = loginPage.load();
            Main.switchScene(root);
        }
    }

    public void closeAction() {

    }
}
