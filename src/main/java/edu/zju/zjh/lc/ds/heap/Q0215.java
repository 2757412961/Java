package edu.zju.zjh.lc.ds.heap;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author: zjh
 * @date : 2022/2/24 15:22
 * @Email : 2757412961@qq.com
 * @update:
 */

public class Q0215 {

    /**
     * 堆排序
     */
    private class S1 {

        public int findKthLargest(int[] nums, int k) {
            Queue<Integer> queue = new PriorityQueue<>();

            for (int i = 0; i < nums.length; i++) {
                queue.offer(nums[i]);
                if (queue.size() > k) {
                    queue.poll();
                }
            }

            return queue.poll();
        }

    }

    /**
     * 快速排序
     */
    private class S2 {

        public void swap(int[] nums, int x, int y) {
            int temp = nums[x];
            nums[x] = nums[y];
            nums[y] = temp;
        }

        int partition(int[] nums, int lo, int hi) {
            if (lo == hi) return lo;
            // 将 nums[lo] 作为默认分界点 pivot
            int pivot = nums[lo];
            // j = hi + 1 因为 while 中会先执行 --
            int i = lo, j = hi + 1;
            while (true) {
                // 保证 nums[lo..i] 都小于 pivot
                while (nums[++i] < pivot) {
                    if (i == hi) break;
                }
                // 保证 nums[j..hi] 都大于 pivot
                while (nums[--j] > pivot) {
                    if (j == lo) break;
                }
                if (i >= j) break;
                // 如果走到这里，一定有：
                // nums[i] > pivot && nums[j] < pivot
                // 所以需要交换 nums[i] 和 nums[j]，
                // 保证 nums[lo..i] < pivot < nums[j..hi]
                swap(nums, i, j);
            }
            // 将 pivot 值交换到正确的位置
            swap(nums, j, lo);
            // 现在 nums[lo..j-1] < nums[j] < nums[j+1..hi]
            return j;
        }

        public int findKthLargest(int[] nums, int k) {
            int n = nums.length;
            int left = 0, righ = n - 1;
            while (left <= righ) {
                int p = partition(nums, left, righ);
                if (p == n - k) {
                    return nums[n - k];
                } else if (p > n - k) {
                    righ = p - 1;
                } else if (p < n - k) {
                    left = p + 1;
                }
            }

            return -1;
        }

    }

    /**
     * 快速排序
     * 执行耗时:1 ms,击败了98.60% 的Java用户
     * 内存消耗:41.1 MB,击败了97.20% 的Java用户
     */
    public class S3 {

        public void swap(int[] nums, int x, int y) {
            int temp = nums[x];
            nums[x] = nums[y];
            nums[y] = temp;
        }

        public int partition(int[] nums, int x, int y) {
            if (x >= y) return x;

            int p = x + new Random().nextInt(y - x + 1);
            swap(nums, p, x);

            int j = y;
            for (int i = x + 1; i <= j; i++) {
                if (nums[x] < nums[i]) {
                    swap(nums, i--, j--);
                }
            }
            swap(nums, x, j);

            return j;
        }

        public int findKthLargest(int[] nums, int k) {
            k = nums.length - k;
            int l = 0, r = nums.length - 1, p = -1;
            while (l <= r) {
                p = partition(nums, l, r);
                if (p < k) {
                    l = p + 1;
                } else if (p > k) {
                    r = p - 1;
                } else {
                    return nums[k];
                }
            }

            return -1;
        }

    }

    public static void main(String[] args) {
        System.out.println(new Q0215().new S1().findKthLargest(new int[]{7, 6, 5, 4, 3, 2, 1}, 5));
        System.out.println(new Q0215().new S2().findKthLargest(new int[]{7, 6, 5, 4, 3, 2, 1}, 5));
        System.out.println(new Q0215().new S3().findKthLargest(new int[]{7, 6, 5, 4, 3, 2, 1}, 5));

        System.out.println(new Q0215().new S1().findKthLargest(new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6}, 4));
        System.out.println(new Q0215().new S2().findKthLargest(new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6}, 4));
        System.out.println(new Q0215().new S3().findKthLargest(new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6}, 4));

        System.out.println(new Q0215().new S1().findKthLargest(new int[]{2, 1}, 1));
        System.out.println(new Q0215().new S2().findKthLargest(new int[]{2, 1}, 1));
        System.out.println(new Q0215().new S3().findKthLargest(new int[]{2, 1}, 1));
    }


}
