package edu.zju.zjh.offer;

/**
 * @author: zjh
 * @date : 2022/3/9 15:15
 * @Email : 2757412961@qq.com
 * @update:
 */

public class O0051 {

    private class S1 {

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

    }

    /**
     * 二刷
     * 执行耗时:37 ms,击败了15.58% 的Java用户
     * 内存消耗:49.7 MB,击败了19.93% 的Java用户
     */
    private class S2 {

        public int dc(int[] nums, int[] tmp, int l, int m, int r) {
            if (l >= r) return 0;

            // divide and conquer
            int res = dc(nums, tmp, l, (l + m) / 2, m) + dc(nums, tmp, m + 1, (m + 1 + r) / 2, r);

            // calculate
            int i = l, j = m + 1, p = l;
            while (i <= m && j <= r) {
                if (nums[i] > nums[j]) {
                    tmp[p++] = nums[j++];
                } else if (nums[i] <= nums[j]) {
                    tmp[p++] = nums[i++];
                    res += j - m - 1;
                }
            }
            while (i <= m) {
                tmp[p++] = nums[i++];
                res += j - m - 1;
            }
            while (j <= r) {
                tmp[p++] = nums[j++];
            }

            // copy
            for (int k = l; k <= r; k++) {
                nums[k] = tmp[k];
            }

            return res;
        }

        public int reversePairs(int[] nums) {
            int n = nums.length;
            return dc(nums, new int[n], 0, (n - 1) / 2, n - 1);
        }

    }

    public static void main(String[] args) {
        System.out.println(new O0051().new S1().reversePairs(new int[]{7, 5, 6, 4}));
        System.out.println(new O0051().new S1().reversePairs(new int[]{7, 7, 7, 7}));
        System.out.println(new O0051().new S1().reversePairs(new int[]{7, 5, 6, 4, 5, 4, 6, 8, 2, 3, 4, 6}));

        System.out.println(new O0051().new S2().reversePairs(new int[]{7, 5, 6, 4}));
        System.out.println(new O0051().new S2().reversePairs(new int[]{7, 7, 7, 7}));
        System.out.println(new O0051().new S2().reversePairs(new int[]{7, 5, 6, 4, 5, 4, 6, 8, 2, 3, 4, 6}));
    }

}
