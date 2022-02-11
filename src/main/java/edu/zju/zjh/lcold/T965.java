package main.java.edu.zju.zjh.lcold;

public class T965 {
    public boolean dfs(TreeNode root, int target) {
        if (root == null) return true;
        boolean flag = false;

        if (root.val == target) {
            flag = true;
        }

        boolean bleft = dfs(root.left, target);
        boolean brigh = dfs(root.right, target);

        return flag && bleft && brigh;
    }

    public boolean isUnivalTree(TreeNode root) {
        if (root == null) return true;

        return dfs(root, root.val);
    }

    public static void main(String[] args) {
//        如果二叉树每个节点都具有相同的值，那么该二叉树就是单值二叉树。
//        只有给定的树是单值二叉树时，才返回 true；否则返回 false。

        String inputs = "[1,1,1,1,1,null,1]";
        TreeNode root = new CodeTree().deserialize(inputs);

        System.out.println(new T965().isUnivalTree(root));
    }
}
