package sample;

import java.time.LocalTime;

public class Book {
    String author;
    String genre;
    static int ID;
    String title;
    int quantity;
    LocalTime duration;

    public Book(String author, String genre, String title, int quantity) {
        this.author = author;
        this.genre = genre;
        this.title = title;
        ID++;
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Book{" +
                "author='" + author + '\'' +
                ", genre='" + genre + '\'' +
                ", title='" + title + '\'' +
                ", quantity=" + quantity +
                ", duration=" + duration +
                '}';
    }
}
