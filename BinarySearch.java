import java.util.ArrayList;

public class BinarySearch {

    // Node class
    static class Node {

        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    // Insert a node
    static Node insert(Node root, int value) {

        if (root == null) {
            return new Node(value);
        }

        if (value < root.data) {
            root.left = insert(root.left, value);
        }
        else if (value > root.data) {
            root.right = insert(root.right, value);
        }

        return root;
    }

    // Search a value
    static boolean search(Node root, int key) {

        if (root == null) {
            return false;
        }

        if (root.data == key) {
            return true;
        }

        if (key < root.data) {
            return search(root.left, key);
        }

        return search(root.right, key);
    }

    // Find minimum node
    static Node findMin(Node root) {

        while (root.left != null) {
            root = root.left;
        }

        return root;
    }

    // Delete a node
    static Node delete(Node root, int key) {

        if (root == null) {
            return null;
        }

        if (key < root.data) {

            root.left = delete(root.left, key);
        }

        else if (key > root.data) {

            root.right = delete(root.right, key);
        }

        else {

            // Case 1: No child
            if (root.left == null && root.right == null) {
                return null;
            }

            // Case 2: Only right child
            if (root.left == null) {
                return root.right;
            }

            // Case 2: Only left child
            if (root.right == null) {
                return root.left;
            }

            // Case 3: Two children
            Node successor = findMin(root.right);

            root.data = successor.data;

            root.right = delete(root.right, successor.data);
        }

        return root;
    }

    // Print values within a range
    static void printRange(Node root, int low, int high) {

        if (root == null) {
            return;
        }

        if (root.data > low) {
            printRange(root.left, low, high);
        }

        if (root.data >= low && root.data <= high) {
            System.out.print(root.data + " ");
        }

        if (root.data < high) {
            printRange(root.right, low, high);
        }
    }

    // Print root-to-leaf paths
    static void printPaths(Node root, ArrayList<Integer> path) {

        if (root == null) {
            return;
        }

        // Add current node
        path.add(root.data);

        // Check leaf
        if (root.left == null && root.right == null) {

            for (int value : path) {
                System.out.print(value + " ");
            }

            System.out.println();
        }

        // Traverse left
        printPaths(root.left, path);

        // Traverse right
        printPaths(root.right, path);

        // Backtrack
        path.remove(path.size() - 1);
    }

    public static void main(String[] args) {

        Node root = null;

        // Build BST
        int[] values = {50, 30, 70, 20, 40, 60, 80};

        for (int value : values) {
            root = insert(root, value);
        }

        // Search
        int key = 60;

        if (search(root, key)) {
            System.out.println("60 found in BST");
        }
        else {
            System.out.println("60 not found in BST");
        }

        // Print range
        System.out.println("\nValues between 30 and 70:");

        printRange(root, 30, 70);

        System.out.println();

        // Root to leaf paths
        System.out.println("\nRoot to Leaf Paths:");

        ArrayList<Integer> path = new ArrayList<>();

        printPaths(root, path);

        // Delete
        System.out.println("\nDeleting 50...");

        root = delete(root, 50);

        System.out.println("Root-to-leaf paths after deletion:");

        path.clear();

        printPaths(root, path);
    }
}