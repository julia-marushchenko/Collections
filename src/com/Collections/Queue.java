package com.Collections;

import com.Exceptions.NullPointerException;

public interface Queue extends Iterable <String>{
    int size();
    boolean isEmpty();
    void enqueue(String element);
    String dequeue();
    String peek() throws NullPointerException;
}