package edu.zju.zjh.lcold;

import java.util.*;

public class T103 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> que = new LinkedList<>();
        Boolean seqence = true;

        if (root != null) que.add(root);

        while (!que.isEmpty()) {
            int n = que.size();
            List<Integer> row = new ArrayList<Integer>();

            for (int i = 0; i < n; i++) {
                TreeNode node = que.poll();
                row.add(node.val);

                if (node.left != null) {
                    que.add(node.left);
                }

                if (node.right != null) {
                    que.add(node.right);
                }
            }

            if (!seqence){
                Collections.reverse(row);
            }

            seqence = !seqence;
            res.add(row);
        }

        return res;
    }

    public static void main(String[] args) {
        String inputs = "[3,9,20,null,null,15,7]";
        String[] stringNodes = inputs.substring(1, inputs.length() - 1).split(",");

        TreeNode root = new TreeNode(-1);
        root = root.buildTree(stringNodes);
        root.printTree();

        new T103().zigzagLevelOrder(root);
    }
}
