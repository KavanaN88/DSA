/*
    Implement a last in first out (LIFO) stack using only two queues. The implemented stack should support all the functions of a normal 
    stack(push, top, pop, and empty)
    
    Example1:
    Input: ["MyStack", "push", "push", "top", "pop", "empty"]
           [[], [1], [2], [], [], []]
           
    output [null, null, null, 2, 2, false]

*/

import java.util.*;
public class MyStack {

    static class Stack {
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        //Push element into stack
        public void push(int x){
            //Put new element in q2
            q2.offer(x);
            //Move all elements from q1 to q2
            while (!q1.isEmpty()) {
                q2.offer(q1.poll());
            }
            //Swap q1 and q2
            Queue<Integer> temp = q1;
            q1 = q2;
            q2 = temp;
        }
        //Remove top element
        public int pop() {
            return q1.poll();
        }
        //Return top element 
        public int top() {
            return q1.peek();
        }
        //Check whether stack is empty
        public boolean empty() {
            return q1.isEmpty();
        }
    }
    public static void main(String[] args) {
        Stack stack = new Stack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        System.out.println("Top : " + stack.top());
        System.out.println("pop : " + stack.pop());
        System.out.println("pop : " + stack.pop());
        System.out.println("Top : " + stack.top());
        System.out.println("Is Empty : " + stack.empty());
        
    }
}

