package edu.zju.zjh.lc.dp.rob;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: zjh
 * @date : 2022/4/30 11:53
 * @Email : 2757412961@qq.com
 * @update:
 */

public class Q0337 {

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

    private Map<TreeNode, Integer> memo = new HashMap<>();
    private Map<TreeNode, Integer> memoskip = new HashMap<>();

    public int rob(TreeNode root, boolean skip) {
        if (root == null) return 0;

        int max = 0;
        if (skip) {
            if (memoskip.containsKey(root)) return memoskip.get(root);
            max = rob(root.left, false) + rob(root.right, false);
            memoskip.put(root, max);
        } else {
            if (memo.containsKey(root)) return memo.get(root);
            max = Math.max(
                    root.val + rob(root.left, true) + rob(root.right, true),
                    rob(root.left, false) + rob(root.right, false)
            );
            memo.put(root, max);
        }

        return max;
    }

    public int rob(TreeNode root) {
        return Math.max(rob(root, false), rob(root, true));
    }

}
