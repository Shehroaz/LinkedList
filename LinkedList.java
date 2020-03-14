package com.company;
import java.util.NoSuchElementException;

public class LinkedList {

    private class Node{
        private int value;
        Node next;

        public Node(int value){
            this.value = value;
        }
    }

    private Node head;

    /**
     * This Method addLast add Node at the end of linkedList
     * @param value
     */

    public void addLast(int value){
        Node node = new Node(value);
        if (head == null)
            head = node;
        Node current = head;
        while (current.next != null){
            current = current.next;
        }
        current.next = node;
        node.next = null;
    }

    /**
     * This method addFirst add Node as the starting node of the LinkedList
     * @param item
     */

    public void addFirst(int item) {
        Node node = new Node(item);
        if (head == null) {
            head = node;
            node.next = null;
        } else {
            node.next = head;
            head = node;
        }
    }

    /**
     * This method addPrevious add the node on the previous position of our given node
     * @param value this is the value of our node of list.
     */

    public void addPrevious(int value,int newNodeValue) {
        Node addPrevious = new Node(newNodeValue);
        Node previous = null;
        Node current = head;
        while (current != null) {
            if (current.value == value) break;
            previous = current;
            current = current.next;
        }
        if (current == null)
            System.out.println("Node not found");
        else if(current == head){
            addPrevious.next = current;
            head = addPrevious;
        }
        else {
            addPrevious.next = previous.next;
            previous.next = addPrevious;
        }
    }

    /**
     * This method addAfterNumber add Node after the desire node of linkedList
     * @param value This is the value of node whom after we wanna add new node
     * @param newNodeValue This is the value of node which we add after the Node
     */
    public void addAfterNumber(int value, int newNodeValue) {
        Node current = head;
        Node after = new Node(newNodeValue);
        while (current != null) {
            if (current.value == value)
                break;
            current = current.next;
        }
        if (current == null)
            System.out.println("Number Not Found");
        else {
            after.next = current.next;
            current.next = after;
        }
    }

    /**
     * This method deleteFirst delete the first node of the linkedList
     */
    public void deleteFirst(){
        if ( head == null)
            throw new NoSuchElementException();
        else{
            Node temp = head;
            head = temp.next;
            temp = null;
        }
    }
    /**
     * This method deleteLast delete the last node of the linkedList,
     * If linkedList is empty it throws exception that list is empty
     */
    public void deleteLast(){
        if (head == null)
            throw new NullPointerException("The list is Empty so not deletion");
        else {
            Node current = head;
            Node previous = null;
            while (current.next != null){
                previous = current;
                current = current.next;
            }
            previous.next = null;
            current = null;
        }
    }

    /**
     * This method deletePrevious delete the previous node of the node which value we pass in method
     * @param key is value of our node whom before we wanna delete the node
     */
    public void deletePrevious(int key){
        if (head == null)
            throw new NoSuchElementException("List is Empty");
        else if (head.value == key){
            Node temp = head;
            head = temp.next;
            temp = null;
        }
        else{
            Node current = head;
            Node previous = null;
            while ( current.next != null && current.next.value != key){
                previous = current;
                current = current.next;
            }
            if (current.next == null)
                throw new NoSuchElementException("Element not found");
            else{
                previous.next = current.next;
                current = null;
            }
        }
    }

    /**
     * This method deleteNect delete the next node of the node which value we pass in method
     * @param key is value of our node whom after we wanna delete the node
     */
    public void deleteNext(int key){
        if (head == null)
            throw new NoSuchElementException("List is empty");
        else if  (head.value == key){ // If the value is equal to head then copy the value of
            Node temp = head;      // Head to next of head and move head to next node...
            head = temp.next;
            head.value = temp.value;
            temp = null;
        }
        else {
            Node current = head;
            Node previous = null;
            while(current.next != null && current.value != key){
                previous = current;
                current = current.next;
            }
            if(current.next == null)
                System.out.println("Not Possible bcz no next");
            else{
                current.next.value = current.value;
                previous.next = current.next;
                current = null;
            }
        }
    }

    /**
     * This method IndexOf return that the index of following node which we wanna check
     * Index start with 0
     * @param item is the value of Node whom index we wanna check
     * @return  index of node if node is in the list and -1 if not found
     */
    public int indexOf(int item){
        int index = 0;
        Node current = head;
        while(current != null){
            if (current.value == item) return  index;
            current = current.next;
            index++;
        }
        return -1;
    }

    /**
     * This method check that did the linkedlist contains following node
     * @param item value of node which we wanna search
     * @return true if list contains the node either False if not found
     */
    public boolean contains(int item){
        Node current = head;
        while (current != null){
            if (current.value == item) return true;
            current = current.next;
        }
        return false;
    }

    /**
     * This method gives the middle of linkedList
     * Example if 7 items in list it gives middle element which is 4
     * if 5 items it gives 3 element of list
     */
    public void middleOfLinkList(){
        if (head != null){
            Node current = head;
            Node previous = head;
            while (current.next != null && current.next.next != null){
                previous = previous.next;
                current = current.next.next;
            }
            if(current.next == null)
                System.out.println("The middle node is "+previous.value);
            else{
                System.out.println("The middle node is "+ previous.value +" and " + previous.next.value);
            }
        }
    }
    /**
     * This method reverseLinkedList reverse our linkedList :D :D :D
     */
    public void reverseLinkedList(){
        if (head == null) return;

        Node previous = head;
        Node current = head.next;
        while (current != null){
            Node next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        head.next=null;
        head = previous;
    }

    /**
     * This method size returns the size of linkedList.
     * @return the size of linkedlist
     */
    public  int size(){
        int counter = 0;
        Node current = head;
        while (current != null){
            current = current.next;
            counter++;
        }
        return counter;
    }

    /**
     * This method printList Print the whole linkedList
     */
    public  void printList(){
        Node current = head;
        while (current != null){
            System.out.print(current.value+"------>");
            current = current.next;
        }
    }

    /**
     * This method convert the LinkedList into an Array
     * @return Array of linkedList
     */
    public int[] toArray(){
        int[] array = new int[size()];
        Node current = head;
        int index = 0;
        while (current != null){
            array[index++] = current.value;
            current = current.next;
        }
        return array;
    }

}


