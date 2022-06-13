package edu.zju.zjh.lc.ds.tree;

/**
 * @author: zjh
 * @date : 2022/5/31 10:14
 * @Email : 2757412961@qq.com
 * @update:
 */

public class Q0124 {

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
     * 方法一：递归 时间复杂度：O(N)
     * 分解问题，计算各个节点的最大路径值。然后计算左右子树连接的最大路径
     * <p>
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:42.9 MB,击败了55.07% 的Java用户
     */
    private class S1 {

        private int res = Integer.MIN_VALUE;

        public int maxPath(TreeNode root) {
            if (root == null) return -10000;

            int left = maxPath(root.left);
            int right = maxPath(root.right);

            // 取最大值：当前节点、左子树加当前、右子树加当前
            int max = Math.max(root.val, Math.max(left, right) + root.val);

            // 加上左右子树连接的情况
            res = Math.max(res, Math.max(max, left + right + root.val));

            return max;
        }

        public int maxPathSum(TreeNode root) {
            maxPath(root);
            return res;
        }

    }

    /**
     * 二刷：参考法一
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:43.3 MB,击败了5.13% 的Java用户
     */
    private class S2 {

        private int res = 0;

        public int maxPath(TreeNode root) {
            if (root == null) return -10000;

            int left = maxPath(root.left);
            int right = maxPath(root.right);
            int max = Math.max(root.val, Math.max(left, right) + root.val);

            res = Math.max(res, Math.max(max, left + right + root.val));

            return max;
        }

        public int maxPathSum(TreeNode root) {
            maxPath(root);
            return res;
        }

    }

}
