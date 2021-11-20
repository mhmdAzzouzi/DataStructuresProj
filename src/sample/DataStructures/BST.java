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
    }

    Node root;
    int size;

    public boolean isEmpty(){
        return root == null;
    }


    public void DisplayInorder(){
        inOrder(this.root);
    }



    public void inOrder(Node r){
        if(r !=null){
            inOrder(r.left);
            System.out.println(r.book);
            inOrder(r.right);
        }
    }



}
