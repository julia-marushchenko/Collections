package com.Collections;

import com.Exceptions.NullPointerException;

import java.util.Iterator;
import java.util.NoSuchElementException;


public class LinkedList implements Queue {

    int size = 0;
    Node head;
    Node tail;


    @Override
    public Iterator<String> iterator() {
        Iterator iterator = new IteratorImpl();
        return iterator;
    }


    private class IteratorImpl implements Iterator<String> {

        Node current;
        Node prev;

        public IteratorImpl() {
            current = new Node(null);
            prev = current;
            current.next = head;
        }

        @Override
        public boolean hasNext() {
            return current != tail;
        }

        @Override
        public String next() {

            if (hasNext()) {
                prev = current;
                current = current.next;
                return current.element;
            } else {
                throw new NoSuchElementException();
            }
        }


        @Override
        public void remove() {
            if (size == 1){
                head = null;
                tail = null;
                size--;
            } else if (prev != current) {
                prev.next = current.next;
                current.next = null;
                current = prev;
                size--;
            } else {
                throw new IllegalStateException();
            }
        }

    }


    private static class Node {
        String element;
        Node next;

        public Node(String element) {
            this.element = element;
        }

        public Node(String element, Node next) {
            this.element = element;
            this.next = next;
        }

    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void enqueue(String element) {

        if (isEmpty()) {
            size++;
            head = new Node(element);
            tail = head;
            head.next = tail;

        } else {

            Node buf = new Node(element);
            buf.next = head;
            tail.next = buf;
            tail = buf;
            size++;

            /*tail = new Node(element);
            tail.next = head;

            checkNext(head).next = tail;
            size++;*/
        }
    }

    @Override
    public String dequeue() {
        String deleted = head.element;
        if (size == 1) {
            head = null;
            size--;
        } else {
            Node n = checkNext(head);
            n.next = head.next;
            Node newHead = head.next;
            head = newHead;
            size--;
        }
        return deleted;
    }

    // checking next till get tail
    private Node checkNext(Node node) {
        Node n = node;

        while (!n.next.equals(head)) {
            n = n.next;
            checkNext(n);
        }
        return n;
    }


    @Override
    public String peek() throws NullPointerException {
        if (head != null) {
            return head.element;
        } else {
            return null;
        }

    }


    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        if (head != null) {
            s.append(head.element);
            Node n = head;
            while (!n.next.equals(head)) {
                n = n.next;
                s.append(n.element);
                checkNext(n);
            }
        } else {
            s.append("List is empty");
        }
        return s.toString();
    }
}
