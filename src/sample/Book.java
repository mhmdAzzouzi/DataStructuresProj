package sample;

import java.time.LocalTime;

public class Book {
    String author;
    String genre;
    static int ID;
    String title;
    int quantity;
    LocalTime duration;

    public Book(String author, String genre, String title) {
        super();
        this.author = author;
        this.genre = genre;
        this.title = title;
    }

    public Book(String author, String genre, String title, int quantity) {
        this.author = author;
        this.genre = genre;
        this.title = title;
        ID++;
        this.quantity = quantity;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public static int getID() {
        return ID;
    }

    public static void setID(int ID) {
        Book.ID = ID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public LocalTime getDuration() {
        return duration;
    }

    public void setDuration(LocalTime duration) {
        this.duration = duration;
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
