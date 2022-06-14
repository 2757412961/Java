package edu.zju.zjh.lc.ds.tree;

/**
 * @author: zjh
 * @date : 2022/6/14 19:44
 * @Email : 2757412961@qq.com
 * @update:
 */

public class Q0700 {

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
     * 内存消耗:41.5 MB,击败了83.62% 的Java用户
     */
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) return root;

        if (root.val == val) {
            return root;
        } else if (root.val < val) {
            return searchBST(root.right, val);
        } else if (root.val > val) {
            return searchBST(root.left, val);
        }
        return null;
    }

}
