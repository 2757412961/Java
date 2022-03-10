package edu.zju.zjh.lc.ds.tree;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: zjh
 * @date : 2022/3/10 17:27
 * @Email : 2757412961@qq.com
 * @update:
 */

public class Q0106 {

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

    public TreeNode build(int[] inorder, int lefti, int righti,
                          int[] postorder, int leftp, int rightp) {
        if (lefti > righti) return null;
        int rootVal = postorder[rightp];
        int split = map.get(rootVal);
        int lenRight = righti - split;
        TreeNode root = new TreeNode(rootVal);
        root.left = build(inorder, lefti, split - 1, postorder, leftp, rightp - lenRight - 1);
        root.right = build(inorder, split + 1, righti, postorder, rightp - lenRight, rightp - 1);

        return root;
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        return build(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }

}
