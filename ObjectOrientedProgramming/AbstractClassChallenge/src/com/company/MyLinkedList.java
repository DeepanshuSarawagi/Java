package com.company;

public class MyLinkedList implements NodeList{
    private ListItem root = null;

    public MyLinkedList(ListItem root) {
        this.root = root;
    }

    @Override
    public ListItem getRoot() {
        return this.root;
    }

    @Override
    public boolean addItem(ListItem newItem) {
        if (this.root == null) {
            // if list was empty, then item will be root
            this.root = newItem;
            return true;
        }
        ListItem currentItem = this.root;  // Pointing the current item in the list to the first item
        while (currentItem != null) {
            int comparison = currentItem.compareTo(newItem);
            if (comparison < 0) {
                // newItem is greater, move right if possible
                if (currentItem.next() != null) {
                    currentItem = currentItem.next();
                } else {
                    // there is no next, insert at the end of the list
                    currentItem.setNext(newItem);  // inserting the new item right to the current item
                    newItem.setPrevious(currentItem); // setting the current item to the item before newItem
                    return true;
                }
            } else if (comparison > 0) {
                // new item is less, insert before
                if (currentItem.previous() != null) {
                    currentItem.previous().setNext(newItem);
                    newItem.setPrevious(currentItem.previous());
                    newItem.setNext(currentItem);
                    currentItem.setPrevious(newItem);
                } else {
                    // the node with the previous is the root
                    newItem.setNext(this.root);
                    this.root.setPrevious(newItem);
                    this.root = newItem;
                }
                return true;
            } else {
                // equal
                System.out.println(newItem.getValue() + " is already present, not added.");
                return false;
            }
        }
        return false;
    }

    @Override
    public boolean removeItem(ListItem item) {
        return false;
    }

    @Override
    public void traverse(ListItem root) {
        if (this.root == null) {
            System.out.println("The list is empty");
        } else {
            while (this.root != null) {
                System.out.println(this.root.getValue());
                root = root.next();
            }
        }
    }
}
