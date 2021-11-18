package sample;

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
