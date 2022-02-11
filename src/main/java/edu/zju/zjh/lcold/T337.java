package main.java.edu.zju.zjh.lcold;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : Z
 * @description : TODO
 * @date : 2020/8/5 上午 10:24
 * @Modified_By :
 */
public class T337 {

    public int rob_vio(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int gfather = root.val;
        if (root.left != null) {
            gfather += rob_vio(root.left.left) + rob_vio(root.left.right);
        }
        if (root.right != null) {
            gfather += rob_vio(root.right.left) + rob_vio(root.right.right);
        }

        return Math.max(gfather, rob_vio(root.left) + rob_vio(root.right));
    }

    Map<TreeNode, Integer> to = new HashMap<>();
    Map<TreeNode, Integer> no = new HashMap<>();

    public int robber(TreeNode root) {
        if (root == null) {
            return 0;
        }

        if (!to.containsKey(root)) {
            to.put(root, 0);
        }
        if (!no.containsKey(root)) {
            no.put(root, 0);
        }

        TreeNode left = root.left;
        TreeNode righ = root.right;
        robber(left);
        robber(righ);

        to.put(root, root.val + no.get(left) + no.get(righ));
        no.put(root, Math.max(to.get(left), no.get(left)) + Math.max(to.get(righ), no.get(righ)));

        return 0;
//        return Math.max(to.get(root), no.get(righ));
    }

    public int rob(TreeNode root) {
        if (root == null) {
            return 0;
        }

        to.put(null, 0);
        no.put(null, 0);
        robber(root);

        return Math.max(to.get(root), no.get(root));
    }

    public static void main(String[] args) {
//        在上次打劫完一条街道之后和一圈房屋后，小偷又发现了一个新的可行窃的地区。这个地区只有一个入口，我们称之为“根”。
//        除了“根”之外，每栋房子有且只有一个“父“房子与之相连。一番侦察之后，聪明的小偷意识到“这个地方的所有房屋的排列类似于一棵二叉树”。
//        如果两个直接相连的房子在同一天晚上被打劫，房屋将自动报警。
//
//        计算在不触动警报的情况下，小偷一晚能够盗取的最高金额。

//        示例 1:
//        输入: [3,2,3,null,3,null,1]
//
//                 3
//                / \
//               2   3
//                \   \
//                 3   1
//
//        输出: 7
//        解释: 小偷一晚能够盗取的最高金额 = 3 + 3 + 1 = 7.

//        示例 2:
//        输入: [3,4,5,1,3,null,1]
//
//                 3
//                / \
//               4   5
//              / \   \
//             1   3   1
//
//        输出: 9
//        解释: 小偷一晚能够盗取的最高金额 = 4 + 5 = 9.

//        String inputs = "[3,2,3,null,3,null,1]";
        String inputs = "[3,4,5,1,3,null,1]";

        TreeNode root = new CodeTree().deserialize(inputs);
        System.out.println(new CodeTree().serialize(root));

        System.out.println(new T337().rob(root));
        System.out.println(new T337().rob_vio(root));
    }
}
