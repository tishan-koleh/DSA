package Trees;

public class FindCeilValueInBST {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(13);

        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(6);
        root.left.left.left = new TreeNode(2);
        root.left.left.right = new TreeNode(4);
        root.left.right.right = new TreeNode(9);

        root.right.left = new TreeNode(11);
        root.right.right = new TreeNode(14);
    }

    /*private static void findCeil(TreeNode root, int data){
        int ceil = data;
        while (root != null){
            if (root.left)
        }
    }*/
}
