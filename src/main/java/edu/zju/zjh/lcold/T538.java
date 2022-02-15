package edu.zju.zjh.lcold;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class T538 {
    ArrayList<Integer> nums = new ArrayList<>();

    public void putNums(TreeNode root) {
        if (root == null) return;
        nums.add(root.val);

        putNums(root.left);
        putNums(root.right);
    }

    public void convert(TreeNode root, Map<Integer, Integer> map) {
        if (root == null) return;

        root.val = map.get(root.val);

        convert(root.left, map);
        convert(root.right, map);
    }

    public TreeNode convertBST(TreeNode root) {
        int sum = 0;
        Map<Integer, Integer> map = new HashMap<>();

        putNums(root);
        nums.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        for (int i = 0; i < nums.size(); i++) {
            int num = nums.get(i);
            sum += num;
            map.put(num, sum);
        }

        convert(root, map);
        return root;
    }

    public static void main(String[] args) {
//        给出二叉 搜索 树的根节点，该树的节点值各不相同，请你将其转换为累加树（Greater Sum Tree），
//        使每个节点 node 的新值等于原树中大于或等于 node.val 的值之和。
//
//        提醒一下，二叉搜索树满足下列约束条件：
//            节点的左子树仅包含键 小于 节点键的节点。
//            节点的右子树仅包含键 大于 节点键的节点。
//            左右子树也必须是二叉搜索树。


        String inputs = "[4,1,6,0,2,5,7,null,null,null,3,null,null,null,8]";
        TreeNode root = new CodeTree().deserialize(inputs);

        new T538().convertBST(root).printTree();
    }
}
