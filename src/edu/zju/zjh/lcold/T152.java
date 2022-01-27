package edu.zju.zjh.lcold;

public class T152 {
    public int maxProduct_old(int[] nums) {
        int res = nums[0];
        int[] dpMin = new int[nums.length];
        int[] dpMax = new int[nums.length];
        dpMin[0] = nums[0];
        dpMax[0] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            dpMax[i] = Math.max(Math.max(nums[i], nums[i] * dpMax[i - 1]),
                    nums[i] * dpMin[i - 1]);
            dpMin[i] = Math.min(Math.min(nums[i], nums[i] * dpMin[i - 1]),
                    nums[i] * dpMax[i - 1]);

            res = Math.max(res, dpMax[i]);
            res = Math.max(res, dpMin[i]);
        }

        return res;
    }

    public int maxProduct(int[] nums) {
        int res = Integer.MIN_VALUE;
        int n = nums.length;

        int prd = 1;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                prd = 1;
                res = Math.max(res, 0);
            } else {
                prd *= nums[i];
                res = Math.max(res, prd);
            }
        }

        prd = 1;
        for (int i = n - 1; i >= 0; i--) {
            if (nums[i] == 0) {
                prd = 1;
                res = Math.max(res, 0);
            } else {
                prd *= nums[i];
                res = Math.max(res, prd);
            }
        }

        return res;
    }

    public static void main(String[] args) {
//        int[] nums = new int[]{-2, 3, -4};
//        int[] nums = new int[]{2, 3, -2, 4};
        int[] nums = new int[]{-3, 0, 1, 0, 2, -2};

        System.out.println(new T152().maxProduct(nums));
        System.out.println(new T152().maxProduct_old(nums));
    }
}
