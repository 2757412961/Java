package main.java.edu.zju.zjh.lcold;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class T239 {
    public int[] maxSlidingWindow_violence(int[] nums, int k) {
        int n = nums.length;
        int[] res = new int[n - k + 1];

        Queue<Integer> maxHeap = new PriorityQueue<>(k, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });


        for (int i = 0; i < k; i++) {
            maxHeap.add(nums[i]);
        }


        res[0] = maxHeap.peek();
        for (int i = k; i < n; i++) {
            maxHeap.remove(nums[i - k]);
            maxHeap.add(nums[i]);
            res[i - k + 1] = maxHeap.peek();
        }


        return res;
    }


    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        if (n <= 0 || k <= 0) return nums;

        int[] res = new int[n - k + 1];
        int maxIndex = 0;

        for (int i = 0; i < k - 1; i++) {
            if (nums[maxIndex] < nums[i]) {
                maxIndex = i;
            }
        }

        for (int i = k - 1; i < n; i++) {
            if (nums[i] > nums[maxIndex]) {
                maxIndex = i;
            } else if (i - maxIndex + 1 > k) {
                maxIndex = i;
                for (int j = i - k + 1; j < i; j++) {
                    if (nums[j] > nums[maxIndex]) {
                        maxIndex = j;
                    }
                }
            }

            res[i - k + 1] = nums[maxIndex];
        }


        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, -1};
//        [3,3,5,5,6,7]

        System.out.println(Arrays.toString(new T239().maxSlidingWindow(nums, 1)));
        System.out.println(Arrays.toString(new T239().maxSlidingWindow_violence(nums, 3)));
    }
}
