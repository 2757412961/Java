package edu.zju.zjh.topk.阿里;

import java.util.LinkedList;
import java.util.List;

/**
 * @author: zjh
 * @date : 2022/5/10 21:24
 * @Email : 2757412961@qq.com
 * @update:
 */

public class Q0103 {

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

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        LinkedList<TreeNode> que = new LinkedList<>();
        boolean order = true;

        if (root != null) que.offer(root);

        while (!que.isEmpty()) {
            LinkedList<Integer> list = new LinkedList<>();
            int size = que.size();
            if (order) {
                while (size > 0) {
                    size--;
                    TreeNode node = que.pollFirst();
                    list.add(node.val);
                    if (node.left != null) que.offerLast(node.left);
                    if (node.right != null) que.offerLast(node.right);
                }
            } else {
                while (size > 0) {
                    size--;
                    TreeNode node = que.pollLast();
                    list.add(node.val);
                    if (node.right != null) que.offerFirst(node.right);
                    if (node.left != null) que.offerFirst(node.left);
                }
            }

            res.add(list);
            order = !order;
        }

        return res;
    }

}
