package edu.zju.zjh.offer;

import java.util.*;

/**
 * @author: zjh
 * @date : 2022/7/9 10:57
 * @Email : 2757412961@qq.com
 * @update:
 */

public class M0040 {

    /**
     * 方法一：排序
     * 作者：LeetCode-Solution
     * 链接：https://leetcode.cn/problems/zui-xiao-de-kge-shu-lcof/solution/zui-xiao-de-kge-shu-by-leetcode-solution/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    private class S1 {

        class Solution {
            public int[] getLeastNumbers(int[] arr, int k) {
                int[] vec = new int[k];
                Arrays.sort(arr);
                for (int i = 0; i < k; ++i) {
                    vec[i] = arr[i];
                }
                return vec;
            }
        }

    }

    /**
     * 方法二：堆
     */
    private class S2 {

        class Solution {
            public int[] getLeastNumbers(int[] arr, int k) {
                int[] vec = new int[k];
                if (k == 0) { // 排除 0 的情况
                    return vec;
                }
                PriorityQueue<Integer> queue = new PriorityQueue<Integer>(new Comparator<Integer>() {
                    public int compare(Integer num1, Integer num2) {
                        return num2 - num1;
                    }
                });
                for (int i = 0; i < k; ++i) {
                    queue.offer(arr[i]);
                }
                for (int i = k; i < arr.length; ++i) {
                    if (queue.peek() > arr[i]) {
                        queue.poll();
                        queue.offer(arr[i]);
                    }
                }
                for (int i = 0; i < k; ++i) {
                    vec[i] = queue.poll();
                }
                return vec;
            }
        }

    }

    /**
     * 方法三：快排思想
     */
    private class S3 {

        class Solution {
            public int[] getLeastNumbers(int[] arr, int k) {
                randomizedSelected(arr, 0, arr.length - 1, k);
                int[] vec = new int[k];
                for (int i = 0; i < k; ++i) {
                    vec[i] = arr[i];
                }
                return vec;
            }

            private void randomizedSelected(int[] arr, int l, int r, int k) {
                if (l >= r) {
                    return;
                }
                int pos = randomizedPartition(arr, l, r);
                int num = pos - l + 1;
                if (k == num) {
                    return;
                } else if (k < num) {
                    randomizedSelected(arr, l, pos - 1, k);
                } else {
                    randomizedSelected(arr, pos + 1, r, k - num);
                }
            }

            // 基于随机的划分
            private int randomizedPartition(int[] nums, int l, int r) {
                int i = new Random().nextInt(r - l + 1) + l;
                swap(nums, r, i);
                return partition(nums, l, r);
            }

            private int partition(int[] nums, int l, int r) {
                int pivot = nums[r];
                int i = l - 1;
                for (int j = l; j <= r - 1; ++j) {
                    if (nums[j] <= pivot) {
                        i = i + 1;
                        swap(nums, i, j);
                    }
                }
                swap(nums, i + 1, r);
                return i + 1;
            }

            private void swap(int[] nums, int i, int j) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
        }

    }

}
