package edu.zju.zjh.lc.sort.quicksort;

import java.util.Arrays;
import java.util.Random;

/**
 * @author: zjh
 * @date : 2022/2/28 9:00
 * @Email : 2757412961@qq.com
 * @update:
 */

public class Q0912_quick_sort {

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public int partition(int[] nums, int left, int right) {
        if (left >= right) return right;
        int random = new Random().nextInt(right - left + 1) + left;
        swap(nums, left, random);

        int povit = nums[left];
        int index = left;

        for (int i = left; i <= right; i++) {
            if (nums[i] < povit) {
                index++;
                swap(nums, index, i);
            }
        }
        swap(nums, left, index);

        return index;
    }

    public void sort(int[] nums, int left, int right) {
        if (left >= right) return;
        int povit = partition(nums, left, right);

        sort(nums, left, povit - 1);
        sort(nums, povit + 1, right);
    }

    public int[] sortArray(int[] nums) {
        sort(nums, 0, nums.length - 1);
        return nums;
    }

    public static void main(String[] args) {
        Arrays.stream(new Q0912_quick_sort().sortArray(new int[]{5, 1, 1, 2, 0, 0})).forEach(System.out::println);
        Arrays.stream(new Q0912_quick_sort().sortArray(new int[]{7, 6, 5, 4, 3, 2, 1})).forEach(System.out::println);
    }

}
