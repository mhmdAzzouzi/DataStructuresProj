package sample.Controllers;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import sample.Main;
import sample.Models.Book;
import sample.Models.Data;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ViewLatestAdditions implements Initializable {


    @FXML
    TableColumn<Book, String> authorColumn, titleColumn, genreColumn;
    @FXML
    TableColumn<Book, Integer> idColumn, quantityColumn;

    @FXML
    TableView<Book> latestAdditionsTable;

    public void initialize(URL location, ResourceBundle resourceBundle) {
        this.authorColumn.setCellValueFactory(new PropertyValueFactory<>("author"));
        this.genreColumn.setCellValueFactory(new PropertyValueFactory<>("genre"));
        this.titleColumn.setCellValueFactory(new PropertyValueFactory<>("title"));
        this.quantityColumn.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        this.idColumn.setCellValueFactory(new PropertyValueFactory<>("ID"));
        setTable();
    }

    public void setTable() {
        this.latestAdditionsTable.setItems(Data.bookInfo);
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
