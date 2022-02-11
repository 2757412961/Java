package main.java.edu.zju.zjh.lcold;

import java.util.ArrayList;

/**
 * @author : Z
 * @description : TODO
 * @date : 2020/8/8 下午 02:49
 * @Modified_By :
 */
public class T099 {
    ArrayList<TreeNode> trees = new ArrayList<>();

    public void swap(TreeNode a, TreeNode b) {
        int temp = a.val;
        a.val = b.val;
        b.val = temp;
    }

    public void inord(TreeNode root) {
        if (root == null) return;

        inord(root.left);
        trees.add(root);
        inord(root.right);
    }

    public void recoverTree(TreeNode root) {
        inord(root);

        int l = 0, n = trees.size(), r = n - 1;

        while (l < r) {
            if (trees.get(l).val >= trees.get(l + 1).val) {
                break;
            }
            l++;
        }

        while (l < r) {
            if (trees.get(r).val <= trees.get(r - 1).val) {
                break;
            }
            r--;
        }

        swap(trees.get(l), trees.get(r));
    }

    public static void main(String[] args) {

//        二叉搜索树中的两个节点被错误地交换。//
//        请在不改变其结构的情况下，恢复这棵树。
//
//        示例 1:
//        输入: [1,3,null,null,2]
//
//                 1
//                /
//                3
//                 \
//                  2
//
//        输出: [3,1,null,null,2]
//
//                 3
//                /
//                1
//                 \
//                  2
//        示例 2:
//        输入: [3,1,4,null,null,2]
//
//                 3
//                / \
//               1   4
//                  /
//                 2
//
//        输出: [2,1,4,null,null,3]
//
//                 2
//                / \
//               1   4
//                  /
//                 3


//        String inputs = "[1,3,null,null,2]";
        String inputs = "[3,1,4,null,null,2]";

        TreeNode root = new CodeTree().deserialize(inputs);
        System.out.println(new CodeTree().serialize(root));

        new T099().recoverTree(root);
        System.out.println(new CodeTree().serialize(root));
    }
}
