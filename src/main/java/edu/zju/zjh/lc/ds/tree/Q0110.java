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

    /**
     * 自底向上 深度遍历
     */
    private class S1 {

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

    /**
     * 二刷
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:41.6 MB,击败了5.28% 的Java用户
     */
    private class S2 {

        public int isDepthBalanced(TreeNode root) {
            if (root == null) return 0;

            int l = isDepthBalanced(root.left);
            int r = isDepthBalanced(root.right);

            if (l == -1 || r == -1) {
                return -1;
            }
            if (Math.abs(l - r) > 1) {
                return -1;
            }

            return Math.max(l, r) + 1;
        }

        public boolean isBalanced(TreeNode root) {
            return isDepthBalanced(root) >= 0;
        }

    }

}
