package edu.zju.zjh.offer;

/**
 * @author: zjh
 * @date : 2022/3/3 14:13
 * @Email : 2757412961@qq.com
 * @update:
 */

public class O0011 {

    /**
     * 方法一：二分查找
     */
    private class S1 {

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

    /**
     * 二刷
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:41.5 MB,击败了10.36% 的Java用户
     */
    private class S2 {

        public int minArray(int[] numbers) {
            int l = 0, r = numbers.length - 1, m = -1;

            while (l < r) {
                m = l + (r - l) / 2;
                if (numbers[l] < numbers[r]) return numbers[l];
                if (numbers[l] == numbers[m]) {
                    l++;
                } else if (numbers[l] > numbers[m]) {
                    r = m;
                } else if (numbers[l] < numbers[m]) {
                    l = m + 1;
                }
            }

            return numbers[l];
        }

    }

}
