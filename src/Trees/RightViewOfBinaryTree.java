package Trees;

import java.util.*;

public class RightViewOfBinaryTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.right.left = new TreeNode(6);

        root.right.right = new TreeNode(7);

        rightViewOfBTree(root);
        List<Integer> list = new ArrayList<>();
        rightSideViewOfBTreeRecursive(root, 0, list);
        System.out.println(list);
    }

    private static void rightViewOfBTree(TreeNode root){
        Queue<NodeAxis> queue = new LinkedList<>();
        TreeMap<Integer, Integer> map = new TreeMap<>();
        queue.offer(new NodeAxis(root, 0));

        while (!queue.isEmpty()){
            TreeNode currentNode = queue.peek().node;
            int currentLevel = queue.peek().xAxis;
            queue.poll();

            map.put(currentLevel, currentNode.data);

            if (currentNode.right != null) queue.offer(new NodeAxis(currentNode.left, currentLevel+1));
            if (currentNode.left != null) queue.offer(new NodeAxis(currentNode.right, currentLevel+1));
        }

        System.out.println(map);
    }

    private static void rightSideViewOfBTreeRecursive(TreeNode node, int level, List<Integer> list){
        if (node == null) return;

        if (list.size() == level) list.add(node.data);

        rightSideViewOfBTreeRecursive(node.right, level+1, list);
        rightSideViewOfBTreeRecursive(node.left, level+1, list);
        return;
    }
}

class NodeLevel{
    public NodeLevel(TreeNode node, int level){
        this.level = level;
        this.node = node;
    }
    TreeNode node;
    int level;
}


