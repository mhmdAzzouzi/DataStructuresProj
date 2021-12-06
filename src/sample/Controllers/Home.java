//package sample.Controllers;
//
//import javafx.event.ActionEvent;
//import javafx.fxml.FXML;
//import javafx.fxml.FXMLLoader;
//import javafx.scene.Parent;
//import javafx.scene.control.Button;
//import javafx.scene.control.Label;
//import javafx.scene.control.TextField;
//import sample.DataStructures.Stack;
//import sample.Main;
//import sample.Models.Data;
//import sample.Models.User;
//
//import javax.naming.ldap.Control;
//import java.io.IOException;
//import java.util.ArrayList;
//
//public class Home {
//
//    @FXML
//    TextField searchField;
//    @FXML
//    Label loggedinAs;
//    @FXML
//    Label friendsNumber;
//
//    public static SignUp signup = new SignUp();
//    public static Authentication login = new Authentication();
//
//    public void searchItem() throws Exception {
//        System.out.println(searchField.getText());
//        if (searchField.getText().length() > 0) {
//            FXMLLoader loader = new FXMLLoader(getClass().getResource("/sample/View/Search.fxml"));
//            Parent page = loader.load();
//            Search controller = loader.getController();
//            controller.searchItem(Integer.parseInt(searchField.getText()));
//            Main.switchScene(page);
//        }
//    }
//
//    @FXML
//    public void initialize() throws IOException {
//        Main.restoreSize();
//        ArrayList<User> filtered = new ArrayList<>(Main.loggedIn.friendsList);
//        filtered.removeIf(user -> Main.loggedIn == user);
//        if (filtered.size() > 0) {
//            friendsNumber.setText(String.valueOf(filtered.size()));
//        } else {
//            friendsNumber.setText("0");
//        }
////        System.out.println(Main.loggedIn.getFriendsList());
//        try {
//
//            loggedinAs.setText(String.valueOf(Main.loggedIn.getName()));
//            System.out.println(Main.loggedIn.friendsList.get(0));
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    // navigation functionality !-------
//
//    public void viewFriends() throws IOException {
//        FXMLLoader loader = new FXMLLoader(getClass().getResource("/sample/View/Friends.fxml"));
//        Parent root = loader.load();
//        Main.switchScene(root);
//    }
//
//    public void navigate(ActionEvent event) throws IOException {
//        Button b1 = (Button) event.getTarget();
//        try {
//            if ("addBook".equals(b1.getId())) {
//                FXMLLoader page = new FXMLLoader(getClass().getResource("/sample/View/AddBook.fxml"));
//                Parent root = page.load();
//                Main.switchScene(root);
//
//
//            } else if ("BookStacks".equals(b1.getId())) {
//                FXMLLoader page2 = new FXMLLoader(getClass().getResource("/sample/View/BookStacks.fxml"));
//                Parent root1 = page2.load();
//                Main.switchScene(root1);
//
//            } else if ("ViewLatestAdditions".equals(b1.getId())) {
//                FXMLLoader page2 = new FXMLLoader(getClass().getResource("/sample/View/ViewLatestAdditions.fxml"));
//                Parent root1 = page2.load();
//                Main.switchScene(root1);
//            } else if ("ViewOtherReaders".equals(b1.getId())) {
//                FXMLLoader page2 = new FXMLLoader(getClass().getResource("/sample/View/ViewOtherReaders.fxml"));
//                Parent root1 = page2.load();
//                Main.switchScene(root1);
//            }else if ("logout".equals(b1.getId())) {
//                FXMLLoader page2 = new FXMLLoader(getClass().getResource("/sample/View/SignUp.fxml"));
//                Parent root1 = page2.load();
//                Main.restoreSize2();
//
//                Main.switchScene(root1);
//            }
//        } catch (Exception e) {
//            System.out.println("something went wrong");
//        }
//
//
//    }
//
//}
