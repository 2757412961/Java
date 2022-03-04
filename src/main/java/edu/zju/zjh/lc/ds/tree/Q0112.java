package edu.zju.zjh.lc.ds.tree;

/**
 * @author: zjh
 * @date : 2022/3/3 11:23
 * @Email : 2757412961@qq.com
 * @update:
 */

public class Q0112 {

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

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;
        int res = targetSum - root.val;
        if (root.left == null && root.right == null) {
            return res == 0;
        }

        return hasPathSum(root.left, res) ||
                hasPathSum(root.right, res);
    }
}
