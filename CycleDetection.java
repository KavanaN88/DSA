class Node {
    int data;
    Node next;
    Node(int data) {
        this.data = data;
        this.next = null;
    }
}
public class CycleDetection {
    //Floyd's Cycle Detection Algorithm
    public static boolean hasCycle(Node head) {
        Node slow = head;  
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;  //move 1 steps
            fast = fast.next.next;  //move 2 steps
            if(slow == fast) {
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        //Creating linked list
        Node head = new Node(10);
        head.next = new Node(20);
        head.next.next = new Node(30);
        head.next.next.next = new Node(40);
        head.next.next.next.next = new Node(50);

        //Creating cycle: 50 points back to 20
        head.next.next.next.next.next = head.next;

        //Checking cycle
        if(hasCycle(head)) {
            System.out.println("Cycle Detected");
        }else{
            System.out.println("No cycle");
        }
    }
}