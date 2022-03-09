package edu.zju.zjh.lc.divideconquer;

/**
 * @author: zjh
 * @date : 2022/3/9 15:15
 * @Email : 2757412961@qq.com
 * @update:
 */

public class O0051 {

    public int merge(int[] nums, int l, int r, int mid) {
        int[] temp = new int[r - l + 1];
        int p = 0, i = l, j = mid + 1;
        int times = 0;

        while (i <= mid && j <= r) {
            if (nums[i] <= nums[j]) {
                temp[p++] = nums[i++];
            } else {
                times += mid - i + 1;
                temp[p++] = nums[j++];
            }
        }
        while (i <= mid) {
            temp[p++] = nums[i++];
        }
        while (j <= r) {
            temp[p++] = nums[j++];
        }

        for (p = 0; p < temp.length; p++) {
            nums[l + p] = temp[p];
        }

        return times;
    }

    public int mergeSort(int[] nums, int l, int r) {
        if (l >= r) {
            return 0;
        }

        int mid = l + (r - l) / 2;
        int left = mergeSort(nums, l, mid);
        int right = mergeSort(nums, mid + 1, r);

        int m = merge(nums, l, r, mid);

        return left + right + m;
    }

    public int reversePairs(int[] nums) {
        return mergeSort(nums, 0, nums.length - 1);
    }

    public static void main(String[] args) {
        System.out.println(new O0051().reversePairs(new int[]{7, 5, 6, 4}));
    }

}
