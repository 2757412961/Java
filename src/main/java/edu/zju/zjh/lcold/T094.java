package edu.zju.zjh.lcold;

import java.util.*;

public class T094 {
    public void dfs(TreeNode root, List<Integer> res) {
        if (root == null) return;

        dfs(root.left, res);
        res.add(root.val);
        dfs(root.right, res);
    }

    public List<Integer> inorderTraversal_dfs(TreeNode root) {
        List<Integer> res = new ArrayList<>();

        dfs(root, res);
        return res;
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        Map<TreeNode, Boolean> map = new HashMap<>();

        TreeNode node = root;
        if (root != null) stack.add(root);
        while (!stack.isEmpty()) {
            while (node.left != null && map.getOrDefault(node, true)) {
                stack.push(node.left);
                node = node.left;
            }

            node = stack.pop();
            map.put(node, false);
            res.add(node.val);

            if (node.right != null) {
                stack.push(node.right);
                node = node.right;
            }
        }

        return res;
    }

    public static void main(String[] args) {
//        给定一个二叉树，返回它的中序 遍历。
//
//        示例:
//        输入: [1,null,2,3]
//                1
//                 \
//                 2
//                /
//                3
//
//        输出: [1,3,2]
//        进阶: 递归算法很简单，你可以通过迭代算法完成吗？

        String inputs = "[1,null,2,3]";
        TreeNode root = new CodeTree().deserialize(inputs);
        System.out.println(new CodeTree().serialize(root));

        System.out.println(new T094().inorderTraversal(root));
        System.out.println(new T094().inorderTraversal_dfs(root));
    }
}
