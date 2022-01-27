package edu.zju.zjh.lcold;

import java.util.Arrays;

public class T912 {
    public void swap(int[] nums, int s1, int s2) {
        int temp = nums[s1];
        nums[s1] = nums[s2];
        nums[s2] = temp;
    }

    public void quickSort_01(int[] nums, int sta, int end) {
        if (end <= sta) {
            return;
        }

//        int mid = (sta + end) / 2;
//        int base = nums[mid];
//        swap(nums, sta, mid);

        int base = nums[sta];

        int l = sta + 1;
        int r = end;

        while (true) {
            while (nums[r] >= base && r > sta) {
                r--;
            }

            while (nums[l] <= base && l < end) {
                l++;
            }

            if (l >= r) break;

            swap(nums, l, r);
        }
        swap(nums, sta, r);

        quickSort(nums, sta, r - 1);
        quickSort(nums, r + 1, end);

    }

    public void quickSort(int[] nums, int sta, int end) {
        if (sta >= end) return;

        int midIndex = (sta + end) / 2;
        int base = nums[midIndex];
        swap(nums, sta, midIndex);

        int mid = sta ;

        for (int i = sta + 1; i <= end; i++) {
            if (nums[i] <= base) {
                swap(nums, i, ++mid);
            }
        }
        swap(nums, sta, mid);

        quickSort(nums, sta, mid - 1);
        quickSort(nums, mid + 1, end);
    }

    public int[] sortArray(int[] nums) {
        quickSort(nums, 0, nums.length - 1);

        return nums;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{5, 2, 3, 1};

        System.out.println(Arrays.toString(new T912().sortArray(nums)));
    }
}
