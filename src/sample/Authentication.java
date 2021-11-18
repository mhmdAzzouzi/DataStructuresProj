package sample;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class Authentication {
    @FXML
    TextField id, password;

    public void loginAction(){
        if(id.getText().length()<=0){
            System.out.println("please enter your ID");
        }else if(password.getText().length() <=0){
            System.out.println("please enter your Password");
        }else{
            System.out.println("You are logged in");
        }
    }

    public void closeAction(){

    }
}
