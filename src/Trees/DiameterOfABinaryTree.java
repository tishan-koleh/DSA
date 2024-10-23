package Trees;

public class DiameterOfABinaryTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        root.right.right = new TreeNode(6);
        root.right.right.right = new TreeNode(7);
        root.right.right.right.right = new TreeNode(8);

        int[] diameter = new int[1];
        diameter[0] = Integer.MIN_VALUE;
        int i = diameterOfBinaryTree(root, diameter);
        System.out.println(diameter[0]);
    }

    private static int diameterOfBinaryTree(TreeNode node, int[] diameter){
        if (node == null) return 0;

        int left = diameterOfBinaryTree(node.left, diameter);
        int right = diameterOfBinaryTree(node.right, diameter);
        diameter[0] = Math.max(diameter[0], left+right);

        return 1 + Math.max(left, right);
    }
}
