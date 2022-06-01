package edu.zju.zjh.lc.ds.tree;

import java.util.LinkedList;

/**
 * @author: zjh
 * @date : 2022/6/1 10:40
 * @Email : 2757412961@qq.com
 * @update:
 */

public class Q0662 {

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
     * 层序遍历
     * 执行耗时:1 ms,击败了99.85% 的Java用户
     * 内存消耗:40.9 MB,击败了56.35% 的Java用户
     */
    public int widthOfBinaryTree(TreeNode root) {
        int res = 0;
        LinkedList<TreeNode> que = new LinkedList<>();

        if (root != null) {
            que.offerLast(root);
            root.val = 1;
        }

        while (!que.isEmpty()) {
            int size = que.size();
            res = Math.max(res, que.peekLast().val - que.peekFirst().val + 1);

            for (int i = 0; i < size; i++) {
                TreeNode node = que.pollFirst();
                if (node.left != null) {
                    node.left.val = node.val * 2;
                    que.offerLast(node.left);
                }
                if (node.right != null) {
                    node.right.val = node.val * 2 + 1;
                    que.offerLast(node.right);
                }
            }
        }

        return res;
    }

}
