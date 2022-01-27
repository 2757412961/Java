package edu.zju.zjh.lcold;

import java.util.Arrays;

public class T001 {
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }

        return null;
    }

    public static void main(String[] args) {
//        给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，
//        并返回他们的数组下标。
//        你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
//
//        示例:
//        给定 nums = [2, 7, 11, 15], target = 9
//        因为 nums[0] + nums[1] = 2 + 7 = 9
//        所以返回 [0, 1]

        System.out.println(Arrays.toString(
                new T001().twoSum(new int[]{2, 7, 11, 15}, 9)
        ));
    }
}
