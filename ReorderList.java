/*
    You given the head of a singly linked-list. The list can be represented as:
    L0 -> L1 -> .... -> Ln-1 -> Ln
    Reorder the list to be on the following form:
    L0 -> Ln -> L1 -> Ln-1 -> L2 -> Ln-2 -> .......
    
    Example1:
    Input: head = [1, 2, 3, 4]
    Output: [1, 4, 2, 3]
    
    Example2:
    Input: head = [1, 2, 3, 4, 5]
    Output: [1, 5, 2, 4, 3]
*/

import java.util.*;
public class ReorderList {

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }
    //Reorder the linked list
    public static void reorderList(ListNode head) {
        if(head == null || head.next == null) {
            return ;
        }
        //STEP 1 : Find the middle of the linked list
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        //STEP 2 : Reverse the second half 
        ListNode second = slow.next;
        //Cut the first half from the second half
        slow.next = null;
        ListNode prev = null;
        while (second != null) {
            ListNode nextNode = second.next;
            second.next = prev;
            prev = second;
            second = nextNode;
        }
        //Prev is the head of reversed second half
        second = prev;
        //STEP 3 : Merge both halves alternately
        ListNode first = head;
        while (second != null) {
            ListNode firstNext = first.next;
            ListNode secondNext = second.next;
            //Connect first node to second node
            first.next = second;
            //Connect second node to next first node
            second.next = firstNext;
            //Move forward
            first = firstNext;
            second = secondNext;
        }
    }
    //Insert a node at the end
    public static ListNode createList(int[] arr){
        if(arr.length == 0){
            return null;
        }
        ListNode head = new ListNode(arr[0]);
        ListNode current = head;
        for(int i=1; i<arr.length; i++) {
            current.next = new ListNode(arr[i]);
            current = current.next;
        }
        return head;
    }
    //Print linked list
    public static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val);
            if (current.next != null) {
                System.out.print(" -> ");
            }
            current = current.next;
        }
        System.out.println();
    }
    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 5, 6 ,7, 8, 9, 10};
        //Create linked list 
        ListNode head = createList(arr);
        System.out.println("Original List : ");
        printList(head);
        //Reorder the list
        reorderList(head);
        System.out.println("Reordered List : ");
        printList(head);
    }

}
