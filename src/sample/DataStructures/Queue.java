package sample.DataStructures;

import sample.Models.Book;

public class Queue extends LinkedList {


    public void enqueue(Book b1){
            addLast(b1);
    }

    public Book dequeue(){
        Book temp = tail.book;
        deleteFirst();
        return temp;
    }

    public void display(){
        super.display();
    }
}
