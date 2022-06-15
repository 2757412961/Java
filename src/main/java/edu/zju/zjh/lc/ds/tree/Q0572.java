package edu.zju.zjh.lc.ds.tree;

/**
 * @author: zjh
 * @date : 2022/6/15 15:37
 * @Email : 2757412961@qq.com
 * @update:
 */

public class Q0572 {

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
     * 序列化
     * 执行耗时:3 ms,击败了70.63% 的Java用户
     * 内存消耗:41.6 MB,击败了18.74% 的Java用户
     */
    private class S1 {

        public StringBuilder serialize(TreeNode root, StringBuilder sb) {
            if (root == null) {
                sb.append('N');
                return sb;
            }

            sb.append('(');
            sb.append(root.val);
            sb.append(',');
            serialize(root.left, sb);
            sb.append(',');
            serialize(root.right, sb);
            sb.append(')');

            return sb;
        }

        public boolean isSubtree(TreeNode root, TreeNode subRoot) {
            String sroot = serialize(root, new StringBuilder(100)).toString();
            String ssubroot = serialize(subRoot, new StringBuilder(100)).toString();

            return sroot.contains(ssubroot);
        }

    }

}
