package edu.zju.zjh.lc.offer;

/**
 * @author: zjh
 * @date : 2022/4/15 下午 04:14
 * @Email : 2757412961@qq.com
 * @update:
 */

public class O0055_II {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private boolean isBalance = true;

    private int dfs(TreeNode root) {
        if (!isBalance) return 0;
        if (root == null) return 0;

        int left = dfs(root.left);
        int right = dfs(root.right);

        if (Math.abs(left - right) > 1) isBalance = false;

        return Math.max(left, right) + 1;
    }

    public boolean isBalanced(TreeNode root) {
        dfs(root);
        return isBalance;
    }

}
