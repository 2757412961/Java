package edu.zju.zjh.lcold;

public class T238 {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] outputs = new int[n];
        int left = 1, righ = 1;

        for (int i = n - 1; i >= 0; i--) {
            outputs[i] = righ;
            righ *= nums[i];
        }

        for (int i = 0; i < n; i++) {
            outputs[i] *= left;
            left *= nums[i];
        }

        return outputs;
    }

    public static void main(String[] args) {
//        输入: [1,2,3,4]
//        输出: [24,12,8,6]

        int[] nums = new int[]{1, 2, 3, 4};
        new T238().productExceptSelf(nums);
    }
}
