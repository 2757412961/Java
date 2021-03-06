package edu.zju.zjh.lcold;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author : Z
 * @description : TODO
 * @date : 2020/8/6 下午 02:32
 * @Modified_By :
 */
public class T437 {
    Map<TreeNode, Set<TreeNode>> map = new HashMap();

    public void ps(TreeNode root, TreeNode origin, int s, int sum) {
        if (root == null) return;

        if (s + root.val == sum) {
            if (!map.containsKey(origin)) map.put(origin, new HashSet<>());
            map.get(origin).add(root);
        }

        ps(root.left, root, 0, sum);
        ps(root.right, root, 0, sum);
        ps(root.left, origin, s + root.val, sum);
        ps(root.right, origin, s + root.val, sum);
    }

    public int pathSum_violence(TreeNode root, int sum) {
        if (root == null) return 0;

        ps(root, null, 0, sum);

        int res = 0;
        for (Set<TreeNode> set : map.values()) {
            res += set.size();
        }

        return res;
    }

    public int getRes(TreeNode root, int sum) {
        if (root == null) return 0;

        int ress = sum - root.val;
        int con = ress == 0 ? 1 : 0;

        return con + getRes(root.left, ress) + getRes(root.right, ress);
    }

    public int pathSum(TreeNode root, int sum) {
        if (root == null) return 0;

        return getRes(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
    }

    public static void main(String[] args) {
//        给定一个二叉树，它的每个结点都存放着一个整数值。
//        找出路径和等于给定数值的路径总数。
//        路径不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。
//
//        二叉树不超过1000个节点，且节点数值范围是 [-1000000,1000000] 的整数。
//
//        示例：
//        root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8
//
//                 10
//                /  \
//               5   -3
//              / \    \
//             3   2   11
//                / \   \
//               3  -2   1
//
//        返回 3。和等于 8 的路径有:
//
//        1.  5 -> 3
//        2.  5 -> 2 -> 1
//        3.  -3 -> 11

//        int sum = 8;
//        String inputs = "[10,5,-3,3,2,null,11,3,-2,null,1]"; //  3
//        int sum = 3;
//        String inputs = "[1,null,2,null,3,null,4,null,5]"; // 2
//        int sum = -2;
//        String inputs = "[-8,6,8,null,null,8,2,null,null,null,-2]"; // 2
        int sum = 1;
        String inputs = "[0,1,1]"; // 4

        TreeNode root = new CodeTree().deserialize(inputs);
        System.out.println(new CodeTree().serialize(root));

        System.out.println(new T437().pathSum(root, sum));
        System.out.println(new T437().pathSum_violence(root, sum));
    }
}
