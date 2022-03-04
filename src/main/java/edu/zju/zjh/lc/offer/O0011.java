package edu.zju.zjh.lc.offer;

/**
 * @author: zjh
 * @date : 2022/3/3 14:13
 * @Email : 2757412961@qq.com
 * @update:
 */

public class O0011 {

    public int minArray(int[] numbers) {
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
