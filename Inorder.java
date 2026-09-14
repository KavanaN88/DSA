/* 
    Given the root of a binary tree, return the inorder traversal of its nodes'values
    
    Example1 :
    Input: root = [1, null, 2, 3]
    Output: [1, 3, 2]
    
    Example2 :
    Input: root = [1, 2, 3, 4, 5, null, 8, null, null, 6, 7, 9]
    Output: [4, 2, 6, 5, 7, 1, 3, 9, 8]
    
    Example3:
    Input: root = []
    Output: []
    
    Example4:
    Input: root = [1]
    Output: [1]
*/


import java.util.*;
public class Inorder {

    static class Node {
        int data;
        Node left, right;
        Node(int data) {
            this.data = data;
        }    
    }
    public static void main(String[] args) {
        //Create tree
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.left.right.left = new Node(6);
        root.left.right.right = new Node(7);
        root.right.right = new Node(8);
        root.right.right.left = new Node(9);
        //Inorder traversal
        Stack<Node> stack = new Stack<>();
        Node temp = root;
        while (temp != null || !stack.empty()) {
            //Go to the leftmost node
            while (temp != null) {
                stack.push(temp);
                temp = temp.left;
            }
            //Visit node
            temp = stack.pop();
            System.out.print(temp.data + " ");
            //Move to right subtree
            temp = temp.right;
        }
    }
}