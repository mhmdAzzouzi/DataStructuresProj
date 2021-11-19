package sample;

public class LinkedList {
    protected class Node{
        Book book;
        Node next;
        public Node(Book book) {
            this.book = book;
        }
    }
    Node head;
    Node tail;
    int size;

    public LinkedList() {
        head = null;
    }

    public boolean isEmpty(){
        return head==null;
    }

    public void addFirst(Book b1){
        Node obj = new Node(b1);
        if(isEmpty()){
            head= obj;
            tail =obj;
        }else{
            obj.next= head;
            head= obj;
        }
        size++;
    }

    public void addLast(Book b1){
        Node obj = new Node(b1);
        if(isEmpty()){
            head=obj;
            tail=obj;
        }else{
            tail.next= obj;
            tail= obj;
        }
        size++;
    }

    public void deleteFirst(){
        if(!isEmpty()){
            head= head.next;
            size--;
        }
    }


    public void display(){
        if(!isEmpty()){
            Node itr= head;
            while(itr !=null){
                System.out.println(itr.book);
                itr = itr.next;
            }
        }
    }

    public int length(){
        return size;
    }
}
