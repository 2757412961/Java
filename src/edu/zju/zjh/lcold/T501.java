package edu.zju.zjh.lcold;

import java.util.ArrayList;
import java.util.Arrays;

public class T501 {
    ArrayList<Integer> res = new ArrayList<>();
    int maxCount = 0, count = 0, num = Integer.MIN_VALUE;

    public void dfs(TreeNode root) {
        if (root == null) return;

        dfs(root.left);

        if (root.val == num) {
            count += 1;
        } else {
            count = 1;
            num = root.val;
        }

        if (count > maxCount) {
            maxCount = count;
            res.clear();
            res.add(num);
        } else if (count == maxCount) {
            res.add(num);
        }

        dfs(root.right);
    }

    public int[] findMode(TreeNode root) {
        dfs(root);

        return res.stream().mapToInt(Integer::valueOf).toArray();
    }

    public static void main(String[] args) {
//        给定一个有相同值的二叉搜索树（BST），找出 BST 中的所有众数（出现频率最高的元素）。
//        假定 BST 有如下定义：
//
//        结点左子树中所含结点的值小于等于当前结点的值
//                结点右子树中所含结点的值大于等于当前结点的值
//        左子树和右子树都是二叉搜索树
//        例如：
//        给定 BST [1,null,2,2],
//
//         1
//          \
//           2
//           /
//          2
//        返回[2].

        String inputs = "[1,null,2,2]";

        TreeNode root = new CodeTree().deserialize(inputs);
        System.out.println(Arrays.toString(
                new T501().findMode(root)
        ));
    }
}
