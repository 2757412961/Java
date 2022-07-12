package edu.zju.zjh.lc.ds.tree.trans;

import java.util.*;

/**
 * @author: zjh
 * @date : 2022/7/12 21:59
 * @Email : 2757412961@qq.com
 * @update:
 */

public class Q0094 {

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
     *
     */
    private class S2 {

        public List<Integer> inorderTraversal(TreeNode root) {
            List<Integer> res = new ArrayList<>();
            Stack<TreeNode> stack = new Stack<>();
            Map<TreeNode, Boolean> map = new HashMap<>();

            TreeNode node = root;
            if (root != null) stack.add(root);

            while (!stack.isEmpty()) {
                while (node.left != null && map.getOrDefault(node, true)) {
                    stack.push(node.left);
                    node = node.left;
                }

                node = stack.pop();
                map.put(node, false);
                res.add(node.val);

                if (node.right != null) {
                    stack.push(node.right);
                    node = node.right;
                }
            }

            return res;
        }

    }

}
