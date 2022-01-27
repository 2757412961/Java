package edu.zju.zjh.lcold;

import java.util.HashMap;
import java.util.Map;

public class T106 {

    public TreeNode build(int[] inorder, int sta, int end, Map<Integer, Integer> map) {
        if (sta > end) return null;

        int pos = -1, maxIndex = -1;
        for (int i = sta; i <= end; i++) {
            int index = map.get(inorder[i]);
            if (index > maxIndex) {
                pos = i;
                maxIndex = index;
            }
        }

        TreeNode root = new TreeNode(inorder[pos]);
        root.left = build(inorder, sta, pos - 1, map);
        root.right = build(inorder, pos + 1, end, map);

        return root;
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < postorder.length; i++) {
            map.put(postorder[i], i);
        }

        return build(inorder, 0, inorder.length - 1, map);
    }

    public static void main(String[] args) {
//        根据一棵树的中序遍历与后序遍历构造二叉树。
//        注意:
//        你可以假设树中没有重复的元素。
//
//        例如，给出
//            中序遍历 inorder = [9,3,15,20,7]
//            后序遍历 postorder = [9,15,7,20,3]
//        返回如下的二叉树：
//
//                 3
//                / \
//               9  20
//                 /  \
//                15   7

        int[] inorder = new int[]{9, 3, 15, 20, 7};
        int[] postorder = new int[]{9, 15, 7, 20, 3};

        new T106().buildTree(inorder, postorder).printTree();
    }
}
