package sample;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class HomeScreen {

    @FXML
    TextField author, genre, title, quantity;

    public void addBook() {
        try {
            String authorText = author.getText();
            String genreText = genre.getText();
            String titleText = title.getText();
            int quantityText = Integer.parseInt(quantity.getText());
            Main.linkedlist.addFirst(new Book(authorText, genreText, titleText, quantityText));
        } catch (Exception e) {
            System.out.println("TRY AGAIN");
        }
    }

    public void display() {
        Main.linkedlist.display();
    }

}
