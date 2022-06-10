package edu.zju.zjh.offer;

/**
 * @author: zjh
 * @date : 2022/4/15 下午 04:08
 * @Email : 2757412961@qq.com
 * @update:
 */

public class O0055_I {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int maxDepth(TreeNode root) {
        if (root == null) return 0;

        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

}
