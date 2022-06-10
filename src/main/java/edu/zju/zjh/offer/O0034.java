package edu.zju.zjh.offer;

import java.util.LinkedList;
import java.util.List;

public class O0034 {

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

    List<List<Integer>> res = new LinkedList<>();
    LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> pathSum(TreeNode root, int target) {
        if (root == null) return res;

        path.offerLast(root.val);
        int result = target - root.val;
        if (root.left == null && root.right == null && result == 0) {
            res.add(new LinkedList<>(path));
        }

        pathSum(root.left, result);
        pathSum(root.right, result);
        path.pollLast();

        return res;
    }

}
