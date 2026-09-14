/*
    Given the root of a Binary tree, flatten the tree into a linked list.

    The "Linked list" should use the same TreeNode class where the right child pointer points to the next node in the list and the 
    left child pointer is always null

    The "Linked list" should be in the same order as pre-order traversal of the binary tree.

    Example1:
    Input: root = [1, 2, 5, 3, 4, null, 6]
    output: [1, null, 2, null, 3, null, 4, null, 5, null, 6]

    Example2:
    Input: root = []
    output: []

    Example3:
    Input: root = [0]
    output: [0]
     */

public class FlattenBT {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    static void flatten(TreeNode root) {

        TreeNode curr = root;

        while (curr != null) {

            if (curr.left != null) {

                // Save original right subtree
                TreeNode rightSubtree = curr.right;

                // Find rightmost node of left subtree
                TreeNode temp = curr.left;

                while (temp.right != null) {
                    temp = temp.right;
                }

                // Attach original right subtree
                temp.right = rightSubtree;

                // Move left subtree to right
                curr.right = curr.left;

                // Left must be null
                curr.left = null;
            }

            curr = curr.right;
        }
    }

    // Print in LeetCode format
    static void printResult(TreeNode root) {

        System.out.print("[");

        TreeNode curr = root;

        while (curr != null) {

            System.out.print(curr.val);

            if (curr.right != null) {
                System.out.print(",null,");
            }

            curr = curr.right;
        }

        System.out.println("]");
    }

    public static void main(String[] args) {

        // Create tree
        //
        //         1
        //        / \
        //       2   5
        //      / \   \
        //     3   4   6

        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(2);
        root.right = new TreeNode(5);

        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);

        root.right.right = new TreeNode(6);

        // Flatten
        flatten(root);

        // Print result
        printResult(root);
    }
}