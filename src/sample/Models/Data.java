package sample.Models;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import sample.Main;
import sample.Models.Book;

public class Data {
    public static ObservableList<Book> bookInfo = FXCollections.observableArrayList();

    public static ObservableList<Book> getBookInfo() {
        return bookInfo;
    }

    public static void initialize() {
        Book b1 = new Book("Alexander Dumas", "Action and Adventure", "The Three Musketeers",2);
        Book b2 = new Book("Harper Lee", "Classics", "To Kill A Mockingbird",4);
        Book b3 = new Book("Louisa Sullivan", "Classics", "Little Women",3);
        Book b4 = new Book("Madeline Miller", "Fantasy", "Circe");
        Book b5 = new Book("Kathryn Stockett", "Historical Fiction", "The Help",2);
        Book b6 = new Book("Josh Malerman", "Horror", "Bird Box",1);
        Book b7 = new Book("Sarah Maclean", "Romance", "Brazen and the Beast", 3);
        Book b8 = new Book("George R.R. Martin", "Fantasy", "Game of Thrones", 8);
        Book b9 = new Book("Brandon Sanderson", "Fantasy", "The Way of Kings", 2);
        Book b10 = new Book("Paul Tremblay", "Horror", "A Head Full of Ghosts", 9);
        Book b11 = new Book("Clive Barker", "Horror", "The Damnation Game", 4);
        Book b12 = new Book("Sue Monk Kidd", "Historical Fiction", "The Book of Longings", 6);
        Book b13 = new Book("Walter Scott", "Action and Adventure", "Ivanhoe", 6);
        Book b14 = new Book("Emily Brontë", "Romance", "Wuthering Heights", 1);
        Book b15 = new Book("William Shakespeare", "Romance", "Romeo and Juliet", 2);
        Book listOfBooks[] = {b1, b2, b3, b4, b5, b6,b7, b8, b9, b10, b11, b12, b13, b14, b15};

        for (int i = 0; i < listOfBooks.length; i++) {

            Main.arrayList.add(listOfBooks[i]);
            bookInfo.addAll(listOfBooks[i]);
            Main.stack.push(listOfBooks[i]);
            Main.binaryTree.insertion(listOfBooks[i]);
        }

    }
}
