package edu.zju.zjh.lc.ds.tree;

/**
 * @author: zjh
 * @date : 2022/3/10 21:57
 * @Email : 2757412961@qq.com
 * @update:
 */

public class Q0654 {

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
     * 执行耗时:2 ms,击败了77.45% 的Java用户
     * 内存消耗:41.4 MB,击败了54.98% 的Java用户
     */
    public TreeNode constructMaximumBinaryTree(int[] nums, int left, int right) {
        if (left > right) return null;
        if (left == right) return new TreeNode(nums[left]);

        int maxId = left;
        for (int i = left; i <= right; i++) {
            if (nums[i] > nums[maxId]) {
                maxId = i;
            }
        }

        int rootVal = nums[maxId];
        TreeNode root = new TreeNode(rootVal);
        root.left = constructMaximumBinaryTree(nums, left, maxId - 1);
        root.right = constructMaximumBinaryTree(nums, maxId + 1, right);

        return root;
    }

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return constructMaximumBinaryTree(nums, 0, nums.length - 1);
    }

}
