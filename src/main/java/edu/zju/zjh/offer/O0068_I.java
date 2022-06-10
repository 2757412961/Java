package edu.zju.zjh.offer;

/**
 * @author: zjh
 * @date : 2022/4/26 15:25
 * @Email : 2757412961@qq.com
 * @update:
 */

public class O0068_I {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        int min = Math.min(p.val, q.val);
        int max = Math.max(p.val, q.val);

        while (root != null) {
            if (max < root.val) {
                root = root.left;
            } else if (min > root.val) {
                root = root.right;
            } else {
                break;
            }
        }

        return root;
    }

}
