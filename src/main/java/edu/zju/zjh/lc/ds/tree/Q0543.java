package edu.zju.zjh.lc.ds.tree;

/**
 * @author: zjh
 * @date : 2022/3/2 20:24
 * @Email : 2757412961@qq.com
 * @update:
 */

public class Q0543 {

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
     * 1
     */
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;

        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) return 0;

        int diameter = maxDepth(root.left) + maxDepth(root.right);
        int left = diameterOfBinaryTree(root.left);
        int right = diameterOfBinaryTree(root.right);

        return Math.max(diameter, Math.max(left, right));
    }

    /**
     * 2
     */
    private int maxDiameter = 0;

    public int maxDepth2(TreeNode root) {
        if (root == null) return 0;

        int maxDepthLeft = maxDepth2(root.left);
        int maxDepthRight = maxDepth2(root.right);
        maxDiameter = Math.max(maxDiameter, maxDepthLeft + maxDepthRight);

        return Math.max(maxDepthLeft, maxDepthRight) + 1;
    }

    public int diameterOfBinaryTree2(TreeNode root) {
        maxDepth2(root);

        return maxDiameter;
    }

}
