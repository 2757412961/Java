package main.java.edu.zju.zjh.lcold;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class T102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();

        Queue<TreeNode> que = new LinkedList<>();
        if (root != null) que.add(root);

        while (!que.isEmpty()) {
            int n = que.size();
            List<Integer> lev = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                TreeNode node = que.poll();
                lev.add(node.val);
                if (node.left != null) {
                    que.add(node.left);
                }
                if (node.right != null) {
                    que.add(node.right);
                }
            }
            res.add(lev);
        }


        return res;
    }

    public static void main(String[] args) {
        String inputs = "[3,9,20,null,null,15,7]";
        String[] stringNodes = inputs.substring(1, inputs.length() - 1).split(",");

        TreeNode root = new TreeNode(-1);
        root = root.buildTree(stringNodes);
        root.printTree();

        new T102().levelOrder(root);
    }
}
