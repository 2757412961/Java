package edu.zju.zjh.lc.ds.tree;

/**
 * @author: zjh
 * @date : 2022/6/14 19:44
 * @Email : 2757412961@qq.com
 * @update:
 */

public class Q0701 {

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
     * 内存消耗:42.1 MB,击败了44.01% 的Java用户
     */
    private class S1 {

        public TreeNode insertIntoBST(TreeNode root, int val) {
            if (root == null) return new TreeNode(val);

            if (root.val == val) {
            } else if (root.val < val) {
                root.right = insertIntoBST(root.right, val);
            } else if (root.val > val) {
                root.left = insertIntoBST(root.left, val);
            }

            return root;
        }

    }

    /**
     * 二刷：
     */
    private class S2 {

        public TreeNode insertIntoBST(TreeNode root, int val) {
            if (root == null) return new TreeNode(val);

            root.left = insertIntoBST(root.left, val);
            root.right = insertIntoBST(root.right, val);

            return root;
        }

    }

}
