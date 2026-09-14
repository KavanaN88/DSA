/*
    Implement a first in first out (FIFO) queue using only two stack. The implemented queue should support all the functions of a normal
    queue(push, peek, pop and empty)
    
    Example1:
    Input: ["MyQueue", "push", "push", "peek", "pop", "empty"]
           [[], [1], [2], [], [], []]
           
    output [null, null, null, 1, 1, false]
*/

import java.util.*;
public class MyQueue {

    static class Queue {
        Stack<Integer> input = new Stack<>();
        Stack<Integer> output = new Stack<>();
        //Push element to the back of queue
        public void push(int x) {
            input.push(x);
        }
        //Remove element from front
        public int pop() {
            moveElements();
            return output.pop();
        }
        //Return front element
        public int peek() {
            moveElements();
            return output.peek();
        }
        //Check if queue is empty
        public boolean empty() {
            return  input.isEmpty() && output.isEmpty();
        }
        //Move elements from input to output
        private void moveElements(){
            if(output.isEmpty()) {
                while (!input.isEmpty()) {
                    output.push(input.pop());
                }
            }
        }
    }
    public static void main(String[] args) {
        Queue queue = new Queue();
        queue.push(1);
        queue.push(2);
        System.out.println("peek : " + queue.peek());
        System.out.println("pop : " + queue.pop());
        System.out.println("pop : " + queue.pop());
        System.out.println("Is Empty : " + queue.empty());

    }
}