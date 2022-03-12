package edu.zju.zjh.lc.ds.tree;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: zjh
 * @date : 2022/3/10 21:57
 * @Email : 2757412961@qq.com
 * @update:
 */

public class Q0889 {

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

    public TreeNode construct(int[] preorder, int preStart, int preEnd,
                              int[] postorder, int postStart, int postEnd) {
        if (preStart > preEnd) return null;
        if (preStart == preEnd) return new TreeNode(preorder[preStart]);
        int rootVal = preorder[preStart];
        int rightVal = postorder[postEnd - 1];
        int preRightIdx = map.get(rightVal);
        int lenRight = preEnd - preRightIdx + 1;
        int lenLeft = preRightIdx - preStart - 1;

        TreeNode root = new TreeNode(rootVal);
        root.left = construct(preorder, preStart + 1, preStart + lenLeft, postorder, postStart, postStart + lenLeft - 1);
        root.right = construct(preorder, preEnd - lenRight + 1, preEnd, postorder, postEnd - lenRight, postEnd - 1);

        return root;
    }

    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        for (int i = 0; i < preorder.length; i++) {
            map.put(preorder[i], i);
        }

        return construct(preorder, 0, preorder.length - 1, postorder, 0, postorder.length - 1);
    }

}
