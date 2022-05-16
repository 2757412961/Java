package edu.zju.zjh.lc.divideconquer;

/**
 * @author: zjh
 * @date : 2022/5/16 16:11
 * @Email : 2757412961@qq.com
 * @update:
 */

public class Q0493 {

    private int res = 0;

    public void sort(int[] nums, int[] temp, int l, int r) {
        if (l >= r) return;

        int m = (r - l) / 2 + l;
        sort(nums, temp, l, m);
        sort(nums, temp, m + 1, r);
        merge(nums, temp, l, m, r);
    }

    public void merge(int[] nums, int[] temp, int l, int m, int r) {
        for (int i = l, j = m + 1; i <= m && j <= r; ) {
            if (((long) (nums[i])) > ((long) (nums[j] * 2L))) {
                res += m - i + 1;
                j++;
            } else {
                i++;
            }
        }

        for (int i = l, j = m + 1, k = l; k <= r; k++) {
            if (i == m + 1) {
                temp[k] = nums[j++];
            } else if (j == r + 1) {
                temp[k] = nums[i++];
            } else {
                if (nums[i] <= nums[j]) {
                    temp[k] = nums[i++];
                } else if (nums[i] > nums[j]) {
                    temp[k] = nums[j++];
                }
            }
        }

        for (int k = l; k <= r; k++) {
            nums[k] = temp[k];
        }
    }

    public int reversePairs(int[] nums) {
        int n = nums.length;
        int[] temp = new int[n];

        sort(nums, temp, 0, n - 1);
        return res;
    }

}
