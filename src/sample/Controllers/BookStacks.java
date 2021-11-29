package sample.Controllers;

import animatefx.animation.FadeIn;
import animatefx.animation.Flip;
import animatefx.animation.FlipInX;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import sample.Controllers.Items.BookCard;
import sample.DataStructures.Stack;
import sample.Main;
import sample.Models.Book;

import javax.xml.soap.Text;
import java.io.IOException;

public class BookStacks {
    

    @FXML
    TextField searchField;
    Stack stackPreserve = new Stack();
    Stack stackToView = Main.stack.copy();

    @FXML
    VBox cardposition;

    @FXML
    public void initialize() throws IOException {
        pushToCard();
    }

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

    public void popFromCard() throws IOException{

            try{

                if(!stackPreserve.isEmpty() && stackPreserve.length() > 1) {


                    stackToView.push(stackPreserve.pop());
                    Book popedBook = stackPreserve.getHead();

                    System.out.println(popedBook);
                    if (popedBook != null) {
                        cardposition.getChildren().clear();
                        FXMLLoader loader = new FXMLLoader(getClass().getResource("/sample/View/Items/book card.fxml"));
                        Parent bookCard = loader.load();
                        BookCard b1 = loader.getController();
                        b1.setLabels(String.valueOf(popedBook.getID()), popedBook.getTitle(), popedBook.getAuthor(), String.valueOf(popedBook.getQuantity()), popedBook.getGenre());
//                        new Flip(bookCard).play();
                        cardposition.getChildren().add(bookCard);

                    }
                }
            }catch (Exception e){
                System.out.println("hello :) there was an issue popping a card");
//                e.printStackTrace();
            }
    }

    public void pushToCard() throws IOException {

                if(!stackToView.isEmpty()){

                    Book popedBook = stackToView.getHead();

                    if(popedBook != null) {
                        stackPreserve.push(stackToView.pop());
                        FXMLLoader loader = new FXMLLoader(getClass().getResource("/sample/View/Items/book card.fxml"));
                        Parent bookCard = loader.load();
                        BookCard b1 = loader.getController();
                        cardposition.getChildren().clear();
                        b1.setLabels(String.valueOf(popedBook.getID()), popedBook.getTitle(), popedBook.getAuthor(), String.valueOf(popedBook.getQuantity()), popedBook.getGenre());
                        cardposition.getChildren().add(bookCard);
//                        new Flip(bookCard).play();

                    }
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
