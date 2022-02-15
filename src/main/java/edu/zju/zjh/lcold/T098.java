package edu.zju.zjh.lcold;

public class T098 {
    boolean res = true;

    public void dfs(TreeNode node, Long min, Long max) {
        if (!res || node == null) {
            return;
        }

        if (node.val <= min || node.val >= max) {
            res = false;
        }

        if (node.left != null) {
            if (node.left.val < node.val) {
                dfs(node.left, min, Math.min(node.val, max));
            } else {
                res = false;
            }
        }

        if (node.right != null) {
            if (node.right.val > node.val) {
                dfs(node.right, Math.max(node.val, min), max);
            } else {
                res = false;
            }
        }

    }


    public boolean isValidBST(TreeNode root) {
        dfs(root, Long.MIN_VALUE, Long.MAX_VALUE);

        return res;
    }

    public static void main(String[] args) {
        String inputs = "[2,1,3]";
        String[] stringNodes = inputs.substring(1, inputs.length() - 1).split(",");

        TreeNode root = new TreeNode(-1);
        root = root.buildTree(stringNodes);
        root.printTree();

        System.out.println(new T098().isValidBST(root));
    }
}
