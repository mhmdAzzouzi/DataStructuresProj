package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;

public class Authentication {
    @FXML
    TextField id, password;
    @FXML
    Label errorMessage;

    public void loginAction() throws IOException {
        if (id.getText().length() <= 0) {
//            System.out.println("please enter your ID");
            errorMessage.setText("Invalid ID");
        } else if (password.getText().length() <= 0) {
            errorMessage.setText("Invalid Password");
//            System.out.println("please enter your Password");
        } else {
//            System.out.println("You are logged in");
            Data.initialize();
            FXMLLoader loginPage = new FXMLLoader(getClass().getResource("HomeScreen.fxml"));
            Parent root = loginPage.load();
//            Main m = new Main();

            Main.switchScene(root);
        }
    }

    public void closeAction() {

    }
}
