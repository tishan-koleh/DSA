package Trees;

import java.util.List;

public class BalancedBinaryTree {
    public static void main(String[] args) {
        int[] elements = {1, 2, 3, 4, 5, 6, 7, 8};

        TreeNode root = buildBalancedTree(elements, 0, elements.length - 1);

        System.out.println(isBalanced(root));
    }

    public static TreeNode buildBalancedTree(int[] arr, int start, int end) {
        if (start > end) {
            return null;
        }

        // Find the middle element and make it root
        int mid = (start + end) / 2;
        TreeNode node = new TreeNode(arr[mid]);

        // Recursively construct the left subtree and right subtree
        node.left = buildBalancedTree(arr, start, mid - 1);
        node.right = buildBalancedTree(arr, mid + 1, end);

        return node;
    }

    private static boolean isBalanced(TreeNode root){
        if (root == null) return true;

        int left = findLeftHeight(root.left);
        int right = findRightHeight(root.right);

        if (Math.abs(left - right) > 1) return false;

        return isBalanced(root.left) && isBalanced(root.right);
    }

    private static int findLeftHeight(TreeNode node){
        int height = 0;
        while (node != null){
            height++;
            node = node.left;
        }
        return height;
    }

    private static int findRightHeight(TreeNode node){
        int height = 0;
        while (node != null){
            height++;
            node = node.right;
        }
        return height;
    }
}
