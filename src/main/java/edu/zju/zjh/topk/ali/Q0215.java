package edu.zju.zjh.topk.ali;

import java.util.Random;

/**
 * @author: zjh
 * @date : 2022/5/10 16:23
 * @Email : 2757412961@qq.com
 * @update:
 */

public class Q0215 {

    /**
     * 快速排序
     * 执行耗时:1 ms,击败了98.60% 的Java用户
     * 内存消耗:41.1 MB,击败了97.20% 的Java用户
     */
    public void swap(int[] nums, int x, int y) {
        int temp = nums[x];
        nums[x] = nums[y];
        nums[y] = temp;
    }

    public int partition(int[] nums, int x, int y) {
        if (x >= y) return x;

        int p = x + new Random().nextInt(y - x + 1);
        swap(nums, p, x);

        int j = y;
        for (int i = x + 1; i <= j; i++) {
            if (nums[x] < nums[i]) {
                swap(nums, i--, j--);
            }
        }
        swap(nums, x, j);

        return j;
    }

    public int findKthLargest(int[] nums, int k) {
        k = nums.length - k;
        int l = 0, r = nums.length - 1, p = -1;
        while (l <= r) {
            p = partition(nums, l, r);
            if (p < k) {
                l = p + 1;
            } else if (p > k) {
                r = p - 1;
            } else {
                return nums[k];
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new Q0215().findKthLargest(new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6}, 4));
        System.out.println(new Q0215().findKthLargest(new int[]{2, 1}, 1));
        System.out.println(new Q0215().findKthLargest(new int[]{1, 2}, 1));
    }

}
