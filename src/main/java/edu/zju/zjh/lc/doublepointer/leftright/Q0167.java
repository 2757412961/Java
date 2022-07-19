package edu.zju.zjh.lc.doublepointer.leftright;

/**
 * @author: zjh
 * @date : 2022/7/18 22:24
 * @Email : 2757412961@qq.com
 * @update:
 */

public class Q0167 {

    /**
     * 执行耗时:1 ms,击败了98.92% 的Java用户
     * 内存消耗:44 MB,击败了63.14% 的Java用户
     */
    public int[] twoSum(int[] numbers, int target) {
        int l = 0, r = numbers.length - 1;

        while (l < r) {
            int sum = numbers[l] + numbers[r];
            if (sum == target) {
                return new int[]{l + 1, r + 1};
            } else if (sum > target) {
                r--;
            } else if (sum < target) {
                l++;
            }
        }

        return null;
    }

}
