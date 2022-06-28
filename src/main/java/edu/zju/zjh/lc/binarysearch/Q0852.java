package edu.zju.zjh.lc.binarysearch;

/**
 * @author: zjh
 * @date : 2022/6/28 16:46
 * @Email : 2757412961@qq.com
 * @update:
 */

public class Q0852 {

    /**
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:41.9 MB,击败了14.16% 的Java用户
     */
    public int peakIndexInMountainArray(int[] arr) {
        int l = 1, r = arr.length - 2;

        while (l <= r) {
            int m = l + (r - l) / 2;
            if (arr[m - 1] < arr[m] && arr[m] > arr[m + 1]) {
                return m;
            } else if (arr[m - 1] < arr[m] && arr[m] < arr[m + 1]) {
                l = m + 1;
            } else if (arr[m - 1] > arr[m] && arr[m] > arr[m + 1]) {
                r = m - 1;
            }
        }

        return -1;
    }

}
