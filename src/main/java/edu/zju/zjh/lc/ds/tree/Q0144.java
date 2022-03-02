package edu.zju.zjh.lc.ds.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: zjh
 * @date : 2022/3/2 20:44
 * @Email : 2757412961@qq.com
 * @update:
 */

public class Q0144 {

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

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) return list;

        list.add(root.val);
        List<Integer> leftList = preorderTraversal(root.left);
        list.addAll(leftList);
        List<Integer> rightList = preorderTraversal(root.right);
        list.addAll(rightList);

        return list;
    }

}
