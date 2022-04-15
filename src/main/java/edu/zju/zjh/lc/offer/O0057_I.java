package edu.zju.zjh.lc.offer;

/**
 * @author: zjh
 * @date : 2022/4/15 下午 04:22
 * @Email : 2757412961@qq.com
 * @update:
 */

public class O0057_I {

    public int[] twoSum(int[] nums, int target) {
        int l = 0, r = nums.length - 1;

        while (l < r) {
            int sum = nums[l] + nums[r];
            if (sum > target) {
                r--;
            } else if (sum < target) {
                l++;
            } else if (sum == target) {
                return new int[]{nums[l], nums[r]};
            }
        }

        return new int[]{0, 0};
    }

}
