package edu.zju.zjh.offer;

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

    /**
     *
     */
    private class S12 {

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

    /**
     * 二刷
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:41 MB,击败了49.40% 的Java用户
     */
    private class S2 {

        public int depth(TreeNode root) {
            if (root == null) return 0;

            int left = depth(root.left);
            int right = depth(root.right);

            if (left == -1 || right == -1 || Math.abs(left - right) > 1) {
                return -1;
            }

            return Math.max(left, right) + 1;
        }

        public boolean isBalanced(TreeNode root) {
            return depth(root) >= 0;
        }

    }

}
