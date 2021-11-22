package sample.DataStructures;

import sample.Models.Book;

public class Stack extends LinkedList {





    public Stack copy(){
        Stack s1 = new Stack();
        Stack s2 = new Stack();
        while(!this.isEmpty()){
            Book temp = this.pop();
            s1.push(temp);
            s2.push(temp);
        }
        while(!s1.isEmpty()){
            this.push(s1.pop());
        }
//        this.reverse();
        s2.reverse();
        return s2;
    }

    public void reverse(){
        if(!this.isEmpty()) {
            Stack tmpStack = new Stack();
            Stack tmpStack2 = new Stack();
            while (!this.isEmpty()) {
                Book temp = this.pop();
                tmpStack.push(temp);
            }
            while (!tmpStack.isEmpty()) {
                Book temp = tmpStack.pop();
                tmpStack2.push(temp);
            }
            while (!tmpStack2.isEmpty()) {
                Book temp = tmpStack2.pop();
                this.push(temp);
            }
        }
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
