package edu.zju.zjh.lc.ds.tree;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: zjh
 * @date : 2022/5/31 9:41
 * @Email : 2757412961@qq.com
 * @update:
 */

public class Q0113 {

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
     * 执行耗时:1 ms,击败了99.98% 的Java用户
     * 内存消耗:41.5 MB,击败了80.59% 的Java用户
     */
    private List<List<Integer>> res = new LinkedList<>();
    private LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if (root == null) return res;
        if (root.left == null && root.right == null && targetSum == root.val) {
            path.addLast(root.val);
            res.add(new LinkedList<>(path));
            path.removeLast();
            return res;
        }

        path.addLast(root.val);
        pathSum(root.left, targetSum - root.val);
        pathSum(root.right, targetSum - root.val);
        path.removeLast();

        return res;
    }

}
