package com;

import com.Collections.DoubleLinkedList;
import com.Collections.Queue;
import com.Collections.Stack;
import com.Exceptions.NullPointerException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

public class DoubleLinkedListTest {

    private Queue queue;
    private Stack stack;


    @BeforeEach
    void setUp() {
        queue = new DoubleLinkedList();
        stack = new DoubleLinkedList();
    }

    @AfterEach
    void tearDown() {
        queue = null;
        stack = null;
    }

    @Test
    @DisplayName("Test that newly created queue has size = 0. YM")
    void size() {
        assertEquals(0, queue.size());
    }

    @Test
    @DisplayName("Test returns true is collection size is empty. YM")
    void isEmpty() {
        assertTrue(queue.isEmpty());
    }

    @Test
    @DisplayName("Test that created queue has size = 1 YM")
    void size1() {
        queue.enqueue("#1");
        assertEquals(1, queue.size());
    }

    @Test
    @DisplayName("Testing  method enqueue() that it adds 1 element. YM")
    void engueue() {
        queue.enqueue("#1");
        assertEquals("#1", queue.dequeue());
    }

    @Test
    @DisplayName("Testing  method enqueue() that it adds 2 elements. YM")
    void engueue1() {
        queue.enqueue("#1");
        queue.enqueue("#2");
        assertEquals(2, queue.size());
    }

    @Test
    @DisplayName("Testing  method enqueue() that it adds 5 elements. YM")
    void engueue2() {
        queue.enqueue("#1");
        queue.enqueue("#2");
        queue.enqueue("#3");
        queue.enqueue("#4");
        queue.enqueue("#5");

        assertEquals(5, queue.size());
    }

    @Test
    @DisplayName("Testing method peek to return the head element of the queue. YM")
    void peek() throws NullPointerException {
        queue.enqueue("#1");
        queue.enqueue("#2");
        queue.enqueue("#3");
        String element = queue.peek();
        assertEquals("#1", element);
    }

    @Test
    @DisplayName("Testing method push when stack is empty. YM")
    void push() {
        stack.push("#1");
        assertEquals("#1", stack.peek());
    }

    @Test
    @DisplayName("Testing method push that it adds two elements to the stack. YM")
    void push1() {
        stack.push("#1");
        stack.push("#2");
        assertEquals("#2", stack.peek());
    }

    @Test
    @DisplayName("Testing method push that it adds three elements to the stack. YM")
    void push2() {
        stack.push("#1");
        stack.push("#2");
        stack.push("#3");
        assertEquals("#3", stack.peek());
    }

    @Test
    @DisplayName("Testing method peek to return tail - the last added element of the stack. YM")
    void peek1() {
        stack.push("#1");
        stack.push("#2");
        stack.push("#3");
        assertEquals("#3", stack.peek());
    }

    @Test
    @DisplayName("Testing method pop when queue is empty. YM")
    void pop() {
        assertNull(stack.pop());
    }

    @Test
    @DisplayName("Testing method pop when queue size is 1. YM")
    void pop1() {
        stack.push("#1");
        String str = (String) stack.pop();
        assertEquals("#1", str);
        assertNull(stack.pop());
    }

    @Test
    @DisplayName("Testing method pop when queue size is 2. YM")
    void pop2() {
        stack.push("#1");
        stack.push("#2");
        String str = (String) stack.pop();
        assertEquals("#2", str);
        assertEquals("#1", stack.peek());
    }

    @Test
    @DisplayName("Testing method pop when queue size is 3. YM")
    void pop3() {
        stack.push("#1");
        stack.push("#2");
        stack.push("#3");
        String str = (String) stack.pop();
        assertEquals("#3", str);
        assertEquals("#2", stack.peek());
    }

    @Test
    @DisplayName("Testing NoSuchElement exception when queue is empty. YM")
    void iterator() {
        Iterator iterator = queue.iterator();
        assertThrows(NoSuchElementException.class, iterator::next);
    }

    @Test
    @DisplayName("Testing iterator when its queue size is 1 that it returns the first element value. YM")
    void iterator1() {
        String element = "#1";
        queue.enqueue(element);
        String result = queue.iterator().next();
        assertEquals(element, result);
    }

    @Test
    @DisplayName("Testing iterator when its queue size is 2 that it returns the first and the second elements value. YM")
    void iterator2() {
        String element = "#1";
        String element2 = "#2";
        queue.enqueue(element);
        queue.enqueue(element2);
        Iterator iterator = queue.iterator();
        String result = (String) iterator.next();
        String result2 = (String) iterator.next();
        assertEquals("#1#2", result + result2);
    }

    @Test
    @DisplayName("Testing iterator when its queue size is 3 that it returns the value of each element . YM")
    void iterator3() {
        String element = "#1";
        String element2 = "#2";
        String element3 = "#3";
        queue.enqueue(element);
        queue.enqueue(element2);
        queue.enqueue(element3);
        Iterator iterator = queue.iterator();
        String result = (String) iterator.next();
        String result2 = (String) iterator.next();
        String result3 = (String) iterator.next();
        assertEquals("#1#2#3", result + result2 + result3);
    }

    @Test
    @DisplayName("Testing iterator when its stack size is 1")
    void iterator4() {
        String element = "#1";
        stack.push(element);
        String result = stack.iterator().next();
        assertEquals(element, result);
    }

    @Test
    @DisplayName("Testing iterator when its stack size is 2 to return each element")
    void iterator5() {
        String element = "#1";
        String element2 = "#2";
        stack.push(element);
        stack.push(element2);
        Iterator iterator = stack.iterator();
        String result = (String) iterator.next();
        String result1 = (String) iterator.next();
        assertEquals("#2#1", result + result1);
    }

    @Test
    @DisplayName("Testing iterator when its stack size is 3 to return each element")
    void iterator6() {
        String element = "#1";
        String element2 = "#2";
        String element3 = "#3";
        stack.push(element);
        stack.push(element2);
        stack.push(element3);
        Iterator iterator = stack.iterator();
        String result = (String) iterator.next();
        String result1 = (String) iterator.next();
        String result2 = (String) iterator.next();
        assertEquals("#3#2#1", result + result1 + result2);
    }

    @Test
    @DisplayName("Testing iterator when its stack size is 3 to delete first element")
    void iterator7() {
        String element = "#1";
        String element2 = "#2";
        String element3 = "#3";
        stack.push(element);
        stack.push(element2);
        stack.push(element3);
        Iterator iterator = stack.iterator();
        String result = (String) iterator.next();
        String result1 = (String) iterator.next();
        String result2 = (String) iterator.next();
        assertEquals("#3#2#1", result + result1 + result2);
    }

    @Test
    @DisplayName("Testing remove method of iterator to throw UnsupportedOperationException. YM")
    void iterator8() {
        Iterator<String> it = stack.iterator();
        assertThrows(IllegalStateException.class, it::remove);
    }


    @Test
    @DisplayName("Testing remove method of iterator to delete the second element. YM")
    void iterator9() {
        queue.enqueue("#1");
        queue.enqueue("#2");
        queue.enqueue("#3");
        //System.out.println(queue);
        Iterator<String> it = queue.iterator();
        it.next();
        it.next();
        it.remove();
        for (String str : queue) {
            System.out.println(str);
        }
    }

    @Test
    @DisplayName("Testing remove method of iterator to delete first element when size = 1. YM")
    void iterator10()  {
        queue.enqueue("#1");
        Iterator<String> it = queue.iterator();
        it.next();
        it.remove();
        try {
            assertNull(queue.peek());
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }

    @Test
    @DisplayName("Testing remove method of iterator to delete the second element when size = 3. YM")
    void iterator11() {
        queue.enqueue("#1");
        queue.enqueue("#2");
        queue.enqueue("#3");
        Iterator<String> it = queue.iterator();
        it.next();
        it.next();
        it.remove();
        StringBuffer sb = new StringBuffer();
        for (String str: queue){
            sb.append(str);
            //System.out.println(str);
        }
        assertEquals("#1#3", sb.toString());
    }
}