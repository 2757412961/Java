package edu.zju.zjh.offer;

/**
 * @author: zjh
 * @date : 2022/3/16 15:20
 * @Email : 2757412961@qq.com
 * @update:
 */

public class O0026 {

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

    private class S1 {

        private boolean isSameTree(TreeNode A, TreeNode B) {
            if (B == null) return true;
            if (A == null) return false;
            if (A.val != B.val) return false;

            return isSameTree(A.left, B.left) && isSameTree(A.right, B.right);
        }

        public boolean isSubStructure(TreeNode A, TreeNode B) {
            if (A == null || B == null) return false;
            if (isSameTree(A, B)) return true;

            return isSubStructure(A.left, B) || isSubStructure(A.right, B);
        }

    }

    /**
     * 二刷
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:44 MB,击败了5.36% 的Java用户
     */
    private class S2 {

        public boolean isSame(TreeNode A, TreeNode B) {
            if (B == null) return true;
            if (A == null) return false;
            if (A.val != B.val) return false;

            return isSame(A.left, B.left) && isSame(A.right, B.right);
        }

        public boolean isSubStructure(TreeNode A, TreeNode B) {
            if (B == null) return false;
            if (A == null) return false;

            return isSame(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B);
        }

    }

}
