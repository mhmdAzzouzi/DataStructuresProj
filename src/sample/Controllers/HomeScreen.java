package sample.Controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import sample.Models.Book;
import sample.Models.Data;
import sample.Main;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class HomeScreen implements Initializable {

    @FXML
    TextField author, genre, title, quantity;

    @FXML
    Label errorAddBooksMessage;
    @FXML
    TableColumn<Book, Object> authorColumn, genreColumn, titleColumn, quantityColumn;
    //    @FXML
//    TableColumn<Book,Integer> quantityColumn;
    @FXML
    TableView<Book> displayTable;

    static ObservableList<Book> book = FXCollections.observableArrayList();

    public void addBook() {
        try {
            String authorText = author.getText();
            String genreText = genre.getText();
            String titleText = title.getText();
//            int quantityText = Integer.parseInt(quantity.getText());
            Main.linkedlist.addFirst(new Book(authorText, genreText, titleText));
        } catch (Exception e) {
            errorAddBooksMessage.setText("Invalid Input");
//            System.out.println("TRY AGAIN");
        }
    }

    public void initialize(URL location, ResourceBundle resourceBundle) {
        this.authorColumn.setCellValueFactory(new PropertyValueFactory<>("author"));
        this.genreColumn.setCellValueFactory(new PropertyValueFactory<>("genre"));
        this.titleColumn.setCellValueFactory(new PropertyValueFactory<>("title"));
        this.quantityColumn.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        displayInfo();
    }

    public void displayInfo() {
        book = Data.getBookInfo();
        this.displayTable.setItems(book);
    }

    public void backToLogin() throws IOException {
        FXMLLoader back = new FXMLLoader(getClass().getResource("View/Authentication.fxml"));
        Parent root = back.load();
        Main.switchScene(root);
    }

}
