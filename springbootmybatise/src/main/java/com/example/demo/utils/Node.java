package com.example.demo.utils;

import java.util.LinkedList;

public class Node<T> {
    public T data;
    public Node<T> parent;
    public LinkedList<Node<T>> childList;

    public Node() {
        this.data = null;
        this.parent = null;
        this.childList = null;
    }

    public Node(T data, Node<T> parent) {
        this.data = data;
        this.parent = parent;
        this.childList = new LinkedList<>();
    }
}
