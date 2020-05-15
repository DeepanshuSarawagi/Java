package com.company;

public class Main {

    public static void main(String[] args) {
	    MyLinkedList myLinkedList = new MyLinkedList(null);
	    myLinkedList.traverse(myLinkedList.getRoot());
        String stringData = "5 7 4 3 9 8 0 2 1";
        String [] data = stringData.split(" ");
        for (String s: data) {
            myLinkedList.addItem(new Node(s));
        }
        myLinkedList.traverse(myLinkedList.getRoot());
        myLinkedList.removeItem(new Node("2"));
        myLinkedList.traverse(myLinkedList.getRoot());
    }
}
