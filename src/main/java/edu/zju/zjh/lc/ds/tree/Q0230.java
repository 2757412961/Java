package edu.zju.zjh.lc.ds.tree;

/**
 * @author: zjh
 * @date : 2022/6/7 14:45
 * @Email : 2757412961@qq.com
 * @update:
 */

public class Q0230 {

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

    /**
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:40.6 MB,击败了99.63% 的Java用户
     */
    private int k;

    public int kthSmallest(TreeNode root) {
        if (root == null) return -1;

        int left = kthSmallest(root.left);
        if (--k == 0) {
            return root.val;
        }
        int right = kthSmallest(root.right);

        return Math.max(left, right);
    }

    public int kthSmallest(TreeNode root, int k) {
        this.k = k;
        return kthSmallest(root);
    }

}
