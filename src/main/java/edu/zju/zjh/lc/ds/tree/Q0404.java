package edu.zju.zjh.lc.ds.tree;

/**
 * @author: zjh
 * @date : 2022/3/10 9:52
 * @Email : 2757412961@qq.com
 * @update:
 */

public class Q0404 {

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

    public int sumOfLeftLeaves(TreeNode root, boolean isLeft) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) {
            if (isLeft) {
                return root.val;
            } else {
                return 0;
            }
        }

        int left = sumOfLeftLeaves(root.left, true);
        int right = sumOfLeftLeaves(root.right, false);

        return left + right;
    }

    public int sumOfLeftLeaves(TreeNode root) {
        return sumOfLeftLeaves(root, false);
    }

}
