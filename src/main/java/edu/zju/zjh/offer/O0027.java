package edu.zju.zjh.offer;

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

    /**
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:38.7 MB,击败了66.14% 的Java用户
     */
    private class S1 {

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

    /**
     * 二刷
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:39.1 MB,击败了15.32% 的Java用户
     */
    private class S2 {

        public TreeNode mirrorTree(TreeNode root) {
            if (root == null) return null;

            TreeNode left = root.left;
            TreeNode right = root.right;
            root.left = mirrorTree(right);
            root.right = mirrorTree(left);

            return root;
        }

    }

}
