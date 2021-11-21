package sample.DataStructures;

import sample.Models.Book;

public class BST {
    protected static class Node{
        Book book;
        Node left;
        Node right;

        public Node(Book book) {
            this.book = book;
        }

        public Node(Book book, Node left, Node right) {
            this.book = book;
            this.left = left;
            this.right = right;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "book=" + book +
                    '}';
        }
    }

    Node root;
    int size;

    public boolean isEmpty(){
        return root == null;
    }


    public void DisplayInorder(){
        inOrder(this.root);
    }

    public void insertion(Book b1){
        insert(root, b1);
    }

    public Node search(int ID){
        try{
            return searchTree(root, ID);
        }catch (Exception NullPointerException){
            return null;
        }
    }

    public Node searchTree(Node r, int ID){
        if(!isEmpty()){
           if (r.book.getID() == ID){
                return r;
            }else if(r.book.getID() >= ID){
               return searchTree(r.left, ID);
           }else{
               return searchTree(r.right, ID);
           }
        }else{
            return null;
        }
    }

    public Node insert(Node r , Book b1){
        if(r ==null){
            if(isEmpty()){
                this.root = new Node(b1);
            }else{
                r=new Node(b1);
            }
        }else{
            if(r.book.getID() >= b1.getID()){
                r.left = insert(r.left, b1);
            }else {
                r.right= insert(r.right, b1);
            }
        }
        return r;
    }

    public void inOrder(Node r){
        if(r !=null){
            inOrder(r.left);
            System.out.println(r.book);
            inOrder(r.right);
        }
    }



}
