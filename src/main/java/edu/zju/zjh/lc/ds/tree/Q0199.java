package edu.zju.zjh.lc.ds.tree;

import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author: zjh
 * @date : 2022/5/31 20:48
 * @Email : 2757412961@qq.com
 * @update:
 */

public class Q0199 {

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
     * 执行耗时:1 ms,击败了81.13% 的Java用户
     * 内存消耗:40.3 MB,击败了14.10% 的Java用户
     */
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        LinkedList<TreeNode> que = new LinkedList<>();
        if (root != null) que.offerLast(root);

        while (!que.isEmpty()) {
            int size = que.size();
            res.add(que.peekLast().val);
            for (int i = 0; i < size; i++) {
                TreeNode node = que.pollFirst();
                if (node.left != null) que.offer(node.left);
                if (node.right != null) que.offer(node.right);
            }
        }

        return res;
    }

}
