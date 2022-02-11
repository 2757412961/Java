package main.java.edu.zju.zjh.lcold;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class T995 {
    public int minKBitFlips(int[] A, int K) {
        int res = 0;
        Queue<Integer> que = new LinkedList<>();

        for (int i = 0; i < A.length - K + 1; i++) {
            if (!que.isEmpty() && que.peek() + K <= i) {
                que.poll();
            }

            if (que.size() % 2 == A[i]) {
                que.add(i);
                res++;
            }
        }

        for (int i = A.length - K + 1; i < A.length; i++) {
            if (!que.isEmpty() && que.peek() + K <= i) {
                que.poll();
            }

            if (que.size() % 2 == A[i]) {
                return -1;
            }
        }

        return res;
    }

    public int minKBitFlips_violence(int[] A, int K) {
        int res = 0;
        int n = A.length;

        for (int i = 0; i < n - K + 1; i++) {
            if (A[i] == 0) {
                for (int j = 0; j < K; j++) {
                    A[i + j] = 1 - A[i + j];
                }
                res++;
            }
        }

        System.out.println(Arrays.toString(A));
        for (int i = n - K + 1; i < n; i++) {
            if (A[i] == 0) {
                return -1;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[] A = new int[]{0, 0, 0, 1, 0, 1, 1, 0};
        int K = 3;
//        int[] A = new int[]{1, 1, 1, 1, 1, 1};
//        int K = 3;

        System.out.println(new T995().minKBitFlips(A, K));
        System.out.println(new T995().minKBitFlips_violence(A, K));
    }

}
