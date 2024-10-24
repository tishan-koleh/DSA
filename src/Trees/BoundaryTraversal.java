package Trees;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BoundaryTraversal {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.right.left = new TreeNode(6);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(8);
        root.right.right.left = new TreeNode(9);
        root.right.right.right = new TreeNode(10);

        System.out.println(boundaryTraversal(root));
    }

    private static List<Integer> boundaryTraversal(TreeNode root){
        if (root == null) return new ArrayList<>();

        List<Integer> ans = new ArrayList<>();

        if (!isLeaf(root)) ans.add(root.data);  // Add root if it's not a leaf

        // Add left boundary (excluding leaf nodes)
        leftBoundary(root.left, ans);

        // Add all leaf nodes
        addLeaves(root, ans);

        // Add right boundary (excluding leaf nodes) in reverse order
        rightBoundary(root.right, ans);

        return ans;
    }

    // Helper function to collect left boundary nodes
    private static void leftBoundary(TreeNode node, List<Integer> result) {
        while (node != null) {
            if (!isLeaf(node)) result.add(node.data);
            node = (node.left != null) ? node.left : node.right;
        }
    }

    // Helper function to collect right boundary nodes
    private static void rightBoundary(TreeNode node, List<Integer> result) {
        List<Integer> temp = new ArrayList<>();
        while (node != null) {
            if (!isLeaf(node)) temp.add(node.data);
            node = (node.right != null) ? node.right : node.left;
        }
        Collections.reverse(temp);
        result.addAll(temp);
    }

    // Helper function to collect leaf nodes
    private static void addLeaves(TreeNode node, List<Integer> result) {
        if (node == null) return;
        if (isLeaf(node)) {
            result.add(node.data);
            return;
        }
        addLeaves(node.left, result);
        addLeaves(node.right, result);
    }

    // Utility function to check if a node is a leaf
    private static boolean isLeaf(TreeNode node) {
        return (node.left == null && node.right == null);
    }
}