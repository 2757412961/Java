package edu.zju.zjh.lc.ds.tree;

/**
 * @author: zjh
 * @date : 2022/3/8 16:10
 * @Email : 2757412961@qq.com
 * @update:
 */

public class Q0235 {

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

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode res = root;

        int minv = Math.min(p.val, q.val), maxv = Math.max(p.val, q.val);

        while (res != null) {
            if (maxv < res.val) {
                res = res.left;
            } else if (res.val < minv) {
                res = res.right;
            } else {
                return res;
            }
        }

        return res;
    }

}
