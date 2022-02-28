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

    public int findKthLargest0(int[] nums, int k) {
        List<Integer> list = Arrays.stream(nums).boxed().collect(Collectors.toList());
        Queue<Integer> queue = new PriorityQueue<>((a, b) -> {
            return b - a;
        });
        queue.addAll(list);

        for (int i = 0; i < k - 1; i++) {
            queue.poll();

        }

        return queue.poll();
    }

    public int findKthLargest1(int[] nums, int k) {
        Queue<Integer> queue = new PriorityQueue<>();

        for (int i = 0; i < nums.length; i++) {
            queue.offer(nums[i]);
            if (queue.size() > k) {
                queue.poll();
            }
        }

        return queue.poll();
    }

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

    public static void main(String[] args) {
        System.out.println(new Q0215().findKthLargest(new int[]{7, 6, 5, 4, 3, 2, 1}, 5));
        System.out.println(new Q0215().findKthLargest(new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6}, 4));
    }

}
