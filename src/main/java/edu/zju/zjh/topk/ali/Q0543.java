package edu.zju.zjh.topk.ali;

/**
 * @author: zjh
 * @date : 2022/5/11 13:44
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

    public int res = 0;

    public int dfs(TreeNode root) {
        if (root == null) return 0;

        int left = dfs(root.left);
        int right = dfs(root.right);

        res = Math.max(res, left + right);
        return Math.max(left, right) + 1;
    }

    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return res;
    }

}
