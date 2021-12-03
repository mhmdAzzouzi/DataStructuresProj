package sample.Controllers;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import sample.Controllers.Items.BookItem;
import sample.DataStructures.Queue;
import sample.DataStructures.Stack;
import sample.Main;
import sample.Models.Book;
import sample.Models.Data;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ViewLatestAdditions {

//
//    @FXML
//    TableColumn<Book, String> authorColumn, titleColumn, genreColumn;
//    @FXML
//    TableColumn<Book, Integer>idColumn , quantityColumn;

    @FXML
    TableView<Book> latestAdditionsTable;
    @FXML
    ScrollPane scrollPane;
    @FXML
    VBox listBox;
    @FXML
    TextField searchField;
    @FXML
    Label messageLabel, loggedinAs;

    Queue queueToView = Main.queue.copy();

    public void searchItem() throws Exception {
        System.out.println(searchField.getText());
        if (searchField.getText().length() > 0) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/sample/View/Search.fxml"));
            Parent page = loader.load();
            Search controller = loader.getController();
            controller.searchItem(Integer.parseInt(searchField.getText()));
            Main.switchScene(page);
        }
    }

    public void filterAll() throws IOException {
        drawList();
    }

    public void filterByLatest() throws IOException {
        Main.queue.display();
        listBox.getChildren().clear();
        if (Main.queue.length() == 0) {
            listBox.getChildren().add(messageLabel);
        }
        for (int i = 0; i < Main.queue.length(); i++) {
            Book book = queueToView.dequeue();
            String author = book.getAuthor();
            String title = book.getTitle();
            String genre = book.getGenre();
            String quantity = String.valueOf(book.getQuantity());
            int rating = Main.arrayList.get(i).getRating();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/sample/View/Items/BookItem.fxml"));
            Parent component = loader.load();
            BookItem bookItem = loader.getController();
            bookItem.setItems(title, genre, author, quantity, rating);
            listBox.getChildren().add(component);
        }
    }

    public void drawList() throws IOException {
        System.out.println(Main.arrayList.size());
        listBox.getChildren().clear();
        for (int i = 0; i < Main.arrayList.size(); i++) {

            String author = Main.arrayList.get(i).getAuthor();
            String title = Main.arrayList.get(i).getTitle();
            String genre = Main.arrayList.get(i).getGenre();
            String quantity = String.valueOf(Main.arrayList.get(i).getQuantity());
            int rating = Main.arrayList.get(i).getRating();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/sample/View/Items/BookItem.fxml"));
            Parent component = loader.load();
            BookItem bookItem = loader.getController();
            bookItem.setItems(title, genre, author, quantity, rating);
            listBox.getChildren().add(component);
        }
    }

    @FXML
    public void initialize() throws IOException {

        loggedinAs.setText(String.valueOf(Main.loggedIn.getName()));

//        this.authorColumn.setCellValueFactory(new PropertyValueFactory<>("author"));
//        this.genreColumn.setCellValueFactory(new PropertyValueFactory<>("genre"));
//        this.titleColumn.setCellValueFactory(new PropertyValueFactory<>("title"));
//        this.quantityColumn.setCellValueFactory(new PropertyValueFactory<>("quantity"));
//        this.idColumn.setCellValueFactory(new PropertyValueFactory<>("ID"));
//        setTable();
        drawList();
    }
    public void viewFriends() throws IOException{
        FXMLLoader loader= new FXMLLoader(getClass().getResource("/sample/View/Friends.fxml"));
        Parent root= loader.load();
        Main.switchScene(root);
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
