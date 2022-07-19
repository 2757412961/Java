package edu.zju.zjh.lc.array.nsum;

import java.util.HashSet;
import java.util.Set;

/**
 * @author: zjh
 * @date : 2022/7/19 16:32
 * @Email : 2757412961@qq.com
 * @update:
 */

public class Q0653 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    /**
     * 方法一：深度优先搜索 + 哈希表
     * 执行耗时:2 ms,击败了95.08% 的Java用户
     * 内存消耗:41.6 MB,击败了81.96% 的Java用户
     */
    private class S1 {

        Set<Integer> s = new HashSet<>();

        public boolean findTarget(TreeNode root, int k) {
            if (root == null) return false;
            if (s.contains(k - root.val)) return true;
            s.add(root.val);

            return findTarget(root.left, k) || findTarget(root.right, k);
        }

    }
}
