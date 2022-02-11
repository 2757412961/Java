package main.java.edu.zju.zjh.lcold;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author : Z
 * @description : TODO
 * @date : 2020/6/29 下午 09:17
 * @Modified_By :
 */
public class T215 {

    public int findKthLargest_violence(int[] nums, int k) {
        int n = nums.length;
        Queue<Integer> que = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            que.add(nums[i]);
            if (que.size() > k) {
                que.poll();

            }
        }

        return que.peek();
    }


    public int findKthLargest(int[] nums, int k) {
        int n = nums.length;
        int[] heap = new int[n + 1];
        heap[0] = Integer.MAX_VALUE;

        for (int i = 1; i <= n; i++) {
            int idx = i;
            int now = nums[i - 1];
            heap[i] = now;

            while (now > heap[idx / 2]) {
                heap[idx] = heap[idx / 2];
                idx /= 2;
            }
            heap[idx] = now;
        }

        for (int i = 0; i < k - 1; i++) {
            int j = 1, maxn = n - i;
//            heap[j] = heap[maxn];

            while (2 * j < maxn) {
                if (2 * j + 1 < maxn && heap[2 * j + 1] > heap[2 * j]) {
                    if (heap[maxn] < heap[2 * j + 1]) {
                        heap[j] = heap[2 * j + 1];
                        j = 2 * j + 1;
                    } else {
                        break;
                    }
                } else {
                    if (heap[maxn] < heap[2 * j]) {
                        heap[j] = heap[2 * j];
                        j = 2 * j;
                    } else {
                        break;
                    }
                }
            }

            heap[j] = heap[maxn];
        }

        return heap[1];
    }

    public static void main(String[] args) {
//        在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
//
//        示例 1:
//        输入: [3,2,1,5,6,4] 和 k = 2
//        输出: 5
//
//        示例 2:
//        输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
//        输出: 4
//        说明:
//
//        你可以假设 k 总是有效的，且 1 ≤ k ≤ 数组的长度。

        int[] nums = new int[]{3, 2, 1, 5, 6, 4};
        int k = 5;

        System.out.println(new T215().findKthLargest(nums, k));
        System.out.println(new T215().findKthLargest_violence(nums, k));
    }
}
