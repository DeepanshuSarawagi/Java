package com.company;

public class Main {

    public static void main(String[] args) {
	    MyLinkedList myLinkedList = new MyLinkedList(null);
	    myLinkedList.traverse(myLinkedList.getRoot());
        String stringData = "Chennai Agra Delhi Bengaluru Pune Jaipur Lucknow Hyderabad Mumbai";
        String [] data = stringData.split(" ");
        for (String s: data) {
            myLinkedList.addItem(new Node(s));
        }
        myLinkedList.traverse(myLinkedList.getRoot());
    }
}
