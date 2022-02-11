package main.java.edu.zju.zjh.lcold;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class T637 {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> res = new ArrayList<>();
        Queue<TreeNode> que = new LinkedList<>();
        que.add(root);

        while (!que.isEmpty()) {
            int n = que.size();
            double sum = 0;

            for (int i = 0; i < n; i++) {
                TreeNode node = que.poll();
                sum += node.val;

                if (node.left != null) que.add(node.left);
                if (node.right != null) que.add(node.right);
            }

            res.add(sum / n);
        }

        return res;
    }

    public static void main(String[] args) {
//        给定一个非空二叉树, 返回一个由每层节点平均值组成的数组。
//
//        示例 1：
//        输入：
//                 3
//                / \
//               9  20
//                 /  \
//                15   7
//        输出：[3, 14.5, 11]
//        解释：
//        第 0 层的平均值是 3 ,  第1层是 14.5 , 第2层是 11 。因此返回 [3, 14.5, 11] 。
//
//        提示：
//        节点值的范围在32位有符号整数范围内。

        String inputs = "[3,9,20,15,7]";

        TreeNode root = new CodeTree().deserialize(inputs);
        System.out.println(new CodeTree().serialize(root));

        System.out.println(new T637().averageOfLevels(root));
    }
}
