package Trees;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class IterativeInOrderTraversal {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.left.right.left = new TreeNode(5);
        root.left.right.right = new TreeNode(6);
        System.out.println(iterativeInOrderTraversal(root));
    }

    private static List<Integer> iterativeInOrderTraversal(TreeNode root){
        if (root == null) return new ArrayList<>();
        List<Integer> traversedList = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode currentNode = root;
        while (true){
            while (currentNode != null){
                stack.push(currentNode);
                currentNode = currentNode.left;
            }

            if (stack.isEmpty()) break;

            currentNode = stack.pop();
            traversedList.add(currentNode.data);
            currentNode = currentNode.right;
        }
        return traversedList;
    }
}
