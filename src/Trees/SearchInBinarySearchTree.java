package Trees;

import java.util.ArrayList;
import java.util.List;

public class SearchInBinarySearchTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(8);
        root.left = new TreeNode(5);
        root.right = new TreeNode(12);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(7);
        root.left.right.left = new TreeNode(6);

        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(14);
        root.right.right.left = new TreeNode(13);

        List<TreeNode> list = new ArrayList<>();
        getNodeIterative(root, 14, list);
        if (list.isEmpty()){
            System.out.println("Not found");
            return;
        }else System.out.println(root.right.right == list.getFirst());
    }

    private static void getNode(TreeNode root, int data, List<TreeNode> list){
        if (root == null) return;
        if (root.data == data) {
            list.add(root);
            return;
        }

        if (data > root.data){
            getNode(root.right, data, list);
        } else {
            getNode(root.left, data, list);
        }
    }

    private static void getNodeIterative(TreeNode node, int data, List<TreeNode> list){
        if (node == null) return;

        while (true){
            if (node.data == data) {
                list.add(node);
                return;
            }
            if (data > node.data && node.right != null){
                node = node.right;
            } else if (data < node.data && node.left != null) {
                node = node.left;
            }else {
                return;
            }
        }
    }
}
