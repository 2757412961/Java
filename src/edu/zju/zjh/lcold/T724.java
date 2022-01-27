package edu.zju.zjh.lcold;

public class T724 {
    public int pivotIndex(int[] nums) {
        if (nums.length == 0) return -1;
        int n = nums.length;
        int[] sum = new int[n + 1];

        for (int i = 0; i < n; i++) {
            sum[i + 1] = sum[i] + nums[i];
        }

        for (int i = 0; i < n; i++) {
            if (sum[i] == sum[n] - sum[i + 1]) {
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 7, 3, 6, 5, 6};

        System.out.println(new T724().pivotIndex(nums));
    }
}
