package com.company.zadanie1;

public class MainTree {

    public static void main(String[] args) {


        Node node1 = new Node("1");
        Node node2 = new Node("2");
        Node node3 = new Node("3");
        Node node4 = new Node("4");
        Node node5 = new Node("5");
        Node node6 = new Node("6");
        Node node7 = new Node("7");


        node1.setLeft(node2);
        node1.setRight(node3);

        node2.setLeft(node4);
        node2.setRight(node5);

        node3.setLeft(node6);
        node3.setRight(node7);

        searchTree(node1); //Expected: 1 2 4 5 3 6 7



    }

    public static void searchTree(Node node) {
        System.out.println(node.getValue());
        if(node.getLeft() != null) {
            searchTree(node.getLeft());
        }
        if(node.getRight() != null) {
            searchTree(node.getRight());
        }
    }
}
