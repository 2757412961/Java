package edu.zju.zjh.lc.ds.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author: zjh
 * @date : 2022/5/30 14:00
 * @Email : 2757412961@qq.com
 * @update:
 */

public class Q0958 {

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
     * 方法 1：广度优先搜索
     */

    /**
     * 层寻遍历
     * 执行耗时:1 ms,击败了65.88% 的Java用户
     * 内存消耗:40.7 MB,击败了74.36% 的Java用户
     */
    public boolean isCompleteTree(TreeNode root) {
        if (root == null) return true;
        boolean leftNull = false, allNull = false;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            // 层序遍历基本框架
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                if (node.left == null && node.right == null) {
                    // 节点出现（null，null）后不会再出现其他情况，若出现说明不完全
                    allNull = true;
                } else if (node.left != null && node.right == null) {
                    // 节点出现（null，null）/（left，null）后不会再出现其他情况，若出现说明不完全
                    if (leftNull || allNull) return false;
                    q.offer(node.left);
                    leftNull = true;
                } else if (node.left == null && node.right != null) {
                    // 节点出现（null，right）说明不完全
                    return false;
                } else if (node.left != null && node.right != null) {
                    // 节点出现（null，null）/（left，null）后不会再出现其他情况，若出现说明不完全
                    if (leftNull || allNull) return false;

                    q.offer(node.left);
                    q.offer(node.right);
                }
            }
        }

        return true;
    }

}
