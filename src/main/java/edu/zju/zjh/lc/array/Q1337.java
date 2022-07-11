package edu.zju.zjh.lc.array;

import java.util.PriorityQueue;

/**
 * @author: zjh
 * @date : 2022/7/11 10:59
 * @Email : 2757412961@qq.com
 * @update:
 */

public class Q1337 {

    /**
     * 方法一：堆
     * 执行耗时:2 ms,击败了50.46% 的Java用户
     * 内存消耗:42.6 MB,击败了40.77% 的Java用户
     */
    private class S1 {

        public int[] kWeakestRows(int[][] mat, int k) {
            int[] res = new int[k];
            int[] arr = new int[mat.length];
            PriorityQueue<Integer> heap = new PriorityQueue<Integer>(k + 1, (i, j) -> {
                if (arr[i] == arr[j]) {
                    return j - i;
                }

                return arr[j] - arr[i];
            });

            for (int i = 0; i < mat.length; i++) {
                for (int j = 0; j < mat[0].length; j++) {
                    arr[i] += mat[i][j];
                }

                heap.offer(i);
                if (heap.size() > k) {
                    heap.poll();
                }
            }

            for (int i = heap.size() - 1; i >= 0; i--) {
                res[i] = heap.poll();
            }

            return res;
        }

    }

    /**
     * 方法一：二分查找 + 堆
     */

}
