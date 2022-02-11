package main.java.edu.zju.zjh.lcold;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class T101 {
    public ArrayList<Integer> ino = new ArrayList();

    public boolean isMirror(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return true;
        } else if (root1 != null && root2 != null && root1.val == root2.val) {

            boolean lr = isMirror(root1.left, root2.right);
            boolean rl = isMirror(root1.right, root2.left);
            return lr && rl;
        } else {
            return false;
        }
    }

    public boolean isSymmetric_old(TreeNode root) {
        return isMirror(root, root);
    }


    public boolean isSymmetric(TreeNode root) {
        Queue<TreeNode> mir1 = new LinkedList<>();
        Queue<TreeNode> mir2 = new LinkedList<>();

        mir1.add(root);
        mir2.add(root);

        while (!mir1.isEmpty() || !mir2.isEmpty()) {
            TreeNode node1 = mir1.poll();
            TreeNode node2 = mir2.poll();

            if (node1 == null && node2 == null) {
                continue;
            } else if (node1 != null && node2 != null) {
                if (node1.val != node2.val) return false;
            } else {
                return false;
            }


            mir1.add(node1.left);
            mir1.add(node1.right);

            mir2.add(node2.right);
            mir2.add(node2.left);
        }

        return true;
    }


    public static void main(String[] args) {
        String inputs = "[1,2,2,3,4,4,3]";
        String[] stringNodes = inputs.substring(1, inputs.length() - 1).split(",");

        TreeNode root = new TreeNode(-1);
        root = root.buildTree(stringNodes);
        root.printTree();

        // Start
        T101 t101 = new T101();
        System.out.println(t101.isSymmetric(root));
        System.out.println(t101.isSymmetric_old(root));
    }
}
