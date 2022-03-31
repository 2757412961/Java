package edu.zju.zjh.lc.offer;

import java.util.LinkedList;
import java.util.List;

public class O0032_III {

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

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();

        if (root != null) queue.addLast(root);
        while (!queue.isEmpty()) {
            int n = queue.size();
            LinkedList<Integer> row = new LinkedList<>();

            if (res.size() % 2 == 0) {
                for (int i = 0; i < n; i++) {
                    TreeNode node = queue.pollFirst();
                    row.add(node.val);
                    if (node.left != null) queue.addLast(node.left);
                    if (node.right != null) queue.addLast(node.right);
                }
            } else {
                for (int i = 0; i < n; i++) {
                    TreeNode node = queue.pollLast();
                    row.add(node.val);
                    if (node.right != null) queue.addFirst(node.right);
                    if (node.left != null) queue.addFirst(node.left);
                }
            }

            res.add(row);
        }

        return res;
    }

}
