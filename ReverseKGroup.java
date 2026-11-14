class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

public class ReverseKGroup {

    public ListNode reverseKGroup(ListNode head, int k) {

        ListNode current = head;
        int count = 0;

        // Check whether k nodes are available
        while (current != null && count < k) {
            current = current.next;
            count++;
        }

        // Reverse only if k nodes are available
        if (count == k) {

            ListNode prev = null;
            ListNode curr = head;
            ListNode next = null;

            // Reverse k nodes
            for (int i = 0; i < k; i++) {

                next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }

            // Connect remaining linked list
            head.next = reverseKGroup(curr, k);

            return prev;
        }

        return head;
    }

    // Create linked list
    public static ListNode createList(int[] arr) {

        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        for (int value : arr) {
            current.next = new ListNode(value);
            current = current.next;
        }

        return dummy.next;
    }

    // Display linked list
    public static void display(ListNode head) {

        while (head != null) {
            System.out.print(head.val);

            if (head.next != null) {
                System.out.print(" -> ");
            }

            head = head.next;
        }

        System.out.println();
    }

    // Main method
    public static void main(String[] args) {

        ReverseKGroup solution = new ReverseKGroup();

        ListNode head = createList(
            new int[]{1, 2, 3, 4, 5}
        );

        int k = 3;

        System.out.println("Original Linked List:");
        display(head);

        ListNode result = solution.reverseKGroup(head, k);

        System.out.println("After Reversing in K-Group:");
        display(result);
    }
}
