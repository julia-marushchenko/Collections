package com.Collections;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class DoubleLinkedList implements Queue, Stack {

    static int size = 0;
    Node head;
    Node tail;
    boolean isQueue = false;

    private static class Node {

        String element;
        Node previous;
        Node next;

        public Node(String element) {
            this.element = element;
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
        isQueue = true;
        if (isEmpty()) {
            head = new Node(element);
            tail = head;
            head.next = tail;
            head.previous = null;
            size++;
        } else {
            Node buf = new Node(element);
            buf.next = head;
            buf.previous = tail;
            tail.next = buf;
            tail = buf;
            size++;
        }
    }

    @Override
    public String dequeue() {
        isQueue = true;
        String deleted = head.element;
        if (size == 1) {
            size--;
            head = null;
            tail = null;
        } else {
            Node newHead = head.next;
            head = newHead;
            head.previous = null;
            size--;
        }
        return deleted;
    }

    @Override
    public void push(String element) {
        isQueue = false;
        if (isEmpty()) {
            head = new Node(element);
            tail = head;
            head.next = tail;
            head.previous = null;
            size++;
        } else {
            Node buf = new Node(element);
            buf.next = head;
            buf.previous = tail;
            tail.next = buf;
            tail = buf;
            size++;
        }

    }

    @Override
    public String pop() {
        isQueue = false;
        String element = null;
        if (tail != null) {
            element =  tail.element;
            if (tail.previous != null) {
                tail.previous.next = null;
            }
            tail = tail.previous;
        }
        return element;
    }

    @Override
    public String peek() throws NullPointerException {
        if (isQueue) {
            if (head != null) {
                return head.element;
            } else {
                return null;
            }
        } else {
            if (tail != null) {
                return tail.element;
            } else {
                return null;
            }
        }

    }

    @Override
    public Iterator iterator() {
        Iterator iterator = new IteratorImpl();
        return iterator;
    }

    private class IteratorImpl implements Iterator {

        Node current;
        Node prev;
        Node next;

        public IteratorImpl() {
            if (isQueue) {
                current = new Node(null);
                prev = current;
                current.next = head;
            } else {
                current = new Node(null);
                next = current;
                current.previous = tail;
            }

        }

        @Override
        public boolean hasNext() {
            if(isQueue && current != tail) {
                return true;
            } else if (!isQueue && current != head) {
                return true;
            } else {
                return false;
            }

        }

        @Override
        public String next() {

            if (hasNext() && isQueue) {
                prev = current;
                current = current.next;
                return  current.element;
            } else if(hasNext() && !isQueue) {
                prev = current;
                current = current.previous;
                return  current.element;
            }else {
                throw new NoSuchElementException();
            }
        }

        // Need to check removing the last element
        @Override
        public void remove() {
            if (size == 1) {
                head = null;
                tail = null;
                size--;
            } else if (isQueue && prev != current) {
                prev.next = current.next;
                current.next = null;
                current = prev;
                size--;
            } else if (!isQueue && next != current){
                current.previous = prev.previous;
                prev.previous = null;
                current = next;
                size--;
            } else {
                throw new IllegalStateException();
            }
        }
    }
}
