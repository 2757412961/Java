package edu.zju.zjh.lcold;

/**
 * @author : Z
 * @description : TODO
 * @date : 2020/7/3 下午 10:33
 * @Modified_By :
 */
public class T108 {
    public TreeNode digui(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return null;
        } else if (n == 1) {
            return new TreeNode(nums[0]);
        } else if (n == 2) {
            TreeNode root = new TreeNode(nums[0]);
            root.right = new TreeNode(nums[1]);
            return root;
        }

        int n2 = n / 2;
        int[] left = new int[n2];
        int[] righ = new int[n - n2 - 1];

        for (int i = 0; i < n; i++) {
            if (i < n2) {
                left[i] = nums[i];
            } else if (i > n2) {
                righ[i - n2 - 1] = nums[i];
            }
        }

        TreeNode root = new TreeNode(nums[n / 2]);
        root.left = digui(left);
        root.right = digui(righ);

        return root;
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        TreeNode root = digui(nums);

        return root;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-10, -3, 0, 5, 9};

        new T108().sortedArrayToBST(nums);
    }
}
