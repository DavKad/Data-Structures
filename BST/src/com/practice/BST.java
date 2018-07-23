package com.practice;

public class BST<TYPE> {
    private Node root = null;

    public void addValue(int value){
        if(root == null){
            root = new Node(value);
        }else{
            Node current = root;
            Node parent = null;
            while(current != null){
                parent = current;
                if(current.value > value){
                    current = current.right;
                }else{
                    current = current.left;
                }
            }
            if(parent.value > value){
                parent.right = new Node(value);
                parent.right.parent = parent;
            }else{
                parent.left = new Node(value);
                parent.left.parent = parent;
            }
        }
    }

    public boolean findValue(int value){
        Node current = root;
        while(current != null){
            if(current.value == value){
                return true;
            }else if(current.value < value){
                current = current.left;
            }else{
                current = current.right;
            }
        }
        return false;
    }
}
