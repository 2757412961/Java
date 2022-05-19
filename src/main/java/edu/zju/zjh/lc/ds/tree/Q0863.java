package edu.zju.zjh.lc.ds.tree;

import java.util.LinkedList;
import java.util.List;

/**
 * @author: zjh
 * @date : 2022/5/19 13:40
 * @Email : 2757412961@qq.com
 * @update:
 */

public class Q0863 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * lemon: https://leetcode.cn/problems/all-nodes-distance-k-in-binary-tree/solution/99shi-jian-wen-ti-fen-jie-xun-zhao-rootz-no2h/
     * 执行耗时:9 ms,击败了99.24% 的Java用户
     * 内存消耗:40.8 MB,击败了99.12% 的Java用户
     */
    private final int MAX_DIS = 10000;
    private List<Integer> res = new LinkedList<>();

    public void find(TreeNode target, int k) {
        if (target == null || k < 0) return;
        if (k == 0) {
            res.add(target.val);
            return;
        }

        find(target.left, k - 1);
        find(target.right, k - 1);
    }

    public int disK(TreeNode root, TreeNode target, int k) {
        if (root == null) return MAX_DIS;
        if (root == target) return 1;

        int disl = disK(root.left, target, k);
        int disr = disK(root.right, target, k);
        if (disl < k) {
            // disl小于k，说明符合条件的节点在右侧，find右子树，距离为k - disr - 1。
            find(root.right, k - disl - 1);
        } else if (disr < k) {
            find(root.left, k - disr - 1);
        } else if (disl == k || disr == k) {
            // dis等于k说明该节点到target距离正好为k，find该节点，距离为0。
            find(root, 0);
        }

        // 返回当前节点到target的距离
        return Math.min(disl, disr) + 1;
    }

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        // taget为根
        find(target, k);
        // 以root至target路径节点
        disK(root, target, k);

        return res;
    }

}
