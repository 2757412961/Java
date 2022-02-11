package main.java.edu.zju.zjh.lcold;

import java.util.LinkedList;
import java.util.Queue;

public class T572 {
    public boolean isSame(TreeNode r, TreeNode t) {
        Queue<TreeNode> quT = new LinkedList<>();
        Queue<TreeNode> quR = new LinkedList<>();
        if (t != null) {
            quT.add(t);
            quR.add(r);
        }

        while (!quT.isEmpty()) {
            TreeNode nodeT = quT.poll();
            TreeNode nodeR = quR.poll();

            if (nodeR == null && nodeT == null) {
                continue;
            }

            if (nodeR == null && nodeT != null || nodeR != null && nodeT == null || nodeT.val != nodeR.val) {
                return false;
            }

            quT.add(nodeT.left);
            quT.add(nodeT.right);

            quR.add(nodeR.left);
            quR.add(nodeR.right);
        }

        return true;
    }

    public boolean isSubtree_violence(TreeNode s, TreeNode t) {
        Queue<TreeNode> que = new LinkedList<>();
        que.add(s);

        while (!que.isEmpty()) {
            TreeNode nodeR = que.poll();
            if (nodeR.val == t.val) {
                if (isSame(nodeR, t)) {
                    return true;
                }
            }

            if (nodeR.left != null) que.add(nodeR.left);
            if (nodeR.right != null) que.add(nodeR.right);
        }

        return false;
    }

    public String tree2str(TreeNode node) {
        if (node == null) {
            return "n";
        }

        return " " + String.valueOf(node.val) + " " + tree2str(node.left) + " " + tree2str(node.right) + " ";
    }

    public boolean isSubtree(TreeNode s, TreeNode t) {
        String strS = tree2str(s);
        String strT = tree2str(t);


        return strS.contains(strT);
    }

    public static void main(String[] args) {
        String inputs = "[3,4,5,1,2,null,null,0]";
        String inputt = "[4,1,2]";
        String[] stringNodes = inputs.substring(1, inputs.length() - 1).split(",");
        String[] stringNodet = inputt.substring(1, inputt.length() - 1).split(",");

        TreeNode s = new TreeNode(-1);
        s = s.buildTree(stringNodes);

        TreeNode t = new TreeNode(-1);
        t = t.buildTree(stringNodet);

        System.out.println(new T572().isSubtree(s, t));
        System.out.println(new T572().isSame(s, t));
        System.out.println(new T572().isSubtree_violence(s, t));
    }
}
