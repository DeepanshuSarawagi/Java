package com.company;

public class SearchtTree implements NodeList{
    private ListItem root = null;

    public SearchtTree(ListItem root) {
        this.root = root;
    }

    @Override
    public ListItem getRoot() {
        return this.root;
    }

    @Override
    public boolean addItem(ListItem newItem) {
        if (this.root == null) {
            // the list is empty, so item becomes the head of the tree
            this.root = newItem;
        }
        // otherwise, start comparing from the head of the tree
        ListItem currentItem = this.root;
        while (currentItem != null) {
            int comparison = currentItem.compareTo(newItem);
            if (comparison < 0) {
                // newItem is greater, move right if possible
                if (currentItem.next() != null) {
                    currentItem = currentItem.next();
                } else {
                    // if there is no node at right, add at this point
                    currentItem.setNext(newItem);
                    return true;
                }
                } else if (comparison > 0) {
                    // newItem is less, move left if possible
                    if (currentItem.previous() != null) {
                        currentItem = currentItem.previous();
                    } else {
                        // there is no node to the left, so add at this point
                        currentItem.setPrevious(newItem);
                        return true;
                    }
            } else {
                // comparison is equal
                System.out.println("Item " + newItem.getValue() + " is already present. Not adding it.");
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
        //recursive function
        if (root != null) {
            traverse(root.previous()); {
                System.out.println(root.getValue());
                traverse(root.next());
            }
        }
    }
}
