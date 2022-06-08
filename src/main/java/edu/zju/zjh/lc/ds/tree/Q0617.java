package edu.zju.zjh.lc.ds.tree;

/**
 * @author: zjh
 * @date : 2022/6/8 21:19
 * @Email : 2757412961@qq.com
 * @update:
 */

public class Q0617 {

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
     * 内存消耗:41.3 MB,击败了57.21% 的Java用户
     */
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null) return root2;
        if (root2 == null) return root1;
        root1.val += root2.val;

        if (root1.left == null) {
            root1.left = root2.left;
            root2.left = null;
        }
        mergeTrees(root1.left, root2.left);

        if (root1.right == null) {
            root1.right = root2.right;
            root2.right = null;
        }
        mergeTrees(root1.right, root2.right);

        return root1;
    }

}