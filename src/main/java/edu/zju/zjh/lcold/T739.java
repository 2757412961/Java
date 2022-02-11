package main.java.edu.zju.zjh.lcold;

import java.util.Arrays;
import java.util.Stack;

public class T739 {

    public int[] dailyTemperatures(int[] T) {
        int n = T.length;
        int[] res = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            int num = T[i];

            while (!stack.isEmpty() && num > T[stack.peek()]) {
                int idx = stack.pop();
                res[idx] = i -  idx;
            }
            stack.push(i);
        }


        return res;
    }

    public int[] dailyTemperatures_violence(int[] T) {
        int n = T.length;
        int[] res = new int[n];

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (T[j] > T[i]) {
                    res[i] = j - i;
                    break;
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
//        73, 74, 75, 71, 69, 72, 76, 73
//        1, 1, 4, 2, 1, 1, 0, 0

        int[] T = new int[]{73, 74, 75, 71, 69, 72, 76, 73};

        System.out.println(Arrays.toString(new T739().dailyTemperatures(T)));
        System.out.println(Arrays.toString(new T739().dailyTemperatures_violence(T)));
    }
}
