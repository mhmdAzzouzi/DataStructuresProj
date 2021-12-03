package sample.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import sample.DataStructures.Stack;
import sample.Main;
import sample.Models.Data;

import javax.naming.ldap.Control;
import java.io.IOException;

public class Home {

    @FXML
    TextField searchField;
    @FXML
    Label loggedinAs;

    public static SignUp signup = new SignUp();
    public static Authentication login = new Authentication();

    public void searchItem() throws Exception {
        System.out.println(searchField.getText());
        if (searchField.getText().length() > 0) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/sample/View/Search.fxml"));
            Parent page = loader.load();
            Search controller= loader.getController();
            controller.searchItem(Integer.parseInt(searchField.getText()));
            Main.switchScene(page);
        }
    }

    @FXML
    public void initialize() throws IOException {
        Main.restoreSize();

        try {
            String nameSignUp = signup.name;
            String nameLogIn = login.name;
            if (nameLogIn == null) {
                loggedinAs.setText(nameSignUp);
            } else {
                loggedinAs.setText(nameLogIn);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // navigation functionality !-------

    public void viewFriends() throws IOException{
        FXMLLoader loader= new FXMLLoader(getClass().getResource("/sample/View/Friends.fxml"));
        Parent root= loader.load();
        Main.switchScene(root);
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
