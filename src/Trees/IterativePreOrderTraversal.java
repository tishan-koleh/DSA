package Trees;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class IterativePreOrderTraversal {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.left.right.left = new TreeNode(5);
        root.left.right.right = new TreeNode(6);

        System.out.println(iterativePreOrderTraversal(root));
    }

    private static List<Integer> iterativePreOrderTraversal(TreeNode root){
        if (root == null) return new ArrayList<>();
        List<Integer> traversedList = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode currentNode = stack.pop();
            traversedList.add(currentNode.data);
            if (currentNode.right != null) stack.push(currentNode.right);
            if (currentNode.left != null) stack.push(currentNode.left);
        }
        return traversedList;
    }
}
