package sample.Models;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import sample.Main;
import sample.Models.Book;

import java.util.ArrayList;
import java.util.Arrays;

public class Data {
    public static ObservableList<Book> bookInfo = FXCollections.observableArrayList();

    public static ObservableList<Book> getBookInfo() {
        return bookInfo;
    }


    public static void load() {
        Book b1 = new Book("Alexander Dumas", "Action and Adventure", "The Three Musketeers", 2, 5);
        Book b2 = new Book("Harper Lee", "Classics", "To Kill A Mockingbird", 4, 3);
        Book b3 = new Book("Louisa Sullivan", "Classics", "Little Women", 3, 5);
        Book b4 = new Book("Madeline Miller", "Fantasy", "Circe");
        Book b5 = new Book("Kathryn Stockett", "Historical Fiction", "The Help", 2);
        Book b6 = new Book("Josh Malerman", "Horror", "Bird Box", 1, 3);
        Book b7 = new Book("Sarah Maclean", "Romance", "Brazen and the Beast", 3, 5);
        Book b8 = new Book("George R.R. Martin", "Fantasy", "Game of Thrones", 8, 5);
        Book b9 = new Book("Brandon Sanderson", "Fantasy", "The Way of Kings", 2, 3);
        Book b10 = new Book("Paul Tremblay", "Horror", "A Head Full of Ghosts", 9, 4);
        Book b11 = new Book("Clive Barker", "Horror", "The Damnation Game", 4, 4);
        Book b12 = new Book("Sue Monk Kidd", "Historical Fiction", "The Book of Longings", 6);
        Book b13 = new Book("Walter Scott", "Action and Adventure", "Ivanhoe", 6);
        Book b14 = new Book("Emily Brontë", "Romance", "Wuthering Heights", 1);
        Book b15 = new Book("William Shakespeare", "Romance", "Romeo and Juliet", 2);

        Book listOfBooks[] = {b1, b2, b3, b4, b5, b6, b7, b8, b9, b10, b11, b12, b13, b14, b15};
        for (int i = 0; i < listOfBooks.length; i++) {
            Main.arrayList.add(listOfBooks[i]);
            bookInfo.addAll(listOfBooks[i]);
            Main.stack.push(listOfBooks[i]);
            Main.binaryTree.insertion(listOfBooks[i]);
        }
        User ahmad = new User("Ahmad", "1", "ahmad@gmail.com");
        User khaled = new User("khaled", "2", "khaledkh@gmail.com");
        User salem = new User("Salem", "3", "s.salem@gmail.com");
        User omar = new User("omar", "4", "omari@gmail.com");
        User mariam = new User("Mariam", "5", "mariam.m@gmail.com");
        User salma = new User("Salma", "6", "salma.s@gmail.com");
        User jihan = new User("Jihan", "041803", "jihanfarhatt@gmail.com");
        User mo = new User("MohammadAzzouzi", "123456", "mhmdazzouzi@gmail.com", "Librarian");
        User nour = new User("Nour", "021602", "nourchreideh@gmail.com");

        mo.friendsList.addAll(Arrays.asList(jihan, nour, salem));
        jihan.friendsList.addAll(Arrays.asList(nour, mo, ahmad,omar)); // khaled salem salma mariam
        nour.friendsList.addAll(Arrays.asList(mo, khaled, omar, salma, jihan));
        ahmad.friendsList.addAll(Arrays.asList(nour, mo, jihan));
        salem.friendsList.add(mo);
        khaled.friendsList.addAll(Arrays.asList(nour,salma));
        omar.friendsList.add(jihan);
        salma.friendsList.addAll(Arrays.asList(nour,khaled));


        System.out.println("Jihan's Friends: "+jihan.friendsList);

        System.out.println("you have friends = " + mo.getFriendsList().size());
        User[] users = {jihan, mo, nour, ahmad, khaled, mariam,salem,salma,omar};
        Main.userList.addAll(Arrays.asList(users));
    }

    public static Book deleteFromArrayList(int id) {
        Book deletedBook = null;
        for (int i = 0; i < Main.arrayList.size(); i++) {
            if (Main.arrayList.get(i).getID() == id) {
                deletedBook = Main.arrayList.get(i);
                Main.arrayList.remove(i);
            }
        }
        if (deletedBook != null)
            return deletedBook;
        else
            System.out.println("no book with that id exists");
        return null;
    }

    public static void display() {
        for (int i = 0; i < Main.arrayList.size(); i++) {
            System.out.println(Main.arrayList.get(i));
        }
    }
}
