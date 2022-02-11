package main.java.edu.zju.zjh.lcold;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }

    TreeNode buildTree(String[] nodes) {
        if (nodes.length <= 0) {
            return null;
        }

        TreeNode[] treeNodes = new TreeNode[nodes.length];
        for (int i = 0; i < nodes.length; i++) {
            treeNodes[i] = new TreeNode(-1);
            if (nodes[i].compareTo("null") == 0) {
                treeNodes[i] = null;
                continue;
            }
            treeNodes[i].val = Integer.parseInt(nodes[i]);
        }

        for (int i = 0; i < nodes.length; i++) {
            if (treeNodes[i] == null) {
                continue;
            }

            if (2 * i + 1 < nodes.length) {
                treeNodes[i].left = treeNodes[2 * i + 1];
            }

            if (2 * i + 2 < nodes.length) {
                treeNodes[i].right = treeNodes[2 * i + 2];
            }
        }

        return treeNodes[0];
    }

    void preOrderTravel(TreeNode node) {
        System.out.print(node.val + " ");
        if (node.left != null) {
            preOrderTravel(node.left);
        }
        if (node.right != null) {
            preOrderTravel(node.right);
        }
    }

    public void printTree() {
        TreeNode root = this;
        if (root == null) {
            System.out.println("null");
            return;
        }
        preOrderTravel(root);
        System.out.println();
    }
}