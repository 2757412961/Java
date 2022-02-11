package main.java.edu.zju.zjh.lcold;

import java.util.*;

/**
 * @author : Z
 * @description : TODO
 * @date : 2020/9/6 上午 12:32
 * @Modified_By :
 */
public class T107 {

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> nodes = new LinkedList<>();
        Queue<Integer> deps = new LinkedList<>();

        if (root!=null){
            nodes.add(root);
            deps.add(0);
        }

        while (!nodes.isEmpty()) {
            TreeNode node = nodes.poll();
            Integer dep = deps.poll();

            if (res.size() <= dep) res.add(new ArrayList<>());
            res.get(dep).add(node.val);

            if (node.left != null) {
                nodes.add(node.left);
                deps.add(dep + 1);
            }
            if (node.right != null) {
                nodes.add(node.right);
                deps.add(dep + 1);
            }
        }

        Collections.reverse(res);
        return res;
    }

    public static void main(String[] args) {
//        给定一个二叉树，返回其节点值自底向上的层次遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
//
//        例如：
//        给定二叉树 [3,9,20,null,null,15,7],
//
//                 3
//                / \
//               9  20
//                 /  \
//                15   7
//        返回其自底向上的层次遍历为：
//
//        [
//          [15,7],
//          [9,20],
//          [3]
//        ]
        String inputs = "[3,9,20,null,null,15,7]";

        TreeNode root = new CodeTree().deserialize(inputs);
        System.out.println(new CodeTree().serialize(root));

        System.out.println(new T107().levelOrderBottom(root));
    }
}
