package sample;

public class LinkedList {
    private class Node{
        Book book;
        Node next;
        public Node(Book book) {
            this.book = book;
        }
    }
    Node head;
    int size;

    public boolean isEmpty(){
        return head==null;
    }

    public void addFirst(Book b1){
        Node obj = new Node(b1);
        if(isEmpty()){
            head= obj;
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
        }else{
            Node itr = head;
            while(itr.next !=null){
                itr= itr.next;
            }
            itr.next = obj;
        }
        size++;
    }

    public void deleteFirst(){
        if(!isEmpty()){
            head= head.next;
            size--;
        }
    }

    public void deleteEnd(){
        if(!isEmpty()){
            if(size == 1 ){
                head = head.next;

            }else{
                Node itr = head;
                while(itr.next.next != null){
                    itr = itr.next;
                }
                itr.next= itr.next.next;
            }
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
