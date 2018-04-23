/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ocp.GenericsCollections;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

/**
 *
 * @author PietroS
 */
//A collection that can be used as a stack or a queue
//It means a “double-ended queue” (and is pronounced “deck”).
//A queue provides FIFO (first in, first out) operations:
//add(e) and remove() methods
//A stack provides LIFO (last in, first out) operations:
//push(e) and pop() methods

//Method Description For queue For stack
//boolean add(E e) Adds an element to the back of the queue and returns true or throws an exception
//E element() Returns next element or throws an exception if empty queue
//boolean offer(E e) Adds an element to the back of the queue and returns whether successful
//E remove() Removes and returns next element or throws an exception if empty queue
//void push(E e) Adds an element to the front of the queue 
//E poll() Removes and returns next element or returns null if empty queue
//E peek() Returns next element or returns null if empty queue
//E pop() Removes and returns next element or throws an exception if empty queue

public class QueueExample {

    public static void main(String[] args) {

        Queue<Integer> queue = new ArrayDeque<>();
        System.out.println(queue.offer(10)); // true
        System.out.println(queue.offer(4)); // true
        System.out.println(queue.peek()); // 10
        System.out.println(queue.poll()); // 10
        System.out.println(queue.poll()); // 4
        System.out.println(queue.peek()); // null

        Deque<String> stack = new ArrayDeque<>();
        stack.push("one");
        stack.push("two");
        stack.push("three");

        int size = stack.size() - 1;
        while (size >= 0) {
            System.out.println(stack.pop());
            size--;
        }

        Deque<String> queue2 = new ArrayDeque<>();
        queue2.add("one");
        queue2.add("two");
        queue2.add("three");

        size = queue.size() - 1;
        while (size >= 0) {
            System.out.println(queue.remove());
            size--;
        }

        ArrayDeque<Integer> stack2 = new ArrayDeque<>();
        stack2.push(10);
        stack2.push(4);
        System.out.println(stack2.peek()); // 4
        System.out.println(stack2.poll()); // 4
        System.out.println(stack2.poll()); // 10
        System.out.println(stack2.peek()); // null        
    }
}
