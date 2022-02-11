package main.java.edu.zju.zjh.lcold;

public class T701 {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        TreeNode res = root;

        while (root != null) {
            if (root.val > val) {
                if (root.left == null) {
                    TreeNode node = new TreeNode(val);
                    root.left = node;
                    break;
                }
                root = root.left;
            } else if (root.val < val) {
                if (root.right == null) {
                    TreeNode node = new TreeNode(val);
                    root.right = node;
                    break;
                }
                root = root.right;
            }
        }
        if (root == null) {
            TreeNode node = new TreeNode(val);
            return node;
        }

        return res;
    }

    public TreeNode insertIntoBST20201003(TreeNode root, int val) {
        if (root == null) root = new TreeNode(val);
        if (root.val > val) {
            if (root.left == null) {
                root.left = new TreeNode(val);
            } else {
                insertIntoBST20201003(root.left, val);
            }
        }

        if (root.val < val) {
            if (root.right == null) {
                root.right = new TreeNode(val);
            } else {
                insertIntoBST20201003(root.right, val);
            }
        }

        return root;
    }

    public static void main(String[] args) {
        String inputs = "[4,2,7,1,3]";
        TreeNode root = new CodeTree().deserialize(inputs);
        int val = 5;

        new T701().insertIntoBST(root, val).printTree();
        new T701().insertIntoBST20201003(root, val).printTree();
    }
}
