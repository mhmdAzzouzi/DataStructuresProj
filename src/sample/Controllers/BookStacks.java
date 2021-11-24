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
import sample.Models.Book;

import javax.xml.soap.Text;
import java.io.IOException;

public class BookStacks {

    @FXML
    Label idLabel, titleLabel, authorLabel, quantityLabel, genreLabel;
    @FXML
    TextField searchField;

    Stack stackPreserve = new Stack();
    Stack stackToView = Main.stack.copy();

    public void searchItem() throws Exception {
        System.out.println(searchField.getText());
        if(searchField.getText().length() > 0){
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/sample/View/Search.fxml"));
            Parent page = loader.load();
            Main.switchScene(page);
        }
    }

    public void popFromCard(){
        try{

                if(!stackPreserve.isEmpty()){


                stackToView.push(stackPreserve.pop());
                Book popedBook = stackPreserve.getHead();


                if (popedBook != null) {
                    idLabel.setText(String.valueOf(popedBook.getID()));
                    quantityLabel.setText(String.valueOf(popedBook.getQuantity()));
                    titleLabel.setText(popedBook.getTitle());
                    authorLabel.setText(popedBook.getAuthor());
                    genreLabel.setText(popedBook.getGenre());

                }
                }





        }catch (Exception e){
            System.out.println("error in popFrom Card");
        }
    }

    public void pushToCard(){
        try{



                if(!stackToView.isEmpty()){


                Book popedBook = stackToView.getHead();


            if(popedBook != null){
                idLabel.setText(String.valueOf(popedBook.getID()));
                quantityLabel.setText(String.valueOf(popedBook.getQuantity()));
                titleLabel.setText(popedBook.getTitle());
                authorLabel.setText(popedBook.getAuthor());
                genreLabel.setText(popedBook.getGenre());
                stackPreserve.push(stackToView.pop());
            }
                }



        }catch (Exception e){
            System.out.println("error from push to card!!");
        }

    }


    public void navigate(ActionEvent event) throws IOException {
    Button b1= (Button) event.getTarget();
    try{
        if ("addBook".equals(b1.getId())) {
            FXMLLoader page = new FXMLLoader(getClass().getResource("/sample/View/AddBook.fxml"));
            Parent root = page.load();
            Main.switchScene(root);

        } else if ("BookStacks".equals(b1.getId())) {
            FXMLLoader page2 = new FXMLLoader(getClass().getResource("/sample/View/BookStacks.fxml"));
            Parent root1 = page2.load();
            Main.switchScene(root1);
        }else if("ViewLatestAdditions".equals(b1.getId())){
            FXMLLoader page2 = new FXMLLoader(getClass().getResource("/sample/View/ViewLatestAdditions.fxml"));
            Parent root1 = page2.load();
            Main.switchScene(root1);
        }else if("ViewOtherReaders".equals(b1.getId())){
            FXMLLoader page2 = new FXMLLoader(getClass().getResource("/sample/View/ViewOtherReaders.fxml"));
            Parent root1 = page2.load();
            Main.switchScene(root1);
        }
    }catch (Exception e){
        System.out.println("something went wrong");
    }


}
}
