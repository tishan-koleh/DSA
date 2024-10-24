package Trees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.TreeMap;

public class TopViewOfABinaryTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.right.left = new TreeNode(6);

        root.right.right = new TreeNode(7);

        topViewOfBTree(root);
    }

    private static void topViewOfBTree(TreeNode root){
        Queue<NodeAxis> queue = new LinkedList<>();
        TreeMap<Integer, Integer> map = new TreeMap<>();
        queue.offer(new NodeAxis(root, 0));

        while (!queue.isEmpty()){
            TreeNode currentNode = queue.peek().node;
            int currentAxis = queue.peek().xAxis;
            queue.poll();

            map.putIfAbsent(currentAxis, currentNode.data);

            if (currentNode.left != null) queue.offer(new NodeAxis(currentNode.left, currentAxis-1));
            if (currentNode.right != null) queue.offer(new NodeAxis(currentNode.right, currentAxis+1));
        }

        System.out.println(map);
    }
}

class NodeAxis{
    public NodeAxis(TreeNode node, int xAxis){
        this.xAxis = xAxis;
        this.node = node;
    }
    TreeNode node;
    int xAxis;
}
