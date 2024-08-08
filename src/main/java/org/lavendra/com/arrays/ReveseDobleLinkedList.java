package org.lavendra.com.arrays;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class ReveseDobleLinkedList {

    public static void main(String[] args) {
        ReveseDobleLinkedList dobleLinkedList = new ReveseDobleLinkedList();
        List<Integer> inputList = new LinkedList<>();
        inputList.add(1);
        inputList.add(2);
        inputList.add(3);
        inputList.add(4);
        inputList.add(5);
        System.out.println(dobleLinkedList.reveseLinkedList(inputList));
    }

    public List<Integer> reveseLinkedList(List<Integer> inputList) {
        LinkedList<Integer> reversedList = new LinkedList<>();
        ListIterator<Integer> iterator = inputList.listIterator(inputList.size());
        while (iterator.hasPrevious()) {
            reversedList.add(iterator.previous());
        }
        return reversedList;
    }
}
