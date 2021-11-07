package com.company;

import java.util.LinkedList;

public class LinkedListReverse {

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.add("a");
        linkedList.add("b");
        linkedList.add("c");
        linkedList.add("d");
        System.out.println("Before "+ linkedList);
        System.out.println("After "+ new LinkedListReverse().reverseLinkedList(linkedList));
    }

    public LinkedList reverseLinkedList(LinkedList<String> linkedList){
        int size = linkedList.size();
        String value = "";
        for(int counter = size-1; counter>=0; counter--){
            value = linkedList.get(counter);
            linkedList.add(value);
            linkedList.remove(counter);
        }
        return linkedList;
    }
}
