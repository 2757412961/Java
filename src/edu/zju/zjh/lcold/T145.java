package edu.zju.zjh.lcold;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class T145 {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode last = null;

        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }

            root = stack.pop();
            if (root.right == null || root.right == last) {
                res.add(root.val);
                last = root;
                root = null;
            } else if (root.right != null) {
                stack.push(root);
                root = root.right;
            }
        }

        return res;
    }

    public static void main(String[] args) {
//        给定一个二叉树，返回它的 后序 遍历。
//
//        示例:
//        输入: [1,null,2,3]
//             1
//              \
//               2
//               /
//              3
//
//        输出: [3,2,1]
//        进阶: 递归算法很简单，你可以通过迭代算法完成吗？

//        String inputs = "[1,null,2,3]";
        String inputs = "[1,2,3,4,5,6,7]";
        TreeNode root = new CodeTree().deserialize(inputs);

        System.out.println(new T145().postorderTraversal(root));
    }
}
