package edu.zju.zjh.lc.ds.tree;

/**
 * @author: zjh
 * @date : 2022/5/31 15:10
 * @Email : 2757412961@qq.com
 * @update:
 */

public class Q0129 {

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
     * 方法一：深度优先搜索
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:39 MB,击败了48.02% 的Java用户
     */
    public int sumNumbersPath(TreeNode root, int prevSum) {
        if (root == null) return 0;

        int sum = prevSum * 10 + root.val;
        if (root.left == null && root.right == null) {
            return sum;
        }

        int left = sumNumbersPath(root.left, sum);
        int right = sumNumbersPath(root.right, sum);

        return left + right;
    }

    public int sumNumbers(TreeNode root) {
        return sumNumbersPath(root, 0);
    }

}
