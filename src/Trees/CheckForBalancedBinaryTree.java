package Trees;

public class CheckForBalancedBinaryTree {
    public static void main(String[] args) {
        /*int[] elements = {1, 2, 3, 4, 5, 6, 7, 8};

        TreeNode root = buildBalancedTree(elements, 0, elements.length - 1);*/

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        root.right.right = new TreeNode(6);
        root.right.right.right = new TreeNode(7);
        root.right.right.right.right = new TreeNode(8);
        boolean[] ans = new boolean[1];
        ans[0] = true;
        //System.out.println(isBalanced(root));
        int x = checkIfBalanced(root, ans);
        System.out.println(ans[0]);
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

    private static int checkIfBalanced(TreeNode node, boolean[] ans){
        if (node == null) return 0;

        int left = 1 + checkIfBalanced(node.left, ans);
        int right = 1 + checkIfBalanced(node.right, ans);

        if (Math.abs(left - right) > 1) ans[0] = false;
        return Math.max(left, right);
    }
}
