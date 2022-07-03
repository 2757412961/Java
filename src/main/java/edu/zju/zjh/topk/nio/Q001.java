package edu.zju.zjh.topk.nio;

/**
 * @author: zjh
 * @date : 2022/7/3 下午 07:01
 * @Email : 2757412961@qq.com
 * @update:
 */

public class Q001 {

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    private int res = 0;

    public void dfs(TreeNode root) {
        if (root == null) return;
        if (root.left != null && root.right != null) {
            res++;
        }
        dfs(root.left);
        dfs(root.right);
    }

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param root TreeNode类
     * @return int整型
     */
    public int maxSum(TreeNode root) {
        // write code here
        dfs(root);

        return res;
    }

}
