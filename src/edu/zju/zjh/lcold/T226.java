package edu.zju.zjh.lcold;

public class T226 {

    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;

        TreeNode left = invertTree(root.left);
        TreeNode righ = invertTree(root.right);

        root.left = righ;
        root.right = left;

        return root;
    }

    public static void main(String[] args) {
        String inputs = "[4,2,7,1,3,6,9]";

        TreeNode root = new CodeTree().deserialize(inputs);
        System.out.println(new CodeTree().serialize(root));

        TreeNode res  = new T226().invertTree(root);
        res.printTree();
    }
}
