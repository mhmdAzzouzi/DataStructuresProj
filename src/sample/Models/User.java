package sample.Models;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;

public class User {
    String name;
    //    String lastName;
    int ID;
    String password;
    String email;
    LocalDate date;
    Random random = new Random();
    public static ArrayList<User> friendsList = new ArrayList<>();

    //    public User(String name ,String password) {
//        this.name = name;
////        this.lastName = lastName;
//        ID = random.nextInt(10000) + 1;
//        this.password = password;
//        date = LocalDate.now();
//    }

    public User(String name, String password, String email) {
        this.name = name;
        this.password = password;
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//    public String getLastName() {
//        return lastName;
//    }
//
//    public void setLastName(String lastName) {
//        this.lastName = lastName;
//    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "User{" +
                ", name='" + name + '\'' +
//                ", lastName='" + lastName + '\'' +
                ", ID='" + ID + '\'' +
                ", password='" + password + '\'' +
                ", date=" + date +
                '}';
    }
}
