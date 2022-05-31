package edu.zju.zjh.lc.array;

import java.util.Arrays;

/**
 * @author: zjh
 * @date : 2022/5/31 19:05
 * @Email : 2757412961@qq.com
 * @update:
 */

public class Q0189 {

    /**
     * 方法一：使用额外的数组
     */

    /**
     * 方法二：环状替换
     * <p>
     * 执行耗时:1 ms,击败了65.39% 的Java用户
     * 内存消耗:57.2 MB,击败了17.13% 的Java用户
     */
    public void rotate(int[] nums, int k) {
        int n = nums.length, count = n;
        k = k % n;

        for (int i = 0; count > 0 && i < n; i++) {
            int start = i, j = i;
            int temp = nums[i], now = -1;
            do {
                j = (j + k) % n;
                now = nums[j];
                nums[j] = temp;
                temp = now;
                count--;
            } while (count > 0 && j != start);
        }
    }

    /**
     * 方法三：数组翻转
     */

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        new Q0189().rotate(nums, 3);
        Arrays.stream(nums).forEach(System.out::print);
    }

}
