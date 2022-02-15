package edu.zju.zjh.lcold;

public class T404 {
    public int dfs(TreeNode root) {
        if (root == null) return 0;
        int val = 0;

        if (root.left != null) {
            if (root.left.left == null && root.left.right == null) {
                val = root.left.val;
            }
        }

        return dfs(root.left) + dfs(root.right) + val;
    }

    public int sumOfLeftLeaves(TreeNode root) {
        int res = 0;

        res = dfs(root);
        return res;
    }

    public static void main(String[] args) {
//        计算给定二叉树的所有左叶子之和。
//
//        示例：
//                 3
//                / \
//               9  20
//                 /  \
//                15   7
//
//        在这个二叉树中，有两个左叶子，分别是 9 和 15，所以返回 24

        String inputs = "[3,9,20,null,null,15,7]";
        TreeNode root = new CodeTree().deserialize(inputs);
        System.out.println(new CodeTree().serialize(root));

        System.out.println(new T404().sumOfLeftLeaves(root));
    }
}
