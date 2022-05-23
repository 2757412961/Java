package edu.zju.zjh.lc.binarysearch;

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

    /**
     * 二刷
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:41.3 MB,击败了17.92% 的Java用户
     */
    public int minArrayTwo(int[] numbers) {
        int l = 0, r = numbers.length - 1, m = 0;

        while (l < r && numbers[l] >= numbers[r]) {
            m = l + (r - l) / 2;
            if (numbers[m] > numbers[l]) {
                l = m + 1;
            } else if (numbers[m] < numbers[l]) {
                r = m;
            } else if (numbers[m] == numbers[l]) {
                l++;
            }
        }

        return numbers[l];
    }

}
