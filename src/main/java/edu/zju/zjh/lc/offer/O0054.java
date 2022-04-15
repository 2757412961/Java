package edu.zju.zjh.lc.offer;

/**
 * @author: zjh
 * @date : 2022/4/15 下午 03:37
 * @Email : 2757412961@qq.com
 * @update:
 */

public class O0054 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private int k;
    private int res;

    public void dfs(TreeNode root) {
        if (root == null) return;
        if (k <= 0) return;

        dfs(root.right);
        if (--k == 0) {
            res = root.val;
        }
        dfs(root.left);
    }

    public int kthLargest(TreeNode root, int k) {
        this.k = k;
        dfs(root);
        return res;
    }

}
