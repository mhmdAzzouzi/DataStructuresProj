package sample.Models;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import sample.Models.Book;

public class Librarian {

    public Librarian() {
    }

    public static ObservableList<Book> bookInfo = FXCollections.observableArrayList();

    public ObservableList<Book> getBookInfo() {
        return bookInfo;
    }

}
