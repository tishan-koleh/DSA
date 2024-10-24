package Trees;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class FindVerticalOrderTraversal {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(10);

        root.left.left.right = new TreeNode(5);
        root.left.left.right.right = new TreeNode(6);

        root.right.right = new TreeNode(10);

        root.right.left = new TreeNode(9);
        VerticalOrderTraversal(root);
    }

    private static void VerticalOrderTraversal(TreeNode root){
        Queue<NodeAxisLevel> queue = new LinkedList<>();
        HashMap<Integer, PriorityQueue<Integer>> map = new HashMap<>();
        queue.offer(new NodeAxisLevel(root, 0, 0));

        while (!queue.isEmpty()){
            //CurrentNode
            TreeNode currentNode = queue.peek().node;
            int currentXAxis = queue.peek().xAxis;
            int currentLevel = queue.peek().level;
            queue.poll();

            map.putIfAbsent(currentXAxis, new PriorityQueue<Integer>());
            map.get(currentXAxis).offer(currentNode.data);

            //Putting in levelOrderTraversalQueue
            if (currentNode.left != null) queue.offer(new NodeAxisLevel(currentNode.left, currentXAxis - 1, currentLevel + 1));
            if (currentNode.right != null) queue.offer(new NodeAxisLevel(currentNode.right, currentXAxis + 1, currentLevel + 1));
        }

        System.out.println(map);
    }
}

class NodeAxisLevel{
    public NodeAxisLevel(TreeNode node, int xAxis, int level){
        this.node = node;
        this.xAxis = xAxis;
        this.level = level;
    }
    TreeNode node;
    int xAxis;
    int level;
}
