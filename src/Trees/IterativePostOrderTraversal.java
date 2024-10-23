package Trees;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class IterativePostOrderTraversal {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        root.right.right = new TreeNode(6);
        root.right.right.right = new TreeNode(7);
        root.right.right.right.right = new TreeNode(8);

        System.out.println(iterativePostOrderTraversal(root));
    }

    private static List<Integer> iterativePostOrderTraversal(TreeNode root){
        if (root == null) return new ArrayList<>();
        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();
        TreeNode currentNode = root;
        s1.push(currentNode);
        while (true){
            currentNode = s1.pop();
            s2.push(currentNode);
            if (currentNode.left != null) s1.push(currentNode.left);
            if (currentNode.right != null) s1.push(currentNode.right);
            if (s1.isEmpty()) break;
        }
        List<Integer> list = new ArrayList<>();
        while (!s2.isEmpty()){
            list.add(s2.pop().data);
        }

        return list;
    }
}
