package edu.zju.zjh.lc.design.shuffle;

import java.util.Random;
import java.util.stream.IntStream;

/**
 * @author: zjh
 * @date : 2022/7/12 21:17
 * @Email : 2757412961@qq.com
 * @update:
 */

public class Q0384 {

    /**
     * 洗牌算法（随机乱置算法）
     * https://mp.weixin.qq.com/s/c00DFbvvQNCaZqTDfwBWyA
     * <p>
     * 执行耗时:47 ms,击败了95.60% 的Java用户
     * 内存消耗:47 MB,击败了76.14% 的Java用户
     */
    private class S1 {

        class Solution {

            private int[] reset;
            private int[] shuffle;

            private void swap(int[] nums, int x, int y) {
                int tmp = nums[x];
                nums[x] = nums[y];
                nums[y] = tmp;
            }

            public Solution(int[] nums) {
                this.reset = nums;
                this.shuffle = new int[nums.length];
                System.arraycopy(nums, 0, this.shuffle, 0, nums.length);
            }

            public int[] reset() {
                System.arraycopy(reset, 0, shuffle, 0, reset.length);
                return this.reset;
            }

            public int[] shuffle() {
                int n = reset.length;
                Random random = new Random();

                for (int i = 0; i < n; i++) {
                    int rand = random.nextInt(n - i) + i;
                    swap(shuffle, i, rand);
                }

                return shuffle;
            }

        }

    }

}
