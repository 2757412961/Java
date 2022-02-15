package edu.zju.zjh.lcold;

public class O027 {
    public TreeNode mirrorTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        mirrorTree(root.left);
        mirrorTree(root.right);

        return root;
    }

    public static void main(String[] args) {
        String inputs = "[4,2,7,1,3,6,9]";
        String[] stringNodes = inputs.substring(1, inputs.length() - 1).split(",");

        TreeNode root = new TreeNode(-1);
        root = root.buildTree(stringNodes);
        root.printTree();

        TreeNode mirror = new O027().mirrorTree(root);
        mirror.printTree();
    }
}
