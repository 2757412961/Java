package edu.zju.zjh.lc.ds.tree;

/**
 * @author: zjh
 * @date : 2022/3/7 19:19
 * @Email : 2757412961@qq.com
 * @update:
 */

public class Q0110 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    private boolean balance = true;

    private int maxDepth(TreeNode root) {
        if (!balance) return 0;
        if (root == null) return 0;

        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        int diff = left - right;
        if (diff < -1 || 1 < diff) {
            balance = false;
        }

        return Math.max(left, right) + 1;
    }

    public boolean isBalanced(TreeNode root) {
        maxDepth(root);
        return balance;
    }

}
