package edu.zju.zjh.lc.ds.tree.trans;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author: zjh
 * @date : 2022/7/12 22:00
 * @Email : 2757412961@qq.com
 * @update:
 */

public class Q0145 {

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

        public List<Integer> postorderTraversal(TreeNode root) {
            List<Integer> res = new ArrayList<>();
            Stack<TreeNode> stack = new Stack<>();
            TreeNode last = null;

            while (root != null || !stack.isEmpty()) {
                while (root != null) {
                    stack.push(root);
                    root = root.left;
                }

                root = stack.pop();
                if (root.right == null || root.right == last) {
                    res.add(root.val);
                    last = root;
                    root = null;
                } else if (root.right != null) {
                    stack.push(root);
                    root = root.right;
                }
            }

            return res;
        }

    }

}
