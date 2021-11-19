package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Librarian {

    public Librarian() {
    }

    public static ObservableList<Book> bookInfo = FXCollections.observableArrayList();

    public ObservableList<Book> getBookInfo() {
        return bookInfo;
    }

}
