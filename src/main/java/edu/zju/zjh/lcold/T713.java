package main.java.edu.zju.zjh.lcold;

public class T713 {
    public int numSubarrayProductLessThanK_violence(int[] nums, int k) {
        int res = 0;
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            int prd = 1;
            for (int j = i; j < n; j++) {
                prd *= nums[j];
                if (prd >= k) {
                    break;
                }
                res++;
            }
        }

        return res;
    }

    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int res = 0;
        if (k <= 1) return res;

        int n = nums.length;
        int i = 0, j = 0;
        int prd = 1;

        for (; j < n; j++) {
            prd *= nums[j];
            while (prd >= k) {
                prd /= nums[i++];
            }

            res += j - i + 1;
        }


        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{10, 9, 10, 4, 3, 8, 3, 3, 6, 2, 10, 10, 9, 3};
        int k = 19;

        System.out.println(new T713().numSubarrayProductLessThanK(nums, k));
        System.out.println(new T713().numSubarrayProductLessThanK_violence(nums, k));
    }
}
