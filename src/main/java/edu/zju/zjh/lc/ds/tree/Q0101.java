package edu.zju.zjh.lc.ds.tree;

/**
 * @author: zjh
 * @date : 2022/3/4 14:19
 * @Email : 2757412961@qq.com
 * @update:
 */

public class Q0101 {

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

    public boolean isSymmetric(TreeNode root) {
        return isSymmetric(root, root);
    }

    boolean isSymmetric(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        if (p.val != q.val) return false;

        return isSymmetric(p.left, q.right) && isSymmetric(p.right, q.left);
    }

}
