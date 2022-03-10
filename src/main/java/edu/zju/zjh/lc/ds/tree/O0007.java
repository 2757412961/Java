package edu.zju.zjh.lc.ds.tree;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: zjh
 * @date : 2022/3/10 14:17
 * @Email : 2757412961@qq.com
 * @update:
 */

public class O0007 {

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
     * 第一次：递归 + 循环
     */
    public TreeNode buildTree(int[] preorder, int leftp, int rightp,
                              int[] inorder, int lefti, int righti) {
        if (lefti > righti) return null;
        int treeVal = preorder[leftp];

        int split = lefti;
        for (; split <= righti; split++) {
            if (treeVal == inorder[split]) {
                break;
            }
        }

        int lenLeft = split - lefti;
        int lenRight = righti - split;
        TreeNode root = new TreeNode(treeVal);
        root.left = buildTree(preorder, leftp + 1, leftp + lenLeft, inorder, lefti, split - 1);
        root.right = buildTree(preorder, leftp + lenLeft + 1, rightp, inorder, split + 1, righti);

        return root;
    }

    /**
     * 优化：递归 + 哈希表
     */
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
