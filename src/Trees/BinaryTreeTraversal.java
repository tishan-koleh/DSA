package Trees;

public class BinaryTreeTraversal {
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

        preOrderTraversal(root);
        System.out.println();
        postOrderTraversal(root);
        System.out.println();
        inOrderTraversal(root);
    }

    private static void preOrderTraversal(TreeNode treeNode){
        if (treeNode == null) return;
        System.out.print(treeNode.data+" ");
        preOrderTraversal(treeNode.left);
        preOrderTraversal(treeNode.right);
    }

    private static void postOrderTraversal(TreeNode treeNode){
        if (treeNode == null){
            return;
        }
        postOrderTraversal(treeNode.left);
        postOrderTraversal(treeNode.right);
        System.out.print(treeNode.data+" ");
    }

    private static void inOrderTraversal(TreeNode treeNode){
        if (treeNode == null){
            return;
        }
        inOrderTraversal(treeNode.left);
        System.out.print(treeNode.data+" ");
        inOrderTraversal(treeNode.right);
    }
}
