package edu.zju.zjh.lc.ds.tree;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: zjh
 * @date : 2022/3/10 17:23
 * @Email : 2757412961@qq.com
 * @update:
 */

public class Q0105 {

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

    private Map<Integer, Integer> map = new HashMap<>();

    public TreeNode build(int[] preorder, int leftp, int rightp,
                          int[] inorder, int lefti, int righti) {
        if (lefti > righti) return null;
        int rootVal = preorder[leftp];

        int split = map.get(rootVal);

        int lenLeft = split - lefti;
        TreeNode root = new TreeNode(rootVal);
        root.left = build(preorder, leftp + 1, leftp + lenLeft, inorder, lefti, split - 1);
        root.right = build(preorder, leftp + lenLeft + 1, rightp, inorder, split + 1, righti);

        return root;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        return build(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

}
