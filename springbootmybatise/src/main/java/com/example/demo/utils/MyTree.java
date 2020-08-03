package com.example.demo.utils;

import java.util.ArrayDeque;
import java.util.Queue;

// 自定义树
public class MyTree<E> {

    private Node<E> root;

    public MyTree(Node<E> root) {
        this.root = root;
    }

    public MyTree() {
    }

    public Node<E> getRoot() {
        return root;
    }

    // 生成树
    /*
    {"知识点一"}
     */
    public Node<String> createTree() {
        Node<String> root = new Node<>("root", null);
        Node<String> firstNode = new Node<>("food", root);
        root.childList.add(firstNode);
        Node<String> secondNode = new Node<>("fruit", firstNode);
        firstNode.childList.add(secondNode);

        Node<String> thirdNode = new Node<>("meat", firstNode);
        firstNode.childList.add(thirdNode);

        Node<String> forthNode = new Node<>("red", secondNode);
        secondNode.childList.add(forthNode);
        return root;
    }

    // 遍历树, 深度优先
    public void printTree(Node<E> node, int level) {
        StringBuilder preStr = new StringBuilder();
        for(int i = 0; i < level; i++) {
            preStr.append("    ");
        }
        for (int i = 0; i < node.childList.size(); i++) {
            Node<E> currentNode = node.childList.get(i);
            System.out.println(preStr + "-" + currentNode.data.toString());
            if(!currentNode.childList.isEmpty()) {
                printTree(currentNode, level + 1);
            }
        }
    }
    // 遍历树， 广度优先
    public void print(Node<E> node) {
        Queue<Node<E>> nodeQueue = new ArrayDeque<>();
        nodeQueue.add(node);
        int isLine = 0;
        while (!nodeQueue.isEmpty()) {
            Node<E> currentNode = nodeQueue.poll();
            System.out.print("-" + currentNode.data);
            if(currentNode.childList != null) {
                nodeQueue.addAll(currentNode.childList);
            }
            if(currentNode.parent != null) {
                isLine = isLine + 1;
                int size = currentNode.parent.childList.size();
                if(isLine == size) {
                    System.out.println();
                    isLine = 0;
                }
            }else {
                System.out.println();
            }
        }
    }

    // 统计子结点个数
    public int countChildNode(Node<E> node) {
        if(node.childList == null) {
            return 0;
        }
        int count = node.childList.size();
        // 遍历树, 深度优先
        for (int i = 0; i < node.childList.size(); i++) {
            Node<E> currentNode = node.childList.get(i);

            if(!currentNode.childList.isEmpty()) {
                count += countChildNode(currentNode);
            }
        }
        return count;
    }

    public static void main(String[] args) {
        MyTree<String> myTree = new MyTree();

        Node<String> root = myTree.createTree();

        //myTree.printTree(root, 0);
        myTree.print(root);

        System.out.println(myTree.countChildNode(root));
    }
}

