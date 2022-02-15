package edu.zju.zjh.lcold;

import java.util.Stack;

/**
 * @author : Z
 * @description : TODO
 * @date : 2020/8/2 下午 10:18
 * @Modified_By :
 */
public class T104 {
    public int maxDepth(TreeNode root) {
        int maxDepth = 0;
        Stack<TreeNode> nodes = new Stack();
        Stack<Integer> depths = new Stack();

        if (root != null) {
            nodes.push(root);
            depths.push(1);
        }

        while (!nodes.isEmpty()) {
            TreeNode node = nodes.pop();
            Integer depth = depths.pop();

            if (node.left != null) {
                nodes.push(node.left);
                depths.push(depth + 1);
            }
            if (node.right != null) {
                nodes.push(node.right);
                depths.push(depth + 1);
            }

            if (depth > maxDepth) maxDepth = depth;
        }

        return maxDepth;
    }

    public static void main(String[] args) {
//        给定一个二叉树，找出其最大深度。
//
//        二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
//        说明: 叶子节点是指没有子节点的节点。
//
//        示例：
//        给定二叉树 [3,9,20,null,null,15,7]，
//
//                 3
//                / \
//               9  20
//                 /  \
//                15   7
//        返回它的最大深度 3 。

        String inputs = "[3,9,20,null,null,15,7]";
        TreeNode root = new CodeTree().deserialize(inputs);
        System.out.println(new CodeTree().serialize(root));

        System.out.println(new T104().maxDepth(root));
    }
}
