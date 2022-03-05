package edu.zju.zjh.lc.offer;

/**
 * @author: zjh
 * @date : 2022/3/4 14:40
 * @Email : 2757412961@qq.com
 * @update:
 */

public class O0027 {

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

    public void swapTree(TreeNode root) {
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
    }

    public TreeNode mirrorTree(TreeNode root) {
        if (root == null) return root;

        swapTree(root);
        mirrorTree(root.left);
        mirrorTree(root.right);

        return root;
    }

}
