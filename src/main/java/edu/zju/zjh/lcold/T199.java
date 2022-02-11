package main.java.edu.zju.zjh.lcold;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class T199 {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Queue<TreeNode> que = new LinkedList<>();
        Queue<Integer> dep = new LinkedList<>();

        que.add(root);
        dep.add(0);
        while (!que.isEmpty()) {
            TreeNode node = que.poll();
            int depth = dep.poll();

            if (node == null) {
                continue;
            }

            if (res.size() <= depth){
                res.add(-1);
            }
            res.set(depth, node.val);
            que.add(node.left);
            dep.add(depth + 1);
            que.add(node.right);
            dep.add(depth + 1);
        }

        return res;
    }

    public static void main(String[] args) {
        String inputs = "[1,2,3,null,5,null,4]";
        String[] stringNodes = inputs.substring(1, inputs.length() - 1).split(",");
//        String[] stringNodes = TreeInput.Inputs();

        TreeNode root = new TreeNode(-1);
        root = root.buildTree(stringNodes);
        root.printTree();

        T199 t199 = new T199();
        t199.rightSideView(root);
    }
}
