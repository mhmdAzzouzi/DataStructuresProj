package sample.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import sample.Controllers.Items.BookCard;
import sample.Main;
import sample.Models.Book;

import javax.xml.soap.Text;
import java.io.IOException;

public class Search {
    @FXML
    TextField searchField;

    @FXML
    Label loggedinAs;

    @FXML
    VBox cardposition;

    static boolean found;


    public void initialize() throws  IOException {
        loggedinAs.setText(String.valueOf(Main.loggedIn.getName()));

    }

    public void searchItem(int id) throws IOException {
       Book book = Main.binaryTree.search(id);
       if(book !=null){

           FXMLLoader loader = new FXMLLoader(getClass().getResource("/sample/View/Items/book card.fxml"));
           Parent root=  loader.load();
           BookCard cardController = loader.getController();
           cardController.setLabels(String.valueOf(book.getID()), book.getTitle(),book.getAuthor(),String.valueOf(book.getQuantity()),book.getGenre());
           cardposition.getChildren().clear();
           cardposition.getChildren().add(root);
       }else{
           found = false;
           Label label = new Label();
           cardposition.getChildren().clear();
           label.setText("Book not found ...");
           cardposition.getChildren().add(label);
       }
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

    public void searchItem() throws Exception {
      searchItem(Integer.parseInt(searchField.getText()));
    }
}
