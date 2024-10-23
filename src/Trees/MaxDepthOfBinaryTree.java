package Trees;

import com.sun.source.tree.Tree;

public class MaxDepthOfBinaryTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        root.right.right = new TreeNode(6);
        root.right.right.right = new TreeNode(7);
        root.right.right.right.right = new TreeNode(8);

        System.out.println(maxDepth(root));
    }

    private static int maxDepth(TreeNode root){
        if (root == null) return 0;

        int maxLeft = 1 + maxDepth(root.left);
        int maxRight = 1 + maxDepth(root.right);

        return Math.max(maxLeft, maxRight);
    }
}
