package com.practice;

public class Node<T extends Comparable<T>>  {
    Node left;
    Node right;
    Node parent;
    T value;

    public Node(T value) {
        this.value = value;
    }
}
