package edu.zju.zjh.lc.bs;

/**
 * @author: zjh
 * @date : 2022/3/3 14:33
 * @Email : 2757412961@qq.com
 * @update:
 */

public class Q0154 {

    public int findMin(int[] nums) {
        int[] numbers = nums;
        int n = numbers.length;
        int left = 0, right = n - 1, mid = 0;

        while (left <= right) {
            mid = (right - left) / 2 + left;
            if (numbers[left] < numbers[right]) {
                return numbers[left];
            } else {
                if (numbers[left] < numbers[mid]) {
                    left = mid + 1;
                } else if (numbers[left] > numbers[mid]) {
                    right = mid;
                } else if (numbers[left] == numbers[mid]) {
                    left++;
                }
            }
        }

        return numbers[mid];
    }

}
