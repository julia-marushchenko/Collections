package com;

import com.Collections.DoubleLinkedList;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TestBinarySearch{

    DoubleLinkedList queue;
    int i;

    //Filling queue with different elements
    @BeforeEach
    void setUp() {
        for (String s : queue = new DoubleLinkedList()) {
            i++;
            queue.push("#" + i);
        }

    }

    @AfterEach
    void tearDown() {
        queue = null;
    }

    @Test
    @DisplayName("No required element found")
    void leftBinarySearch(){
        //assertEquals(-1, Main.leftBinarySearch());
    }

    @Test
    @DisplayName("")
    void resizeArr() {
        assertEquals(213, queue.size());
    }

}
