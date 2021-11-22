package sample.Controllers.Items;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

public class BookItem {
    @FXML
    HBox ratingBox;
    @FXML
    Label titleLabel, idLabel, authorLabel,quantityLabel;

    public void setItems(String title,String  id, String author,String quantity){
        try{
            titleLabel.setText(title);
            idLabel.setText(id);
            authorLabel.setText(author);
            quantityLabel.setText(quantity);
        }catch (Exception e){
            titleLabel.setText("12");
            idLabel.setText("!2");
            authorLabel.setText("12");
            quantityLabel.setText("!2");
        }

    }
}
