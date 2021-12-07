package sample.DataStructures;

import sample.Models.Book;

public class Queue extends LinkedList {


    public void enqueue(Book b1){
            addLast(b1);
    }

    public Book dequeue(){
        Book temp = head.book;
        deleteFirst();
        return temp;
    }

    public Queue copy(){
        if(!this.isEmpty()){
            Queue q1 = new Queue();
            Queue q2 = new Queue();
            while(!this.isEmpty()){
                Book temp = this.dequeue();
                q1.enqueue(temp);
                q2.enqueue(temp );
            }
            while(!q1.isEmpty()){
                this.enqueue(q1.dequeue());
            }
            return q2;
        }
        return null;
    }

    public void deleteBook(int id){
        if(!this.isEmpty()){
            Queue temp = new Queue();
            Book idToCheck = this.dequeue();
            temp.enqueue(idToCheck);
            while( idToCheck.getID() != id && !this.isEmpty()){
                Book b =this.dequeue();
                idToCheck=b;
                temp.enqueue(b);
            }
            temp.dequeue();
            while(!temp.isEmpty()){
                this.enqueue(temp.dequeue());
            }
        }
    }

    public void reverse(){
        Queue q1 = new Queue();
        Queue q2 = new Queue();
        while(!this.isEmpty()){
            Book temp = this.dequeue();
            q1.enqueue(temp);
        }
        System.out.print("queue 1 ");
        q1.display();
        while(!q1.isEmpty()){
            q2.enqueue(q1.dequeue());
        }
        while(!q2.isEmpty()){
            this.enqueue(q2.dequeue());
        }
    }

    public void display(){
        super.display();
    }
}
