package main.java.edu.zju.zjh.lcold;

public class T623 {
    public void dfs(TreeNode root, int v, int d, int depth) {
        if (root == null) {
            return;
        }

        if (depth == d - 1) {
            TreeNode leftnode = new TreeNode(v);
            TreeNode rightnode = new TreeNode(v);
            TreeNode exchange = null;

            exchange = root.left;
            root.left = leftnode;
            leftnode.left = exchange;

            exchange = root.right;
            root.right = rightnode;
            rightnode.right = exchange;
            return;
        }

        dfs(root.left, v, d, depth + 1);
        dfs(root.right, v, d, depth + 1);
    }

    public TreeNode addOneRow(TreeNode root, int v, int d) {
        if (d == 1) {
            TreeNode rootnode = new TreeNode(v);
            rootnode.left = root;
            return rootnode;
        }
        dfs(root, v, d, 1);

        return root;
    }

    public static void main(String[] args) {
        String inputs = "[4,2,6,3,1,5]";
        String[] stringNodes = inputs.substring(1, inputs.length() - 1).split(",");
//        String[] stringNodes = TreeInput.Inputs();

        TreeNode root = new TreeNode(-1);
        root = root.buildTree(stringNodes);
        root.printTree();

        T623 t623 = new T623();
        root = t623.addOneRow(root, 1, 2);
        root.printTree();
    }
}
