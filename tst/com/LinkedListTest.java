
package com;

import com.Collections.LinkedList;
import com.Collections.Queue;
import com.Exceptions.NullPointerException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListTest {


    private Queue queue;


    @BeforeEach
    void setUp() {
        queue = new LinkedList();
    }

    @AfterEach
    void tearDown() {
        queue = null;
    }

    @Test
    @DisplayName("Test that newly created queue has size = 0. YM")
    void size() {
        assertEquals(0, queue.size());
    }


    @Test
    @DisplayName("Test after enqueue one object queue has size = 1. YM")
    void size1() {
        queue.enqueue("");
        assertEquals(1, queue.size());
    }

    @Test
    @DisplayName("After enqueue/dequeue the queue has size = 0. YM")
    void size2() {
        queue.enqueue("");
        queue.dequeue();
        assertEquals(0, queue.size());
    }

    @Test
    @DisplayName("isEmpty for empty queue. YM")
    void isEmpty() {
        assertTrue(queue.isEmpty());
    }

    @Test
    @DisplayName("isEmpty after enqueue returns false. YM")
    void isEmpty1() {
        queue.enqueue("");
        assertFalse(queue.isEmpty());
    }

    @Test
    @DisplayName("Dequeue returns the object that was enqueued. YM")
    void enqueue() {
        String element = "#1";
        queue.enqueue(element);
        String result = queue.dequeue();
        assertEquals(element, result);
    }

    @Test
    @DisplayName("Returns null when the queue is empty. YM")
    void peek() throws NullPointerException {
        Queue queue = new LinkedList();
        assertNull(queue.peek());
    }

    @Test
    @DisplayName("Returns head of the queue or throws NullPointerException. YM")
    void peek1 () {
        String element = "#1";
        queue.enqueue (element);
        try {
            String result = queue.peek();
            assertEquals(element, result);
        }catch (NullPointerException ex){
            System.out.println("Null Pointer Exception was thrown in method peek() in Linked List. YM");
        };
    }

    @Test
    @DisplayName("Testing NoSuchElement exception when queue is empty. YM")
    void iterator() {
        Iterator iterator = queue.iterator();
        assertThrows(NoSuchElementException.class, iterator:: next);
    }

    @Test
    @DisplayName("Testing iterator when its collection size is 1 that it returns the first element value. YM")
    void iterator1() {
        String element = "#1";
        queue.enqueue(element);
        String result = queue.iterator().next();
        assertEquals(element, result);
    }

    @Test
    @DisplayName("Testing iterator when its collection size is 2 that it returns last element value. YM")
    void iterator2()  {
        queue.enqueue("#1");
        queue.enqueue("#2");
        Iterator<String> it = queue.iterator();
        it.next();
        assertEquals("#2", it.next());
    }

    @Test
    @DisplayName("Testing iterator when its collection size is 3 that it returns the second element value. YM")
    void iterator3()  {
        String element = "#1";
        String element2 = "#2";
        String element3 = "#3";
        queue.enqueue(element);
        queue.enqueue(element2);
        queue.enqueue(element3);
        Iterator<String> it = queue.iterator();
        it.next();
        String result = it.next();
        assertEquals(element2, result);
    }

    @Test
    @DisplayName("Testing iterator when its collection size is 4 that it returns the last element value. YM")
    void iterator4()  {
        String element = "#1";
        String element2 = "#2";
        String element3 = "#3";
        String element4 = "#4";
        queue.enqueue(element);
        queue.enqueue(element2);
        queue.enqueue(element3);
        queue.enqueue(element4);
        Iterator<String> it = queue.iterator();
        it.next();
        it.next();
        it.next();
        String result = it.next();
        assertEquals(element4, result);
    }


    @Test
    @DisplayName("Testing remove method of iterator to throw UnsupportedOperationException. YM")
    void iterator6() {
        Iterator<String> it = queue.iterator();
        assertThrows(IllegalStateException.class,it::remove );
    }

    @Test
    @DisplayName("Testing remove method of iterator to delete first element. YM")
    void iterator7() throws NullPointerException {
        queue.enqueue("#1");
        Iterator<String> it = queue.iterator();
        it.next();
        it.remove();
        assertNull(queue.peek());
    }

    @Test
    @DisplayName("Testing remove method of iterator to delete the second element. YM")
    void iterator8() {
        queue.enqueue("#1");
        queue.enqueue("#2");
        queue.enqueue("#3");
        //System.out.println(queue);
        Iterator <String> it = queue.iterator();
        it.next();
        it.next();
        it.remove();
        for (String str: queue){
            System.out.println (str);
        }

    }

    @Test
    @DisplayName("Testing remove method of iterator to delete the third element. YM")
    void iterator9() {
        queue.enqueue("#1");
        queue.enqueue("#2");
        queue.enqueue("#3");
        queue.enqueue("#4");
        queue.enqueue("#5");
        System.out.println(queue);
        Iterator <String> it = queue.iterator();
        //it = queue.iterator();
        System.out.println(it.next());
        it.next();
        it.next();
        it.remove();
        Boolean noNextElement = it.hasNext();
        System.out.println (queue);

    }

}
