package sample.DataStructures;

import sample.Models.Book;

public class Stack extends LinkedList {

    public Stack() {

    }

    public void push(Book b1){
        addFirst(b1);
    }

    public Book pop(){
        if(!super.isEmpty()){
            Book temp = head.book;
            super.deleteFirst();
            return temp;
        }else{
            return null;
        }
    }

    public void display(){
        super.display();
    }

}
