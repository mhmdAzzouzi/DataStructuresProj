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

    public void deletion(int bookId){
        delete(this.root,bookId );
    }

    public Node delete(Node r, int id)
    {
        //If the tree is empty return null and if r==null
        // then just return r because it's null :)
        if (r == null)
            return r;

        if (id < r.book.getID())
            r.left = delete(r.left, id);
        else if (id > r.book.getID())
            r.right = delete(r.right, id);

        else {
            // node with only one child or no child
            if (r.left == null)
                return r.right;
            else if (r.right == null)
                return r.left;


            r.book = minValue(r.right);

            // Delete the inorder successor
            r.right = delete(r.right, r.book.getID());
        }

        return r;
    }


    //to return minimum of a tree or a subtree
    public Book minValue(Node r)
    {
        Book min = r.book;
        while (r.left != null)
        {
            min = r.left.book;
            r = r.left;
        }
        return min;
    }

    public void inOrder(Node r){
        if(r !=null){
            inOrder(r.left);
            System.out.println(r.book);
            inOrder(r.right);
        }
    }



}
