package Trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderTraversal {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        System.out.println(levelOrderTraversal(root));
    }

    private static List<List<Integer>> levelOrderTraversal(TreeNode treeNode){
        if (treeNode == null) return new ArrayList<>();
        List<List<Integer>> wrapList = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(treeNode);
        while (!queue.isEmpty()){
            List<Integer> subList = new ArrayList<>();
            int n = queue.size();
            for (int i = 0; i < n; i++){
                TreeNode currentNode = queue.poll();
                subList.add(currentNode.data);
                if (currentNode.left != null) queue.offer(currentNode.left);
                if (currentNode.right != null) queue.offer(currentNode.right);
            }
            wrapList.add(subList);
        }
        return wrapList;
    }
}

