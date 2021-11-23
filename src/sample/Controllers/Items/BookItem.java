package sample.Controllers.Items;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

public class BookItem {
    @FXML
    HBox ratingBox;
    @FXML
    Label titleLabel, genreLabel, authorLabel,quantityLabel;

    public void setItems(String title,String  genre, String author,String quantity){
        try{
            titleLabel.setText(title);
            genreLabel.setText(genre);
            authorLabel.setText(author);
            quantityLabel.setText(quantity);
        }catch (Exception e){
            titleLabel.setText("12");
            genreLabel.setText("!2");
            authorLabel.setText("12");
            quantityLabel.setText("!2");
        }

    }
}
