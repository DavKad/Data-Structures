package com.practice;

public class BST<T extends Comparable>{
    private Node root = null;

    public void addValue(T value){
        if(root == null){
            root = new Node(value);
        }else{
            Node current = root;
            Node parent = null;
            while(current != null){
                parent = current;
                if(current.value.compareTo(value) > 0){
                    current = current.right;
                }else{
                    current = current.left;
                }
            }
            if(parent.value.compareTo(value) > 0){
                parent.right = new Node(value);
                parent.right.parent = parent;
            }else{
                parent.left = new Node(value);
                parent.left.parent = parent;
            }
        }
    }

    public boolean findValue(T value){
        Node current = root;
        while(current != null){
            if(current.value.equals(value)){
                return true;
            }else if(current.value.compareTo(value) < 0){
                current = current.left;
            }else{
                current = current.right;
            }
        }
        return false;
    }
}
