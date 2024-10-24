package Trees;

import java.util.List;

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

        //preOrderTraversal(root);
        System.out.println();
        //postOrderTraversal(root);
        System.out.println();
        //inOrderTraversal(root);
    }

    public static void preOrderTraversal(TreeNode treeNode, List<TreeNode> traversedList){
        if (treeNode == null) return;
        System.out.print(treeNode.data+" ");
        traversedList.add(treeNode);
        preOrderTraversal(treeNode.left, traversedList);
        preOrderTraversal(treeNode.right, traversedList);
    }

    public static void postOrderTraversal(TreeNode treeNode,  List<TreeNode> traversedList){
        if (treeNode == null){
            return;
        }
        postOrderTraversal(treeNode.left, traversedList);
        postOrderTraversal(treeNode.right, traversedList);
        System.out.print(treeNode.data+" ");
        traversedList.add(treeNode);
    }

    public static void inOrderTraversal(TreeNode treeNode,  List<TreeNode> traversedList){
        if (treeNode == null){
            return;
        }
        inOrderTraversal(treeNode.left, traversedList);
        System.out.print(treeNode.data+" ");
        traversedList.add(treeNode);
        inOrderTraversal(treeNode.right, traversedList);
    }
}
