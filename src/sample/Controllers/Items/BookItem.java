package sample.Controllers.Items;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

public class BookItem {
    @FXML
    HBox ratingBox;
    @FXML
    Label titleLabel, genreLabel, authorLabel, quantityLabel;

    public void setItems(String title, String genre, String author, String quantity, int rating) {
        try {
            titleLabel.setText(title);
            genreLabel.setText(genre);
            authorLabel.setText(author);
            quantityLabel.setText(quantity);

            for (int i = 0; i < rating; i++) {
                Image image = new Image(getClass().getResourceAsStream("/sample/images/icons8_star_48px.png"));
                ImageView imageView = new ImageView(image);
                imageView.setFitWidth(15);
                imageView.setFitHeight(15);
                ratingBox.getChildren().add(imageView);
            }

        } catch (Exception e) {
            titleLabel.setText("12");
            genreLabel.setText("!2");
            authorLabel.setText("12");
            quantityLabel.setText("!2");
        }

    }
}
