import java.util.*;

// Node class
class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

public class Binary {

    // Used to build the tree from the array
    static int idx = -1;

    // Build Binary Tree
    static Node buildTree(int[] Nodes) {

        idx++;

        if (Nodes[idx] == -1) {
            return null;
        }

        Node newNode = new Node(Nodes[idx]);

        newNode.left = buildTree(Nodes);
        newNode.right = buildTree(Nodes);

        return newNode;
    }

    // ------------------------------------------------
    // 1. PREORDER TRAVERSAL
    // Root -> Left -> Right
    // ------------------------------------------------
    public static void preorder(Node root) {

        if (root == null) {
            return;
        }

        System.out.print(root.data + " ");

        preorder(root.left);
        preorder(root.right);
    }

    // ------------------------------------------------
    // 2. INORDER TRAVERSAL
    // Left -> Root -> Right
    // ------------------------------------------------
    public static void inorder(Node root) {

        if (root == null) {
            return;
        }

        inorder(root.left);

        System.out.print(root.data + " ");

        inorder(root.right);
    }

    // ------------------------------------------------
    // 3. POSTORDER TRAVERSAL
    // Left -> Right -> Root
    // ------------------------------------------------
    public static void postorder(Node root) {

        if (root == null) {
            return;
        }

        postorder(root.left);
        postorder(root.right);

        System.out.print(root.data + " ");
    }

    // ------------------------------------------------
    // 4. LEVEL ORDER TRAVERSAL
    // ------------------------------------------------
    public static void levelOrder(Node root) {

        if (root == null) {
            return;
        }

        Queue<Node> q = new LinkedList<>();

        q.add(root);
        q.add(null);

        while (!q.isEmpty()) {

            Node curr = q.remove();

            if (curr == null) {

                System.out.println();

                if (q.isEmpty()) {
                    break;
                }

                q.add(null);

            } else {

                System.out.print(curr.data + " ");

                if (curr.left != null) {
                    q.add(curr.left);
                }

                if (curr.right != null) {
                    q.add(curr.right);
                }
            }
        }
    }

    // ------------------------------------------------
    // 5. HEIGHT OF TREE
    // ------------------------------------------------
    public static int height(Node root) {

        if (root == null) {
            return 0;
        }

        int leftHeight = height(root.left);
        int rightHeight = height(root.right);

        return Math.max(leftHeight, rightHeight) + 1;
    }

    // ------------------------------------------------
    // 6. COUNT OF NODES
    // ------------------------------------------------
    public static int countOfNodes(Node root) {

        if (root == null) {
            return 0;
        }

        int leftNodes = countOfNodes(root.left);
        int rightNodes = countOfNodes(root.right);

        return leftNodes + rightNodes + 1;
    }

    // ------------------------------------------------
    // 7. SUM OF NODES
    // ------------------------------------------------
    public static int sumOfNodes(Node root) {

        if (root == null) {
            return 0;
        }

        int leftSum = sumOfNodes(root.left);
        int rightSum = sumOfNodes(root.right);

        return leftSum + rightSum + root.data;
    }

    // ------------------------------------------------
    // 8. DIAMETER OF TREE
    // Approach 1 - O(N^2)
    // ------------------------------------------------
    public static int diameter(Node root) {

        if (root == null) {
            return 0;
        }

        // Diameter passing through current node
        int diam1 = height(root.left)
                + height(root.right)
                + 1;

        // Diameter of left subtree
        int diam2 = diameter(root.left);

        // Diameter of right subtree
        int diam3 = diameter(root.right);

        return Math.max(diam1, Math.max(diam2, diam3));
    }

    // ------------------------------------------------
    // 9. DIAMETER OF TREE
    // Approach 2 - O(N)
    // ------------------------------------------------

    static class TreeInfo {

        int ht;
        int diam;

        TreeInfo(int ht, int diam) {
            this.ht = ht;
            this.diam = diam;
        }
    }

    public static TreeInfo diameter2(Node root) {

        if (root == null) {
            return new TreeInfo(0, 0);
        }

        // Get information from left subtree
        TreeInfo leftTI = diameter2(root.left);

        // Get information from right subtree
        TreeInfo rightTI = diameter2(root.right);

        // Calculate height of current node
        int myHeight =
                Math.max(leftTI.ht, rightTI.ht) + 1;

        // Diameter passing through current node
        int diam1 =
                leftTI.ht + rightTI.ht + 1;

        // Diameter of left subtree
        int diam2 = leftTI.diam;

        // Diameter of right subtree
        int diam3 = rightTI.diam;

        // Maximum diameter
        int myDiam =
                Math.max(diam1, Math.max(diam2, diam3));

        return new TreeInfo(myHeight, myDiam);
    }

    // ------------------------------------------------
    // MAIN METHOD
    // ------------------------------------------------
    public static void main(String[] args) {

        // Preorder representation of Binary Tree
        int Nodes[] = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};
        // Create object
        Binary tree = new Binary();

        // Build tree
        Node root = tree.buildTree(Nodes);

        // --------------------------------------------
        // PREORDER
        // --------------------------------------------
        System.out.println("Preorder Traversal:");
        preorder(root);

        // --------------------------------------------
        // INORDER
        // --------------------------------------------
        System.out.println("\n\nInorder Traversal:");
        inorder(root);

        // --------------------------------------------
        // POSTORDER
        // --------------------------------------------
        System.out.println("\n\nPostorder Traversal:");
        postorder(root);

        // --------------------------------------------
        // LEVEL ORDER
        // --------------------------------------------
        System.out.println("\n\nLevel Order Traversal:");
        levelOrder(root);

        // --------------------------------------------
        // HEIGHT
        // --------------------------------------------
        System.out.println("\nHeight of Tree:");
        System.out.println(height(root));

        // --------------------------------------------
        // COUNT OF NODES
        // --------------------------------------------
        System.out.println("\nCount of Nodes:");
        System.out.println(countOfNodes(root));

        // --------------------------------------------
        // SUM OF NODES
        // --------------------------------------------
        System.out.println("\nSum of Nodes:");
        System.out.println(sumOfNodes(root));

        // --------------------------------------------
        // DIAMETER - O(N^2)
        // --------------------------------------------
        System.out.println("\nDiameter - O(N^2):");
        System.out.println(diameter(root));

        // --------------------------------------------
        // DIAMETER - O(N)
        // --------------------------------------------
        TreeInfo info = diameter2(root);

        System.out.println("\nDiameter - O(N):");
        System.out.println(info.diam);

        System.out.println("\nHeight using Diameter Approach:");
        System.out.println(info.ht);
    }
}