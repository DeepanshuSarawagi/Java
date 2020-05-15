package com.company;

public interface NodeList {
    ListItem getRoot();
    boolean addItem(ListItem item);
    boolean removeItem(ListItem item);
    void traverse(ListItem root);  // In case of the linkedList, root is called as the head of the list

}
