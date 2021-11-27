package sample.Controllers.Items;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.io.IOException;


public class BookCard {
    @FXML
    Label idLabel ,titleLabel,authorLabel,quantityLabel,genreLabel;

     public void setLabels(String id,String title,String author, String quantity,String genre)  {
         idLabel.setText(id);
         titleLabel.setText(title);
         authorLabel.setText(author);
         quantityLabel.setText(quantity);
         genreLabel.setText(genre);

     }
}
