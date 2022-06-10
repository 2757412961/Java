package edu.zju.zjh.offer;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author: zjh
 * @date : 2022/4/6 下午 09:22
 * @Email : 2757412961@qq.com
 * @update:
 */

public class O0040 {

    public int[] getLeastNumbers(int[] arr, int k) {
        int[] res = new int[k];
        Queue<Integer> heap = new PriorityQueue<>(Comparator.reverseOrder());

        for (int i = 0; i < arr.length; i++) {
            heap.offer(arr[i]);
            if (heap.size() > k) {
                heap.poll();
            }
        }

        for (int i = 0; i < k; i++) {
            res[i] = heap.poll();
        }

        return res;
    }

    public static void main(String[] args) {
        new O0040().getLeastNumbers(new int[]{0, 1, 2, 1}, 1);
    }

}
