package main.java.edu.zju.zjh.lcold;

import java.util.ArrayList;
import java.util.List;

public class T113 {
    List<List<Integer>> res = new ArrayList<>();

    public void dfs(TreeNode root, int sum, ArrayList<Integer> path) {
        if (root == null) return;
        int rSum = sum - root.val;

        path.add(root.val);
        if (root.left == null && root.right == null && rSum == 0) {
            res.add(new ArrayList<>(path));
        }
        dfs(root.left, rSum, path);
        dfs(root.right, rSum, path);
        path.remove(path.size() - 1);
    }

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        dfs(root, sum, new ArrayList<>());
        return res;
    }

    public static void main(String[] args) {
//        给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。
//        说明: 叶子节点是指没有子节点的节点。

        int sum = 22;
        String inputs = "[5,4,8,11,null,13,4,7,2,null,null,5,1]";
        TreeNode root = new CodeTree().deserialize(inputs);

        List<List<Integer>> res = new T113().pathSum(root, sum);
        for (int i = 0; i < res.size(); i++) {
            System.out.println(res.get(i));
        }
    }
}
