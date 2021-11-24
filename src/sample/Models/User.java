package sample.Models;

import java.time.LocalDate;

public class User {
    String type;
    String name;
    String lastName;
    String ID;
    String password;
    LocalDate date;

    public User(String type, String name, String lastName, String ID, String password) {
        this.type = type;
        this.name = name;
        this.lastName = lastName;
        this.ID = ID;
        this.password = password;
        date = LocalDate.now();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

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
                "type='" + type + '\'' +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", ID='" + ID + '\'' +
                ", password='" + password + '\'' +
                ", date=" + date +
                '}';
    }
}
