package edu.zju.zjh.lc.ds.tree;

/**
 * @author: zjh
 * @date : 2022/6/14 19:09
 * @Email : 2757412961@qq.com
 * @update:
 */

public class Q0450 {

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
     * 方法一：递归
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:41.5 MB,击败了76.87% 的Java用户
     */
    private class S1 {

        public TreeNode getMin(TreeNode root) {
            if (root == null) return null;
            if (root.left == null) return root;

            return getMin(root.left);
        }

        public TreeNode deleteNode(TreeNode root, int key) {
            if (root == null) return null;

            if (root.val == key) {
                // Delete
                if (root.left == null && root.right == null) {
                    root = null;
                } else if (root.left != null && root.right == null) {
                    root = root.left;
                } else if (root.left == null && root.right != null) {
                    root = root.right;
                } else if (root.left != null && root.right != null) {
                    TreeNode min = getMin(root.right);
                    TreeNode right = deleteNode(root.right, min.val);
                    min.left = root.left;
                    min.right = right;
                    root = min;
                }
            } else if (root.val < key) {
                root.right = deleteNode(root.right, key);
            } else if (root.val > key) {
                root.left = deleteNode(root.left, key);
            }

            return root;
        }

    }

    /**
     * 二刷：递归
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:41.6 MB,击败了66.07% 的Java用户
     */
    private class S2 {

        public TreeNode getMax(TreeNode root) {
            while (root.right != null) {
                root = root.right;
            }
            return root;
        }

        public TreeNode deleteNode(TreeNode root, int key) {
            if (root == null) {
                return null;
            }

            if (root.val == key) {
                if (root.left == null && root.right == null) {
                    return null;
                } else if (root.left != null && root.right == null) {
                    return root.left;
                } else if (root.left == null && root.right != null) {
                    return root.right;
                } else if (root.left != null && root.right != null) {
                    TreeNode leftMax = getMax(root.left);
                    TreeNode node = new TreeNode(leftMax.val);
                    node.left = deleteNode(root.left, leftMax.val);
                    node.right = root.right;
                    return node;
                }
            } else if (root.val < key) {
                root.right = deleteNode(root.right, key);
            } else if (root.val > key) {
                root.left = deleteNode(root.left, key);
            }

            return root;
        }

    }

}
