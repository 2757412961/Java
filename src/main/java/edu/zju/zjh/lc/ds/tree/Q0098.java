package edu.zju.zjh.lc.ds.tree;

import lombok.val;

/**
 * @author: zjh
 * @date : 2022/5/29 17:18
 * @Email : 2757412961@qq.com
 * @update:
 */

public class Q0098 {

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
     * 方法一: 递归
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:40.5 MB,击败了97.86% 的Java用户
     */
    private class S1 {

        public boolean isValidBST(TreeNode root, TreeNode min, TreeNode max) {
            if (root == null) return true;

            if (min != null && min.val >= root.val) {
                return false;
            }
            if (max != null && max.val <= root.val) {
                return false;
            }

            return isValidBST(root.left, min, root) && isValidBST(root.right, root, max);
        }

        public boolean isValidBST(TreeNode root) {
            return isValidBST(root, null, null);
        }

    }

    /**
     * 方法二：中序遍历 O(n)
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:41.3 MB,击败了7.61% 的Java用户
     */
    private class S2 {

        private boolean ans = true;
        private long last = Long.MIN_VALUE;

        public void inorder(TreeNode root) {
            if (!ans) return;
            if (root == null) return;

            inorder(root.left);
            if (root.val <= last) {
                ans = false;
                return;
            }
            last = root.val;
            inorder(root.right);
        }

        public boolean isValidBST(TreeNode root) {
            inorder(root);
            return ans;
        }

    }

}
