package edu.zju.zjh.lcold;

import java.util.LinkedList;
import java.util.Queue;

public class T236 {
    public String print2str(TreeNode node) {
        if (node == null) {
            return "";
        }
        return " " + String.valueOf(node.val) + " " + print2str(node.left) + " " + print2str(node.right) + " ";
    }

    public TreeNode lowestCommonAncestor_violenece(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode res = root;

        Queue<TreeNode> que = new LinkedList<>();
        que.add(root);

        int depth = 0;
        while (!que.isEmpty()) {
            TreeNode node = que.poll();
            String str = print2str(node);
            if (str.contains(String.valueOf(p.val)) && str.contains(String.valueOf(q.val))) {
                res = node;
            }
            if (node.left != null) que.add(node.left);
            if (node.right != null) que.add(node.right);
        }

        return res;
    }

    public int calDepth(TreeNode root, TreeNode target) {
        Queue<TreeNode> que = new LinkedList<>();
        que.add(root);

        int depth = 0;
        while (!que.isEmpty()) {
            int n = que.size();

            for (int i = 0; i < n; i++) {
                TreeNode node = que.poll();

                if (target.val == node.val) {
                    return depth;
                }

                if (node.left != null) que.add(node.left);
                if (node.right != null) que.add(node.right);
            }
            depth++;
        }

        return 0;
    }

    public TreeNode getFather(TreeNode root, TreeNode target) {
        Queue<TreeNode> que = new LinkedList<>();
        que.add(root);

        while (!que.isEmpty()) {
            TreeNode node = que.poll();

            if (node.left != null) {
                if (node.left.val == target.val) {
                    return node;
                }
                que.add(node.left);
            }
            if (node.right != null) {
                if (node.right.val == target.val) {
                    return node;
                }
                que.add(node.right);
            }
        }

        return root;

    }

    public TreeNode lowestCommonAncestor_ok(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode res = root, node;
        int depth = -1;

        if (calDepth(root, p) > calDepth(root, q)) {
            depth = calDepth(root, q);
            node = q;
        } else {
            depth = calDepth(root, p);
            node = p;
        }

        while (depth >= 0) {
            String str = print2str(node);
            if (str.contains(String.valueOf(p.val)) && str.contains(String.valueOf(q.val))) {
                return node;
            }

            node = getFather(root, node);
            depth--;
        }

        return res;
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        if (root.val == p.val || root.val == q.val) {
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left == null && right == null) {
            return null;
        } else if (left != null && right == null) {
            return left;
        } else if (left == null && right != null) {
            return right;
        } else {
            return root;
        }
    }

    public static void main(String[] args) {
        String inputs = "[3,5,1,6,2,0,8,null,null,7,4]";
        String[] stringNodes = inputs.substring(1, inputs.length() - 1).split(",");

        TreeNode root = new TreeNode(-1);
        root = root.buildTree(stringNodes);
        root.printTree();

        TreeNode p = new TreeNode(6);
        TreeNode q = new TreeNode(4);
        System.out.println(new T236().lowestCommonAncestor_ok(root, p, q));
        System.out.println(new T236().lowestCommonAncestor(root, p, q));
    }
}
