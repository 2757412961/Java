package edu.zju.zjh.lc.ds.tree;

import javax.swing.tree.TreeNode;
import java.util.TreeMap;

/**
 * @author: zjh
 * @date : 2022/5/30 10:32
 * @Email : 2757412961@qq.com
 * @update:
 */

public class Q0226 {

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
     * 内存消耗:38.9 MB,击败了53.31% 的Java用户
     */
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return root;

        final TreeNode left = invertTree(root.left);
        final TreeNode right = invertTree(root.right);
        root.left = right;
        root.right = left;

        return root;
    }

}
