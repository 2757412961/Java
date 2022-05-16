package edu.zju.zjh.lc.divideconquer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: zjh
 * @date : 2022/5/16 13:37
 * @Email : 2757412961@qq.com
 * @update:
 */

public class Q0315 {

    public void sort(int[] nums, int[] ans, int[] index, int[] temp, int[] tempIndex, int l, int r) {
        if (l >= r) return;

        int m = (r - l) / 2 + l;
        sort(nums, ans, index, temp, tempIndex, l, m);
        sort(nums, ans, index, temp, tempIndex, m + 1, r);
        merge(nums, ans, index, temp, tempIndex, l, m, r);
    }

    public void merge(int[] nums, int[] ans, int[] index, int[] temp, int[] tempIndex, int l, int m, int r) {
        int i = l, j = m + 1, k = l;

        while (i <= m && j <= r) {
            if (nums[i] <= nums[j]) {
                ans[index[i]] += j - m - 1;
                tempIndex[k] = index[i];
                temp[k++] = nums[i++];
            } else if (nums[i] > nums[j]) {
                tempIndex[k] = index[j];
                temp[k++] = nums[j++];
            }
        }
        while (i <= m) {
            ans[index[i]] += j - m - 1;
            tempIndex[k] = index[i];
            temp[k++] = nums[i++];
        }
        while (j <= r) {
            tempIndex[k] = index[j];
            temp[k++] = nums[j++];
        }

        for (k = l; k <= r; k++) {
            nums[k] = temp[k];
            index[k] = tempIndex[k];
        }
    }

    public List<Integer> countSmaller(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        int[] index = new int[n];
        int[] temp = new int[n];
        int[] tempIndex = new int[n];
        List<Integer> res = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            index[i] = i;
            tempIndex[i] = i;
        }
        sort(nums, ans, index, temp, tempIndex, 0, n - 1);

        for (int i = 0; i < n; i++) {
            res.add(ans[i]);
        }
        return res;
    }

}
