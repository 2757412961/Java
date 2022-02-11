package main.java.edu.zju.zjh.lcold;

import java.util.Arrays;

public class T105 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length <= 0 || inorder.length <= 0) {
            return null;
        }

        int n = preorder.length;
        TreeNode root = new TreeNode(preorder[0]);

        int inIndex = 0;
        for (; inIndex < n; inIndex++) {
            if (inorder[inIndex] == preorder[0]) {
                break;
            }
        }

        int[] left_in = Arrays.copyOfRange(inorder, 0, inIndex);
        int[] righ_in = Arrays.copyOfRange(inorder, inIndex + 1, n);

        int[] left_pre = Arrays.copyOfRange(preorder, 1, inIndex + 1);
        int[] righ_pre = Arrays.copyOfRange(preorder, inIndex + 1, n);

        root.left = buildTree(left_pre, left_in);
        root.right = buildTree(righ_pre, righ_in);

        return root;
    }


    public static void main(String[] args) {
        int[] preorder = new int[]{3, 9, 20, 15, 7};
        int[] inorder = new int[]{9, 3, 15, 20, 7};

        TreeNode root = new T105().buildTree(preorder, inorder);
        System.out.println();
    }
}
